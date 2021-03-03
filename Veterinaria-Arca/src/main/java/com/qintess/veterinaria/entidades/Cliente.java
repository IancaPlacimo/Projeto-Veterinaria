package com.qintess.veterinaria.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String cpfDono;
	
	private String nomeDono;
	
	private LocalDate dataNasc;
	
	private String telefone;
	
	@Embedded
	private Endereco endereco;
	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	private List <Animal> animais = new ArrayList <Animal>();
	
	public Cliente(int id, String cpfDono, String nomeDono, LocalDate dataNasc, String telefone, Endereco endereco) {
		this.id = id;
		this.cpfDono = cpfDono;
		this.nomeDono = nomeDono;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
		this.endereco = endereco;
	}


	
	

}
