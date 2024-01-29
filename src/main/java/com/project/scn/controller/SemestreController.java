package com.project.scn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.project.scn.service.SemestreService;

@RestController
@CrossOrigin("*")
public class SemestreController {
	
	@Autowired
	SemestreService semestreService;
	
}