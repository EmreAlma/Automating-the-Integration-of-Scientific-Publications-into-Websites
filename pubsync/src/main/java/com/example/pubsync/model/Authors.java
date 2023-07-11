package com.example.pubsync.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Authors{

	@SerializedName("author")
	private List<AuthorItem> author;

	public void setAuthor(List<AuthorItem> author){
		this.author = author;
	}

	public List<AuthorItem> getAuthor(){
		return author;
	}
}