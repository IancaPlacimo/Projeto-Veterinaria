package com.qintess.veterinaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qintess.veterinaria.controllers.dto.ApresentacaoDto;
import com.qintess.veterinaria.repositorios.ApresentacaoRepository;

@Controller
@RequestMapping("/apresentacao")
public class ApresentacaoController {
	
	@Autowired
	ApresentacaoRepository apresentacaoRepository;
	
	@RequestMapping("/novo")
	public String novo(Model model) {
		
		model.addAttribute("apresentacao", new ApresentacaoDto());
		
	
		return "apresentacao/cadastraAp";
	}
	
	
	

}
