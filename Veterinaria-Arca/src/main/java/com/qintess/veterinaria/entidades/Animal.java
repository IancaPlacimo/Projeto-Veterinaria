package com.qintess.veterinaria.entidades;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAnimal;
	
	private String nomeAnimal;
	
	private String racaAnimal;
	
	private String idadeAnimal;
	
	
	@ManyToOne
	private Cliente cliente;
	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "animal")
	private List <Exame> exames = new ArrayList <Exame>();
	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "animal")
	@Column(name="Atendimentos")
	private List <Atendimento> atendimentos = new ArrayList <Atendimento>();

	public Animal(int idAnimal, String nomeAnimal, String racaAnimal, String idadeAnimal, Cliente cliente) {
		this.idAnimal = idAnimal;
		this.nomeAnimal = nomeAnimal;
		this.racaAnimal = racaAnimal;
		this.idadeAnimal = idadeAnimal;
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return  nomeAnimal ;
	}
	

}
