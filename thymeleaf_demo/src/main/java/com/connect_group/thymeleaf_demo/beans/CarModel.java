package com.connect_group.thymeleaf_demo.beans;

import java.io.Serializable;

public class CarModel implements Serializable {

	private static final long serialVersionUID = -3558575639301480834L;

	private String name;
	
	public CarModel() {
	}
	
	public CarModel(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
