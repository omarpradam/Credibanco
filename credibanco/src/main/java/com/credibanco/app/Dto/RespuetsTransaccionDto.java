package com.credibanco.app.Dto;

public class RespuetsTransaccionDto {

	private String estado;
	private String numeroRefe;

	public RespuetsTransaccionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RespuetsTransaccionDto(String estado, String numeroRefe) {
		super();
		this.estado = estado;
		this.numeroRefe = numeroRefe;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNumeroRefe() {
		return numeroRefe;
	}

	public void setNumeroRefe(String numeroRefe) {
		this.numeroRefe = numeroRefe;
	}

}
