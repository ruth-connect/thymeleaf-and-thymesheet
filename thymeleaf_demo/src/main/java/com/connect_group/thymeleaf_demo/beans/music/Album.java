package com.connect_group.thymeleaf_demo.beans.music;

import java.io.Serializable;

public class Album implements Serializable {
	private static final long serialVersionUID = -3952715197933953379L;
	
	private String name;
	private String description;
	private String image;
	private boolean cdAvailable;
	private boolean vinylAvailable;
	private boolean downloadAvailable;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public boolean isCdAvailable() {
		return cdAvailable;
	}
	
	public void setCdAvailable(boolean cdAvailable) {
		this.cdAvailable = cdAvailable;
	}
	
	public boolean isVinylAvailable() {
		return vinylAvailable;
	}
	
	public void setVinylAvailable(boolean vinylAvailable) {
		this.vinylAvailable = vinylAvailable;
	}
	
	public boolean isDownloadAvailable() {
		return downloadAvailable;
	}
	
	public void setDownloadAvailable(boolean downloadAvailable) {
		this.downloadAvailable = downloadAvailable;
	}
}
