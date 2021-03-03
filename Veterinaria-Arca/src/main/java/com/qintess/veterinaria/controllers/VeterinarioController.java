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
import com.qintess.veterinaria.controllers.dto.VeterinarioDto;
import com.qintess.veterinaria.entidades.Veterinario;
import com.qintess.veterinaria.repositorios.VeterinarioRepository;

@Controller
@RequestMapping("/veterinario")
public class VeterinarioController {
	
	@Autowired
	 VeterinarioRepository veterinarioRepository;
	
	
	@RequestMapping("/novo")
	public String novo(Model model) {
		
		model.addAttribute("veterinario",  new VeterinarioDto());		
		model.addAttribute("veterinarios", retornaVeterinariosDto());
						
		return "veterinario/cadastraVet";
	}
	
	private List<VeterinarioDto>  retornaVeterinariosDto(){
		
		var veterinarioDto= new ArrayList<VeterinarioDto>();
		
		veterinarioRepository.findAll().forEach(v -> {
			veterinarioDto.add(new VeterinarioDto(v));
		});
		
		return veterinarioDto;
	}	

	@PostMapping("/cadastra")
	public String cadastra(VeterinarioDto veterinarioDto) {
		
		Veterinario veterinario = veterinarioDto.converter();				
		veterinarioRepository.save(veterinario);
		
		return"redirect:/";
	}	

	@GetMapping("/deleta/{id}")
	public String deleta(@PathVariable int id) {
		
		veterinarioRepository.deleteById(id);
		
		return "redirect:/";	
	}
	
	@GetMapping("/edita/{id}")
	public String edita(@PathVariable int id, Model model) {
		
	var veterinarioOptional = veterinarioRepository.findById(id);
	
	if(veterinarioOptional.isPresent()) {
		var veterinario = veterinarioOptional.get();	
		var veterinarioDto = new VeterinarioDto(veterinario);		
		model.addAttribute("veterinario", veterinarioDto);		
	}	
		return "veterinario/cadastraVet";	
		}	
}
