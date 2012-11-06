package com.example.fanfourproject;

public class Pop {
	
	private String size = "";
	private String type = "";
	
	public Pop(String s, String t){
		this.size = s;
		this.type = t;
	}
	
	public String getPopSize(){
		return size;
	}
	
	public void setPopSize(String s){
		this.size = s;
	}
	
	public String getPopType(){
		return type;
	}
	
	public void setPopType(String t){
		this.type = t;
	}
	
	public String toString(){
		return "finishMe";
	}
}
