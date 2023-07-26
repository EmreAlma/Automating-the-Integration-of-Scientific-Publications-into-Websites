package com.example.pubsync.model;

import com.google.gson.annotations.SerializedName;

public class Authors{

	@SerializedName("author")
	private Object author;

	public void setAuthor(Object author){
		this.author = author;
	}

	public Object getAuthor(){
		return author;
	}
}