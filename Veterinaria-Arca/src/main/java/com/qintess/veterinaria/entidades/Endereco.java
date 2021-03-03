package com.qintess.veterinaria.entidades;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Getter @Setter
@Embeddable
public class Endereco {
	
	
	
	private String rua;
	
	private String numero;
	
	private String complemento;
	
	private String cidade;
	
	private String bairro;
	
	private String cep;
	
	private String estado;
	
	
	

	public Endereco( String rua, String numero, String cidade, String bairro, String complemento, String cep,String estado) {
	
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.cidade = cidade;
		this.bairro = bairro;
		this.cep = cep;
		this.estado = estado;
	}




	public Endereco() {
	}

	
	
	
}
