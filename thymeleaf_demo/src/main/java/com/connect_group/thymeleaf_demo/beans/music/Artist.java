package com.connect_group.thymeleaf_demo.beans.music;

import java.io.Serializable;
import java.util.List;

public class Artist implements Serializable {
	private static final long serialVersionUID = 4559259645555861751L;
	
	private String name;
	private String bio;
	private String image;
	private List<Album> albums;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
}
