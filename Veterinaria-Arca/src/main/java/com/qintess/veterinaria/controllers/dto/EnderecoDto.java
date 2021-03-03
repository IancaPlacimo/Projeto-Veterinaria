package com.qintess.veterinaria.controllers.dto;

import com.qintess.veterinaria.entidades.Endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class EnderecoDto {
		
	private String rua;	
	private String numero;	
	private String complemento;	
	private String cidade;	
	private String bairro;	
	private String cep;	
	private String estado;
	
	
	public EnderecoDto(Endereco endereco) {
	
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.complemento = endereco.getComplemento();
		this.cidade = endereco.getCidade();
		this.bairro = endereco.getBairro();
		this.cep = endereco.getCep();
		this.estado = endereco.getEstado();
	}

	
	
}
