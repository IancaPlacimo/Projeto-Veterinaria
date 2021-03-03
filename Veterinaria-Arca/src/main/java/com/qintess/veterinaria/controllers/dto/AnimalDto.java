package com.qintess.veterinaria.controllers.dto;

import com.qintess.veterinaria.entidades.Animal;
import com.qintess.veterinaria.entidades.Cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class AnimalDto {

	private int idAnimal;	
	private String nomeAnimal;	
	private String racaAnimal;	
	private String idadeAnimal;
	private Cliente cliente;
	
	
	public AnimalDto(Animal a) {
		this.idAnimal = a.getIdAnimal();
		this.nomeAnimal = a.getNomeAnimal();
		this.racaAnimal = a.getRacaAnimal();
		this.idadeAnimal = a.getIdadeAnimal();
		this.cliente = a.getCliente();
	}
	
	
	public Animal converter() {
		
		return new Animal(this.idAnimal,this.nomeAnimal,this.racaAnimal,this.idadeAnimal,this.cliente);
	}
	
	
	
}
