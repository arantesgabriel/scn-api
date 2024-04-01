package com.project.scn.service.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.project.scn.DTO.UsuarioDto;
import com.project.scn.domain.Usuario;
import com.project.scn.repository.UsuarioRepository;
import com.project.scn.service.AutenticacaoService;

@Service
public class AutenticacaoServiceImpl implements AutenticacaoService {

	@Value("${api.security.token.secret}")
	private String secret;
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		return usuarioRepository.findUsuarioByLogin(login);
	}

	public String obterToken(UsuarioDto usuarioDto) {
		Usuario usuario = usuarioRepository.findUsuarioByLogin(usuarioDto.getLogin());
		return gerarTokenJwt(usuario);
	}

	private String gerarTokenJwt(Usuario usuario) {
		Algorithm algorithm = Algorithm.HMAC256(secret);
		return JWT.create()
				.withIssuer("scn-api")
				.withSubject(usuario.getLogin())
				.withExpiresAt(Date.from(gerarDataExpiracao()))
				.sign(algorithm);
	}
	
	public String validaTokenJwt(String token) {
		try {
			Algorithm augorithm = Algorithm.HMAC256(secret);
			return JWT.require(augorithm)
					.withIssuer("scn-api")
					.build()
					.verify(token)
					.getSubject();
		} catch (JWTVerificationException e ) {
			return "Não foi possível validar token";
		}
	}

	private static Instant gerarDataExpiracao() {
		return LocalDateTime.now().plusHours(8).toInstant(ZoneOffset.of("-03:00"));
	}

}