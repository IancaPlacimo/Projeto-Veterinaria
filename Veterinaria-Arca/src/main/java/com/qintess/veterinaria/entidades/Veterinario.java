package com.qintess.veterinaria.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Veterinario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String crmv;
	
	private String especialidade;
	
	private String nomeVeterinario;
	
	private String telefone;
	
	private LocalDate dataNascimento;
	
	@Embedded
	private Endereco endereco;
	
			
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "veterinario")
	private List <Exame> exames = new ArrayList <Exame>();
		
	@ManyToMany
	private List <Atendimento> atendimentos = new ArrayList <Atendimento>();

public Veterinario(int id, String crmv, String especialidade, String nomeVeterinario, String telefone,
		LocalDate dataNascimento, Endereco endereco
		) {
	this.id = id;
	this.crmv = crmv;
	this.especialidade = especialidade;
	this.nomeVeterinario = nomeVeterinario;
	this.telefone = telefone;
	this.dataNascimento = dataNascimento;
	this.endereco = endereco;


}

@Override
public String toString() {
	return "crmv:   " + "   /  " + crmv +  "   /  " + " Dr " + nomeVeterinario + 
			"  /   " +	 especialidade ;
}




	
}
