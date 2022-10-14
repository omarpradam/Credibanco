package com.credibanco.app.Dto;

public class ResponseDto {

	private String Pan;
	private String tirular;
	private String cédula;
	private String teléfono;
	private String estado;

	public ResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseDto(String pan, String tirular, String cédula, String teléfono, String estado) {
		super();
		Pan = pan;
		this.tirular = tirular;
		this.cédula = cédula;
		this.teléfono = teléfono;
		this.estado = estado;
	}

	public String getPan() {
		return Pan;
	}

	public void setPan(String pan) {
		Pan = pan;
	}

	public String getTirular() {
		return tirular;
	}

	public void setTirular(String tirular) {
		this.tirular = tirular;
	}

	public String getCédula() {
		return cédula;
	}

	public void setCédula(String cédula) {
		this.cédula = cédula;
	}

	public String getTeléfono() {
		return teléfono;
	}

	public void setTeléfono(String teléfono) {
		this.teléfono = teléfono;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
