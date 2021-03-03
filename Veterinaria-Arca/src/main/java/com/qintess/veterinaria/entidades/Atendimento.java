package com.qintess.veterinaria.entidades;


import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;


@Entity
//@NoArgsConstructor
@Getter @Setter
public class Atendimento {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAtendimento;
	
	@OneToOne
	public Veterinario veterinario;
	
	@ManyToOne
	public Animal animal;
	
	@OneToOne
	public Cliente nomeDono;
	
	public String cpfDono;
	
	public String outrasInformacoes;
	
	private LocalDate dataAtendimento;
	

	public Atendimento() {}


	public Atendimento(int idAtendimento, Veterinario veterinario, Animal animal, Cliente nomeDono, String cpfDono,
			String outrasInformacoes, LocalDate dataAtendimento) {
		this.idAtendimento = idAtendimento;
		this.veterinario = veterinario;
		this.animal = animal;
		this.nomeDono = nomeDono;
		this.cpfDono = cpfDono;
		this.outrasInformacoes = outrasInformacoes;
		this.dataAtendimento = dataAtendimento;
	}



	
	

}
