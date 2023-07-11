package com.example.pubsync.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Hits{

	@SerializedName("hit")
	private List<HitItem> hit;

	@SerializedName("@sent")
	private String sent;

	@SerializedName("@first")
	private String first;

	@SerializedName("@computed")
	private String computed;

	@SerializedName("@total")
	private String total;

	public void setHit(List<HitItem> hit){
		this.hit = hit;
	}

	public List<HitItem> getHit(){
		return hit;
	}

	public void setSent(String sent){
		this.sent = sent;
	}

	public String getSent(){
		return sent;
	}

	public void setFirst(String first){
		this.first = first;
	}

	public String getFirst(){
		return first;
	}

	public void setComputed(String computed){
		this.computed = computed;
	}

	public String getComputed(){
		return computed;
	}

	public void setTotal(String total){
		this.total = total;
	}

	public String getTotal(){
		return total;
	}
}