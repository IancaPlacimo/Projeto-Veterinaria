package com.qintess.veterinaria.controllers.dto;

import javax.persistence.ManyToOne;

import com.qintess.veterinaria.entidades.Animal;
import com.qintess.veterinaria.entidades.Exame;
import com.qintess.veterinaria.entidades.Veterinario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ExameDto {
	
	private int idExame;	
	private Veterinario veterinario;		
	private Animal animal;	
	private String descricao;	
	private String valor;
	private String idAnimal;
	
	
	public ExameDto(Exame e) {
		this.idExame = e.getIdExame();
		this.veterinario = e.getVeterinario();
		this.animal = e.getAnimal();
		this.descricao = e.getDescricao();
		this.valor = e.getValor();
		this.idAnimal=e.getIdAnimal();
	}
	

	public Exame converter() {
		return new Exame(this.idExame,this.veterinario,this.animal,this.descricao,this.valor,this.idAnimal);
	}
	
	
}
