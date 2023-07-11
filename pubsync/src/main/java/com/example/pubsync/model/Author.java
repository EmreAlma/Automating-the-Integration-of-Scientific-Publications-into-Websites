package com.example.pubsync.model;

import com.google.gson.annotations.SerializedName;

public class Author{

	@SerializedName("@pid")
	private String pid;

	@SerializedName("text")
	private String text;

	public void setPid(String pid){
		this.pid = pid;
	}

	public String getPid(){
		return pid;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}
}