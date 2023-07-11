package com.example.pubsync.model;

import com.google.gson.annotations.SerializedName;

public class Info{

	@SerializedName("ee")
	private String ee;

	@SerializedName("venue")
	private String venue;

	@SerializedName("pages")
	private String pages;

	@SerializedName("access")
	private String access;

	@SerializedName("year")
	private String year;

	@SerializedName("title")
	private String title;

	@SerializedName("type")
	private String type;

	@SerializedName("key")
	private String key;

	@SerializedName("url")
	private String url;

	@SerializedName("authors")
	private Authors authors;

	@SerializedName("doi")
	private String doi;

	@SerializedName("publisher")
	private String publisher;

	@SerializedName("volume")
	private String volume;

	@SerializedName("number")
	private String number;

	public void setEe(String ee){
		this.ee = ee;
	}

	public String getEe(){
		return ee;
	}

	public void setVenue(String venue){
		this.venue = venue;
	}

	public String getVenue(){
		return venue;
	}

	public void setPages(String pages){
		this.pages = pages;
	}

	public String getPages(){
		return pages;
	}

	public void setAccess(String access){
		this.access = access;
	}

	public String getAccess(){
		return access;
	}

	public void setYear(String year){
		this.year = year;
	}

	public String getYear(){
		return year;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setKey(String key){
		this.key = key;
	}

	public String getKey(){
		return key;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setAuthors(Authors authors){
		this.authors = authors;
	}

	public Authors getAuthors(){
		return authors;
	}

	public void setDoi(String doi){
		this.doi = doi;
	}

	public String getDoi(){
		return doi;
	}

	public void setPublisher(String publisher){
		this.publisher = publisher;
	}

	public String getPublisher(){
		return publisher;
	}

	public void setVolume(String volume){
		this.volume = volume;
	}

	public String getVolume(){
		return volume;
	}

	public void setNumber(String number){
		this.number = number;
	}

	public String getNumber(){
		return number;
	}
}