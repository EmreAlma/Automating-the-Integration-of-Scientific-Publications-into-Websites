package com.example.pubsync.model;

import com.google.gson.annotations.SerializedName;

public class Result{

	@SerializedName("hits")
	private Hits hits;

	@SerializedName("query")
	private String query;

	@SerializedName("completions")
	private Completions completions;

	@SerializedName("time")
	private Time time;

	@SerializedName("status")
	private Status status;

	public void setHits(Hits hits){
		this.hits = hits;
	}

	public Hits getHits(){
		return hits;
	}

	public void setQuery(String query){
		this.query = query;
	}

	public String getQuery(){
		return query;
	}

	public void setCompletions(Completions completions){
		this.completions = completions;
	}

	public Completions getCompletions(){
		return completions;
	}

	public void setTime(Time time){
		this.time = time;
	}

	public Time getTime(){
		return time;
	}

	public void setStatus(Status status){
		this.status = status;
	}

	public Status getStatus(){
		return status;
	}
}