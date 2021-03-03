package com.qintess.veterinaria.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qintess.veterinaria.controllers.dto.AnimalDto;
import com.qintess.veterinaria.controllers.dto.ClienteDto;
import com.qintess.veterinaria.entidades.Animal;
import com.qintess.veterinaria.entidades.Cliente;
import com.qintess.veterinaria.repositorios.AnimalRepository;
import com.qintess.veterinaria.repositorios.ClienteRepository;


@Controller
@RequestMapping("/animal")
public class AnimalController {


	@Autowired
	AnimalRepository animalRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
			
	@RequestMapping("/novo")
	public String novo(Model model) {
		
		model.addAttribute("animal", new AnimalDto());
		model.addAttribute("animais",  retornaAnimaisDto());
		model.addAttribute("clientes_cadastrados", retornaClientesDto());
	
		return "animal/cadastraAnimal";
	}
				
		private List<AnimalDto> retornaAnimaisDto() {
			var animalDto= new ArrayList<AnimalDto>();
			
			animalRepository.findAll().forEach(a -> {
				animalDto.add(new AnimalDto(a));
			});
			
			return animalDto;
	}	
		@PostMapping("/cadastra")
		public String cadastra(AnimalDto animalDto) {
			
			Animal animal = animalDto.converter();
			
			
			animalRepository.save(animal);
			
			return"redirect:/";
		}
		@GetMapping("/deleta/{id}")
		public String deleta(@PathVariable int id) {
			
			animalRepository.deleteById(id);
			
			return "redirect:/";	
		}
		
		@GetMapping("/edita/{id}")
		public String edita(@PathVariable int id, Model model) {
			
		var animalOptional = animalRepository.findById(id);
		
		if(animalOptional.isPresent()) {
			var animal = animalOptional.get();	
			var animalDto = new AnimalDto(animal);		
			model.addAttribute("animal", animalDto);		
		}	
			return "animal/cadastraAnimal";	
			}	
		
		private List<ClienteDto> retornaClientesDto() {
					
			var clienteDto= new ArrayList<ClienteDto>();						
			clienteRepository.findAll().forEach(c -> {
				clienteDto.add(new ClienteDto(c));
			});
			
			return clienteDto;
		
		}		
}
