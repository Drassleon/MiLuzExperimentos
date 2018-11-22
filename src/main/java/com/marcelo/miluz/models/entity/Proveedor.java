package com.marcelo.miluz.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="proveedores")
public class Proveedor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nombre;
	
	@NotNull
	@Column(name="numero_telefonico")
	private String numeroTelefonico;
	
	@NotNull
	@Column(name="tipo_pago")
	private String tipoPago;
	
	@NotNull
	@Column(name="existe_deuda")
	private Boolean existeDeuda;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public Boolean getExisteDeuda() {
		return existeDeuda;
	}

	public void setExisteDeuda(Boolean existeDeuda) {
		this.existeDeuda = existeDeuda;
	}
}
