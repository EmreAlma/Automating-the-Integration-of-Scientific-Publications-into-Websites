package com.example.pubsync.model;

import com.google.gson.annotations.SerializedName;

public class Result{

	@SerializedName("hits")
	private Hits hits;

	@SerializedName("query")
	private String query;


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
}