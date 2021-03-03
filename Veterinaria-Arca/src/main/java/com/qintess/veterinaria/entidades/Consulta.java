package com.qintess.veterinaria.entidades;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Consulta {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idC;	
	
	@OneToOne
	private Veterinario veterinario; 
	
	@OneToOne	
	private Animal animal;
	
	private LocalDate dataAgendamento;
	
	private String horaAtt;
	
	private String observacoes;
	

	public Consulta(int idC, Veterinario veterinario, Animal animal, LocalDate dataAgendamento, String observacoes, String horaAtt) {
		this.idC = idC;
		this.veterinario = veterinario;
		this.animal = animal;
		this.dataAgendamento = dataAgendamento;
		this.observacoes = observacoes;
		this.horaAtt = horaAtt;
	}
	 


}
