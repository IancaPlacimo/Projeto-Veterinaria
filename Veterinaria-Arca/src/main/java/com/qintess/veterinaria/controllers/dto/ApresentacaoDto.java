package com.qintess.veterinaria.controllers.dto;

import com.qintess.veterinaria.entidades.Apresentacao;

public class ApresentacaoDto {
	
	
	public int id;
	
	public String ap;

	public ApresentacaoDto(Apresentacao app) {
		this.id = app.getId();
		this.ap = app.getAp();
	}

	public ApresentacaoDto() {
	
	}
	
	

}
