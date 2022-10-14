package com.credibanco.app.Entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import javax.persistence.Table;

@Entity
@Table(name = "tarjeta")
@NamedQuery(name = "Tarjeta.findAll", query = ("SELECT e FROM Tarjeta e "))
public class Tarjeta implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "numer_tarjeta", length = 20)
	private String numerTarjeta;

	@Column(name = "titular")
	private String titular;

	@Column(name = "cedula", length = 15)
	private String cedula;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "telefono", length = 10)
	private Float telefono;

	@Column(name = "numer_validacion")
	private Integer numerValidacion;

	@Column(name = "estado")
	private String estado;

	public Tarjeta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tarjeta(Long id, String numerTarjeta, String titular, String cedula, String tipo, Float telefono,
			Integer numerValidacion, String estado) {
		super();
		this.id = id;
		this.numerTarjeta = numerTarjeta;
		this.titular = titular;
		this.cedula = cedula;
		this.tipo = tipo;
		this.telefono = telefono;
		this.numerValidacion = numerValidacion;
		this.estado = estado;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumerTarjeta() {
		return numerTarjeta;
	}

	public void setNumerTarjeta(String numerTarjeta) {
		this.numerTarjeta = numerTarjeta;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Float getTelefono() {
		return telefono;
	}

	public void setTelefono(Float telefono) {
		this.telefono = telefono;
	}

	public Integer getNumerValidacion() {
		return numerValidacion;
	}

	public void setNumerValidacion(Integer numerValidacion) {
		this.numerValidacion = numerValidacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
