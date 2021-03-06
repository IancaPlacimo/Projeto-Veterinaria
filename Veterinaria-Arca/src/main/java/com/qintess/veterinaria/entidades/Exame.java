package com.qintess.veterinaria.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Exame {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idExame;
	
	@OneToOne
	private Veterinario veterinario;
	
	
	@OneToOne
	private Animal animal;
	

		
	private String descricao;	
	private String valor;
	private String idAnimal;
	
	
	

}
