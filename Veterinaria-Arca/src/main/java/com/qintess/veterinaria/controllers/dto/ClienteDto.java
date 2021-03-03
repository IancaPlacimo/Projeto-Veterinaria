package com.qintess.veterinaria.controllers.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.qintess.veterinaria.entidades.Cliente;
import com.qintess.veterinaria.entidades.Endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ClienteDto {

	private int id;	
	private String cpfDono;	
	private String nomeDono;	
	private String dataNasc;	
	private String telefone;
	private Endereco endereco;
	
	
		public ClienteDto(Cliente c) {
		this.id = c.getId();
		this.cpfDono = c.getCpfDono();
		this.nomeDono = c.getNomeDono();
		this.dataNasc = c.getDataNasc().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.telefone = c.getTelefone();
		this.endereco = c.getEndereco();
		
	}
	
	public Cliente converter() {
		
		var nasc = LocalDate.parse(this.dataNasc,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		return new Cliente(this.id, this.cpfDono,this.nomeDono,nasc,this.telefone,this.endereco);
	}

	@Override
	public String toString() {
		return  nomeDono ;
	}

	
	
	
	
	
	
	
	
	
}
