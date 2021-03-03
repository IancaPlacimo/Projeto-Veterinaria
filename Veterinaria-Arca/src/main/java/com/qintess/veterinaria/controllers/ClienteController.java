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
import com.qintess.veterinaria.controllers.dto.ClienteDto;
import com.qintess.veterinaria.entidades.Cliente;
import com.qintess.veterinaria.repositorios.ClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteRepository clienteRepository;
	

			
	@RequestMapping("/novo")
	public String novo(Model model) {
		
		model.addAttribute("cliente", new ClienteDto());
		model.addAttribute("clientes",  retornaClientesDto());
	
		return "cliente/cadastraPetClient";
	}
				
		private List<ClienteDto> retornaClientesDto() {
			var clienteDto= new ArrayList<ClienteDto>();
			
			clienteRepository.findAll().forEach(c -> {
				clienteDto.add(new ClienteDto(c));
			});
			
			return clienteDto;
	}	

	@PostMapping("/cadastra")
	public String cadastra(ClienteDto clienteDto) {
		
		Cliente cliente = clienteDto.converter();		
		
		clienteRepository.save(cliente);		
		return"redirect:/";
	}
	@GetMapping("/deleta/{id}")
	public String deleta(@PathVariable int id) {
		
		clienteRepository.deleteById(id);
		
		return "redirect:/";	
	}
	
	@GetMapping("/edita/{id}")
	public String edita(@PathVariable int id, Model model) {
		
	var clienteOptional = clienteRepository.findById(id);
	
	if(clienteOptional.isPresent()) {
		var cliente = clienteOptional.get();	
		var clienteDto = new ClienteDto(cliente);		
		model.addAttribute("cliente", clienteDto);		
	}	
		return "cliente/cadastraPetClient";	
		}	
	
}
