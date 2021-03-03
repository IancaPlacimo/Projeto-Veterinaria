package com.qintess.veterinaria.controllers.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotBlank;

import com.qintess.veterinaria.entidades.Animal;
import com.qintess.veterinaria.entidades.Atendimento;
import com.qintess.veterinaria.entidades.Cliente;
import com.qintess.veterinaria.entidades.Veterinario;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class AtendimentoDto {
	
	public int idAtendimento;
	
	public Veterinario veterinario;
	

	public Animal animal;
	
	public Cliente nomeDono;
	
	public String cpfDono;
	
	public String outrasInformacoes;
	
	public String dataAtendimento;

	public AtendimentoDto(Atendimento a) {
		this.idAtendimento = a.getIdAtendimento();
		this.veterinario = a.getVeterinario();
		this.animal = a.getAnimal();
		this.nomeDono = a.getNomeDono();
		this.cpfDono = a.getCpfDono();
		this.outrasInformacoes = a.getOutrasInformacoes();
		this.dataAtendimento = a.getDataAtendimento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	
	
	public Atendimento converter() {
		
		var att = LocalDate.parse(this.dataAtendimento,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
				
		return new Atendimento(this.idAtendimento,this.veterinario,this.animal,this.nomeDono,this.cpfDono,this.outrasInformacoes,att);
	}
	
	
	
	
}
