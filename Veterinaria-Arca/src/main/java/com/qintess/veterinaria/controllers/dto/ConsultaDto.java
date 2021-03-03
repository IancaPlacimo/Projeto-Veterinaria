package com.qintess.veterinaria.controllers.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.OneToOne;

import com.qintess.veterinaria.entidades.Animal;
import com.qintess.veterinaria.entidades.Consulta;
import com.qintess.veterinaria.entidades.Veterinario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ConsultaDto {
	
	private int idC;	
	private Veterinario veterinario; 	
	private Animal animal;	
	private String dataAgendamento;	
	private String observacoes;
	private String horaAtt;
	
	
	public ConsultaDto(Consulta c) {
		
		this.idC = c.getIdC();
		this.veterinario = c.getVeterinario();
		this.animal = c.getAnimal();
		this.dataAgendamento = c.getDataAgendamento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.observacoes = c.getObservacoes();
		this.horaAtt = c.getHoraAtt();
	}
	
	
	public Consulta converter() {
		
		var ag = LocalDate.parse(this.dataAgendamento,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		 
		 return new Consulta(this.idC,this.veterinario,this.animal,ag,this.observacoes,this.horaAtt);
	 }
	
	

}
