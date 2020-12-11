package com.example.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Veiculo {

	@Id
	@Column
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(length = 7)
	private String plate;
	
	@Column
	private String model;
	
	@Column
	private String manufacturer;
	
	@Column
	private String color;
	
	@Column
	private Boolean status;
	
	public Veiculo(Long id, String plate, String model, String manufacturer, String color, Boolean status) {
		this.id = id;
		this.plate = plate;
		this.model = model;
		this.manufacturer = manufacturer;
		this.color = color;
		this.status = status;
	}

	public Veiculo() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", plate=" + plate + ", model=" + model + ", manufacturer=" + manufacturer
				+ ", color=" + color + ", status=" + status + "]";
	}
	
}
