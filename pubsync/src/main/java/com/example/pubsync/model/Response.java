package com.example.pubsync.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response{

	@SerializedName("result")
	private Result result;

	public void setResult(Result result){
		this.result = result;
	}

	public Result getResult(){
		return result;
	}

	public static class Completions{

		@SerializedName("@sent")
		private String sent;

		@SerializedName("c")
		private C c;

		@SerializedName("@computed")
		private String computed;

		@SerializedName("@total")
		private String total;

		public void setSent(String sent){
			this.sent = sent;
		}

		public String getSent(){
			return sent;
		}

		public void setC(C c){
			this.c = c;
		}

		public C getC(){
			return c;
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

	public static class Status{

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

	public static class Info{

		@SerializedName("ee")
		private String ee;

		@SerializedName("venue")
		private String venue;

		@SerializedName("access")
		private String access;

		@SerializedName("year")
		private String year;

		@SerializedName("title")
		private String title;

		@SerializedName("type")
		private String type;

		@SerializedName("url")
		private String url;

		@SerializedName("volume")
		private String volume;

		@SerializedName("number")
		private String number;

		@SerializedName("pages")
		private String pages;

		@SerializedName("key")
		private String key;

		@SerializedName("authors")
		private Authors authors;

		@SerializedName("doi")
		private String doi;

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

		public void setUrl(String url){
			this.url = url;
		}

		public String getUrl(){
			return url;
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

		public void setPages(String pages){
			this.pages = pages;
		}

		public String getPages(){
			return pages;
		}

		public void setKey(String key){
			this.key = key;
		}

		public String getKey(){
			return key;
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
	}

	public static class HitItem{

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

	public static class AuthorItem{

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

	public static class Time{

		@SerializedName("@unit")
		private String unit;

		@SerializedName("text")
		private String text;

		public void setUnit(String unit){
			this.unit = unit;
		}

		public String getUnit(){
			return unit;
		}

		public void setText(String text){
			this.text = text;
		}

		public String getText(){
			return text;
		}
	}

	public static class Result{

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

	public static class Hits{

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

	public static class Authors{

		@SerializedName("author")
		private List<AuthorItem> author;

		public void setAuthor(List<AuthorItem> author){
			this.author = author;
		}

		public List<AuthorItem> getAuthor(){
			return author;
		}
	}

	public static class C{

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
}