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
import com.qintess.veterinaria.controllers.dto.ConsultaDto;
import com.qintess.veterinaria.controllers.dto.VeterinarioDto;
import com.qintess.veterinaria.entidades.Animal;
import com.qintess.veterinaria.entidades.Consulta;
import com.qintess.veterinaria.repositorios.AnimalRepository;
import com.qintess.veterinaria.repositorios.ConsultaRepository;
import com.qintess.veterinaria.repositorios.VeterinarioRepository;

@Controller
@RequestMapping("/consulta")
public class ConsultaController {

	
	@Autowired
	ConsultaRepository consultaRepository;
	
	@Autowired
	AnimalRepository animalRepository;
	
	@Autowired
	 VeterinarioRepository veterinarioRepository;
	
	@RequestMapping("/novo")
	public String novo(Model model) {
		
		model.addAttribute("consulta", new ConsultaDto());
		model.addAttribute("consultas", retornaConsultaDto());
		model.addAttribute("animais_r",  retornaAnimaisDto());
		model.addAttribute("veterinarios_r", retornaVeterinariosDto());
			
		return "consulta/cadastra";
	}
	
	private List<ConsultaDto> retornaConsultaDto() {
		var consultaDto= new ArrayList<ConsultaDto>();
		
		consultaRepository.findAll().forEach(a -> {
			consultaDto.add(new ConsultaDto(a));
		});
		
		return consultaDto;
}	
	@PostMapping("/cadastra")
	public String cadastra(ConsultaDto consultaDto) {
		
		Consulta consulta = consultaDto.converter();
		
		consultaRepository.save(consulta);		
		return"redirect:/";
	}
	
	@GetMapping("/deleta/{id}")
	public String deleta(@PathVariable int id) {
		
		consultaRepository.deleteById(id);
		
		return "redirect:/";	
	}
	@GetMapping("/edita/{id}")
	public String edita(@PathVariable int id, Model model) {
		
	var consultaOptional = consultaRepository.findById(id);
	
	if(consultaOptional.isPresent()) {
		var consulta = consultaOptional.get();	
		var consultaDto = new ConsultaDto(consulta);		
		model.addAttribute("consulta", consultaDto);		
	}	
		return "consulta/cadastra";	
		}	
	
	private List<AnimalDto> retornaAnimaisDto() {
		var animalDto= new ArrayList<AnimalDto>();
		
		animalRepository.findAll().forEach(a -> {
			animalDto.add(new AnimalDto(a));
		});
		
		return animalDto;
}	
	
		private List<VeterinarioDto>  retornaVeterinariosDto(){
		
		var veterinarioDto= new ArrayList<VeterinarioDto>();
		
		veterinarioRepository.findAll().forEach(v -> {
			veterinarioDto.add(new VeterinarioDto(v));
		});
		
		return veterinarioDto;
	}	

	
}
