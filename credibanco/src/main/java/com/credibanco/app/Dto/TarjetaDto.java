package com.credibanco.app.Dto;

import com.credibanco.app.Entidades.Tarjeta;

public class TarjetaDto {

	
	
	private Tarjeta tarjeta;

	public TarjetaDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TarjetaDto(Tarjeta tarjeta) {
		super();
		this.tarjeta = tarjeta;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	
	
}
