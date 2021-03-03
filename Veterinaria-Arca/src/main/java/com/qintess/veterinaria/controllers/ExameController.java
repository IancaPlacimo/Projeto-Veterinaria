package com.qintess.veterinaria.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qintess.veterinaria.controllers.dto.AnimalDto;
import com.qintess.veterinaria.controllers.dto.AtendimentoDto;
import com.qintess.veterinaria.controllers.dto.ExameDto;
import com.qintess.veterinaria.controllers.dto.VeterinarioDto;
import com.qintess.veterinaria.entidades.Exame;
import com.qintess.veterinaria.entidades.Veterinario;
import com.qintess.veterinaria.repositorios.AnimalRepository;
import com.qintess.veterinaria.repositorios.ExameRepository;
import com.qintess.veterinaria.repositorios.VeterinarioRepository;


@Controller
@RequestMapping("/exame")
public class ExameController {
	
	@Autowired
	ExameRepository exameRepository;
	
	@Autowired
	 VeterinarioRepository veterinarioRepository;
	
	@Autowired
	AnimalRepository animalRepository;
	
	
	@RequestMapping("/novo")
	public String novo(Model model) {
		
		model.addAttribute("exame", new ExameDto());
		model.addAttribute("exames", retornaExameDto());
		model.addAttribute("veterinarios_r", retornaVeterinariosDto());
		model.addAttribute("animais_r",  retornaAnimaisDto());
		
		
		return "exame/cadastraExame";
	}
	
	private List<ExameDto>  retornaExameDto(){
		
		var exameDto= new ArrayList<ExameDto>();		
		exameRepository.findAll().forEach(e -> {
			exameDto.add(new ExameDto(e));
		});
		
		return exameDto;
	}
	
	
	@PostMapping("/cadastra")
	public String cadastra(ExameDto exameDto) {
		
		Exame exame = exameDto.converter();				
		exameRepository.save(exame);
		
		return"redirect:/";
	}

	
	@GetMapping("/deleta/{id}")
	public String deleta(@PathVariable int id) {
		
		exameRepository.deleteById(id);
		
		return "redirect:/";	
	}
	

	@GetMapping("/edita/{id}")
	public String edita(@PathVariable int id, Model model) {
		
	var exameOptional = exameRepository.findById(id);
	
	if(exameOptional.isPresent()) {
		var exame = exameOptional.get();	
		var exameDto = new ExameDto(exame);		
		model.addAttribute("exame", exameDto);		
	}	
		return "exame/cadastraExame";	
	}
	
private List<VeterinarioDto>  retornaVeterinariosDto(){
		
		var veterinarioDto= new ArrayList<VeterinarioDto>();
		
		veterinarioRepository.findAll().forEach(v -> {
			veterinarioDto.add(new VeterinarioDto(v));
		});
		
		return veterinarioDto;
	}	

private List<AnimalDto> retornaAnimaisDto() {
	var animalDto= new ArrayList<AnimalDto>();
	
	animalRepository.findAll().forEach(a -> {
		animalDto.add(new AnimalDto(a));
	});
	
	return animalDto;
}	
	
}