package com.example.pubsync.model;

import com.google.gson.annotations.SerializedName;

public class HitItem{

	@SerializedName("@score")
	private String score;

	@SerializedName("@id")
	private String id;

	@SerializedName("url")
	private String url;

	@SerializedName("info")
	private Info info;

	public void setScore(String score){
		this.score = score;
	}

	public String getScore(){
		return score;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setInfo(Info info){
		this.info = info;
	}

	public Info getInfo(){
		return info;
	}
}