package com.credibanco.app.Dto;

public class TrasanccionDto {

	private String númeroReferencia;

	private String totalCompra;

	private String pan;

	private String direccion;

	public TrasanccionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrasanccionDto(String númeroReferencia, String totalCompra, String pan, String diraccion) {
		super();
		this.númeroReferencia = númeroReferencia;
		this.totalCompra = totalCompra;
		this.pan = pan;
		this.direccion = direccion;
	}

	public String getNúmeroReferencia() {
		return númeroReferencia;
	}

	public void setNúmeroReferencia(String númeroReferencia) {
		this.númeroReferencia = númeroReferencia;
	}

	public String getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(String totalCompra) {
		this.totalCompra = totalCompra;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	

}
