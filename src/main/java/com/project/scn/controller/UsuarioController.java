package com.project.scn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.scn.DTO.AlunoStatusRequestDTO;
import com.project.scn.domain.Usuario;
import com.project.scn.service.UsuarioService;

@RestController
@CrossOrigin("*")
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
 
    @PostMapping("cadastrarUsuario")
    public ResponseEntity<?> cadastrarAluno(@RequestBody Usuario usuario) {
    	try {
    		return ResponseEntity.ok(usuarioService.cadastrarUsuario(usuario));
    	} catch (Exception e) {
    		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
    	}
    }

    @GetMapping("listarUsuarios")
    public List<Usuario> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @PatchMapping("alterarStatusUsuario")
    public ResponseEntity<String> alterarStatusAluno(@RequestBody AlunoStatusRequestDTO usuario) {
        try {
            usuarioService.alterarStatusUsuario(usuario);
            return ResponseEntity.ok("Status do usuario alterado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao alterar o status do usuario: " + e.getMessage());
        }
    }

}