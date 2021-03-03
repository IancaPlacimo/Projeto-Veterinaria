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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qintess.veterinaria.controllers.dto.AnimalDto;
import com.qintess.veterinaria.controllers.dto.AtendimentoDto;
import com.qintess.veterinaria.controllers.dto.ClienteDto;
import com.qintess.veterinaria.controllers.dto.VeterinarioDto;
import com.qintess.veterinaria.entidades.Atendimento;
import com.qintess.veterinaria.repositorios.AnimalRepository;
import com.qintess.veterinaria.repositorios.AtendimentoRepository;
import com.qintess.veterinaria.repositorios.ClienteRepository;
import com.qintess.veterinaria.repositorios.VeterinarioRepository;

@Controller
@RequestMapping("/atendimento")
public class AtendimentoController {
	
	@Autowired
	AtendimentoRepository atendimentoRepository;
	
	@Autowired
	 VeterinarioRepository veterinarioRepository;
	
	@Autowired
	AnimalRepository animalRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@RequestMapping("/novo")
	public String novo(Model model) {
		
		model.addAttribute("atendimento", new AtendimentoDto());
		model.addAttribute("atendimentos", retornaAtendimentosDto());
		model.addAttribute("veterinarios_r", retornaVeterinariosDto());
		model.addAttribute("animais_r",  retornaAnimaisDto());
		model.addAttribute("clientes_r",  retornaClientesDto());
				
		return "atendimento/cadastra";
	}
		
	private List<AtendimentoDto>  retornaAtendimentosDto(){
		
		var atendimentoDto= new ArrayList<AtendimentoDto>();
		
		atendimentoRepository.findAll().forEach(a -> {
			atendimentoDto.add(new AtendimentoDto(a));
		});
		
		return atendimentoDto;
	}

	@PostMapping("/cadastra")
	public String cadastra(@Valid AtendimentoDto atendimentoDto) {		
			
		Atendimento atendimento = atendimentoDto.converter();				
		atendimentoRepository.save(atendimento);

		return"redirect:/";
	}

	@GetMapping("/deleta/{id}")
	public String deleta(@PathVariable int id, RedirectAttributes redirectAtt) {
		
		atendimentoRepository.deleteById(id);
		
		redirectAtt.addFlashAttribute("sucesso", " Atendimento " + id + " removido com sucesso! ");
		
		return "redirect:/";	
	}
	
		@GetMapping("/edita/{id}")
		public String edita(@PathVariable int id, Model model, AtendimentoDto atendimentoDto, String data) {
			
		var atendimentoOptional = atendimentoRepository.findById(id);
		
		if(atendimentoOptional.isPresent()) {
			var atendimento = atendimentoOptional.get();	
			 atendimentoDto = new AtendimentoDto(atendimento);		
			model.addAttribute("atendimento", atendimentoDto);		
					}
				return "atendimento/cadastra";	
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
	
	
	private List<ClienteDto> retornaClientesDto() {
		var clienteDto= new ArrayList<ClienteDto>();
		
		clienteRepository.findAll().forEach(c -> {
			clienteDto.add(new ClienteDto(c));
		});
		
		return clienteDto;
}	
}
