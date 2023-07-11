package com.example.pubsync.model;

import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("result")
	private Result result;

	public void setResult(Result result){
		this.result = result;
	}

	public Result getResult(){
		return result;
	}
}