package com.project.scn.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	SecurityFilter securityFilter;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.csrf(AbstractHttpConfigurer::disable)
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(
						authorize -> authorize.requestMatchers(HttpMethod.POST, "/usuario/cadastrarUsuario")
								.permitAll().requestMatchers(HttpMethod.POST, "/autenticar").permitAll()
								.requestMatchers(HttpMethod.POST, "/semestre/salvarSemestre").hasRole("ADMIN")
								.requestMatchers(HttpMethod.GET, "/semestre/ultimoSemestre").hasRole("ADMIN")
								.requestMatchers(HttpMethod.GET, "/usuario/listarUsuarios").hasRole("FUNCIONARIO")
								.requestMatchers(HttpMethod.PATCH, "/usuario/alterarStatusUsuario").hasRole("FUNCIONARIO")
								.requestMatchers(HttpMethod.POST, "/trabalho/cadastrarTrabalho").hasRole("ALUNO")
								.requestMatchers(HttpMethod.GET, "/trabalho/listarTrabalhos").hasRole("ALUNO")
								.requestMatchers(HttpMethod.POST, "/avaliacao/cadastrarAvaliacao").hasRole("ALUNO")
								.requestMatchers(HttpMethod.GET, "/avaliacao/listarAvaliacoes").hasRole("ALUNO")
								.requestMatchers(HttpMethod.POST, "/curso/cadastrarCurso").hasRole("ALUNO")
								.requestMatchers(HttpMethod.GET, "/curso/listarCursos").hasAnyRole("ALUNO", "FUNCIONARIO")
								.requestMatchers(HttpMethod.POST, "/disciplina/cadastrarDisciplina").hasRole("FUNCIONARIO")
								.requestMatchers(HttpMethod.GET, "/disciplina/listarDisciplinas").hasAnyRole("ALUNO", "FUNCIONARIO")
								.requestMatchers(HttpMethod.GET, "/disciplina/buscarDisciplinaPorNome/**").hasAnyRole("ALUNO", "FUNCIONARIO")
								.requestMatchers(HttpMethod.GET, "/disciplina/buscarDisciplinaPorNome/**").hasAnyRole("ALUNO", "FUNCIONARIO")
								.requestMatchers(HttpMethod.POST, "/grade/cadastrarGrade").hasRole("FUNCIONARIO")
								.requestMatchers(HttpMethod.GET, "/grade/listarGrades").hasAnyRole("ALUNO", "FUNCIONARIO")
								.anyRequest().authenticated())
				.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class).build();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}