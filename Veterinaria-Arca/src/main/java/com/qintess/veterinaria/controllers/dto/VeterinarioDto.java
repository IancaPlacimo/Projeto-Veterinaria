package com.qintess.veterinaria.controllers.dto;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.OneToOne;

import com.qintess.veterinaria.entidades.Consulta;
import com.qintess.veterinaria.entidades.Endereco;
import com.qintess.veterinaria.entidades.Veterinario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class VeterinarioDto {

	
	private int id;	
	private String crmv;	
	private String nomeVeterinario;			
	private String telefone;	
	private String dataNascimento;
	private String especialidade;
	private Endereco endereco;
	
				
	
	public VeterinarioDto(Veterinario v) {
		
		this.id = v.getId();
		this.crmv = v.getCrmv();
		this.nomeVeterinario = v.getNomeVeterinario();
		this.telefone = v.getTelefone();
		this.dataNascimento = v.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.especialidade = v.getEspecialidade();
		this.endereco = v.getEndereco();
	
	}
	
	
	public Veterinario converter() {
		
		var nasc = LocalDate.parse(this.dataNascimento,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	
		return new Veterinario(this.id, this.crmv, this.especialidade, this.nomeVeterinario, this.telefone, nasc,this.endereco);
	}


	@Override
	public String toString() {
		return "crmv:   " + "   /  " + crmv +  "   /  " + " Dr " + nomeVeterinario + 
				"  /   " +	 especialidade ;
	}


	
}
