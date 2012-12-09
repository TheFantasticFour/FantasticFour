package com.example.fanfourproject;

public class Review {

	private String type = "";
	private Double rating = 0.0;
	private String comment = "";
	private String timestamp = "";
	
	private String longType = "";
	
	
	public Review(String type, Double rating, String comment, String timestamp){
		this.type = type;
		this.rating = rating;
		this.comment = comment;
		this.timestamp = timestamp;
		setLongType();
	}
	
	public Review(String type, Double rating, String comment){
		this.type = type;
		this.rating = rating;
		this.comment = comment;
		this.timestamp = null;
		setLongType();
	}
	
	public void setLongType(){
		switch (Integer.valueOf(type)) {
        case 1:  longType = "Meat-Lovers Pizza";
                 break;
        case 2:  longType = "Taco Pizza";
                 break;
        case 3:  longType = "Veggie Pizza";
                 break;
        case 4:  longType = "Fajita Pizza";
                 break;
        case 5:  longType = "Buffalo-Chicken Pizza";
                 break;
        case 6:  longType = "Bacon-Cheeseburger Pizza";
                 break;
        case 7:  longType = "Dessert Pizza";
                 break;
		}
		
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @return the type
	 */
	public String getLongType() {
		return longType;
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
