package com.example.fanfourproject;

public class Review {

	private String type = "";
	private Double rating = 0.0;
	private String comment = "";
	private String timestamp = "";
	
	
	public Review(String type, Double rating, String comment, String timestamp){
		this.type = type;
		this.rating = rating;
		this.comment = comment;
		this.timestamp = timestamp;		
	}
	
	public Review(String type, Double rating, String comment){
		this.type = type;
		this.rating = rating;
		this.comment = comment;
		this.timestamp = null;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the rating
	 */
	public Double getRating() {
		return rating;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}
	
	public String toString(){
		if(timestamp!=null){
			return type + ", " + rating + ", " + comment + ", " + timestamp;
		}
		else{
			return type + ", " + rating + ", " + comment;
		}
	}
	
}
