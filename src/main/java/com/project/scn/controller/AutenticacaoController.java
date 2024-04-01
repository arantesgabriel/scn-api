package com.project.scn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.scn.DTO.UsuarioDto;
import com.project.scn.service.AutenticacaoService;

@RestController
@CrossOrigin("*")
@RequestMapping("autenticar")
public class AutenticacaoController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	AutenticacaoService autenticacaoService;
	
    @PostMapping
    public ResponseEntity<String> gerarToken(@RequestBody UsuarioDto usuarioDto){
        UsernamePasswordAuthenticationToken tokenUsuario = new UsernamePasswordAuthenticationToken(usuarioDto.getLogin(), usuarioDto.getSenha());  
        Authentication authentication = authenticationManager.authenticate(tokenUsuario);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return ResponseEntity.ok(autenticacaoService.obterToken(usuarioDto));
    }
	
}