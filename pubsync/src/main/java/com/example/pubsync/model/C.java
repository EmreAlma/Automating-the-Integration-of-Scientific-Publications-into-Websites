package com.example.pubsync.model;

import com.google.gson.annotations.SerializedName;

public class C{

	@SerializedName("@sc")
	private String sc;

	@SerializedName("@oc")
	private String oc;

	@SerializedName("@id")
	private String id;

	@SerializedName("text")
	private String text;

	@SerializedName("@dc")
	private String dc;

	public void setSc(String sc){
		this.sc = sc;
	}

	public String getSc(){
		return sc;
	}

	public void setOc(String oc){
		this.oc = oc;
	}

	public String getOc(){
		return oc;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setDc(String dc){
		this.dc = dc;
	}

	public String getDc(){
		return dc;
	}
}