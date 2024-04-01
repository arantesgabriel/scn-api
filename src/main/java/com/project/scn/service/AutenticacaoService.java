package com.project.scn.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.scn.DTO.UsuarioDto;

public interface AutenticacaoService extends UserDetailsService {
	
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException;
	
	public String obterToken(UsuarioDto usuarioDto);
	
	public String validaTokenJwt(String token);
	
}