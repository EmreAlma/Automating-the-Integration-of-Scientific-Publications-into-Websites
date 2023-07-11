package com.example.pubsync.model;

import com.google.gson.annotations.SerializedName;

public class Status{

	@SerializedName("@code")
	private String code;

	@SerializedName("text")
	private String text;

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}
}