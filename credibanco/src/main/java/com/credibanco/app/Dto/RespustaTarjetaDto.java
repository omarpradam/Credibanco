package com.credibanco.app.Dto;

public class RespustaTarjetaDto {

	private String numeroTarjeta;
	private Integer numeroValidacion;

	public RespustaTarjetaDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RespustaTarjetaDto(String numeroTarjeta, Integer numeroValidacion) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.numeroValidacion = numeroValidacion;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public Integer getNumeroValidacion() {
		return numeroValidacion;
	}

	public void setNumeroValidacion(Integer numeroValidacion) {
		this.numeroValidacion = numeroValidacion;
	}

}
