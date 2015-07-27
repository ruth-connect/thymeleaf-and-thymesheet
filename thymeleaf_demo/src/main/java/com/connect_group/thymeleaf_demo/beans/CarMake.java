package com.connect_group.thymeleaf_demo.beans;

import java.io.Serializable;
import java.util.List;

public class CarMake implements Serializable {

	private static final long serialVersionUID = 953056051833576377L;

	private String name;
	private List<CarModel> models;
	
	public CarMake() {
	}
	
	public CarMake(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<CarModel> getModels() {
		return models;
	}

	public void setModels(List<CarModel> models) {
		this.models = models;
	}
}
