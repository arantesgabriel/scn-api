package com.project.scn.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.project.scn.domain.Usuario;
import com.project.scn.repository.UsuarioRepository;
import com.project.scn.service.AutenticacaoService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	AutenticacaoService autenticacaoService;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String token = extraiTokenHeader(request);
		
	    if (!requerAutenticacaoJwt(request)) {
	        filterChain.doFilter(request, response);
	        return;
	    }

	    if (token == null) {
	        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	        response.setContentType("application/json");
	        response.getWriter().write("Token JWT não encontrado na requisição");
	        return;
	    }

		if (token != null) {
			String login = autenticacaoService.validaTokenJwt(token);
			Usuario usuario = usuarioRepository.findUsuarioByLogin(login);
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}

		filterChain.doFilter(request, response);
	}
	
	private boolean requerAutenticacaoJwt(HttpServletRequest request) {
	    String method = request.getMethod();
	    String path = request.getRequestURI();

	    if ((HttpMethod.POST.name().equals(method) && "/usuario/cadastrarUsuario".equals(path)) ||
	        (HttpMethod.POST.name().equals(method) && "/autenticar".equals(path))) {
	        return false; 
	    } else {
	        return true;
	    }
	}

	public String extraiTokenHeader(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");

		if (authHeader == null) {
			return null;
		}

		if (!authHeader.split(" ")[0].equals("Bearer")) {
			return null;
		}

		return authHeader.split(" ")[1];
	}

}