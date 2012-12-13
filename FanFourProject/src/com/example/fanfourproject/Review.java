/**
 * Class which describes the contents of a review.
 * 
 */
package com.example.fanfourproject;

public class Review {

	private String type = "";
	private Double rating = 0.0;
	private String comment = "";
	private String timestamp = "";
	
	private String longType = "";
	
	/**
	 * Constructor for a review
	 * 
	 * @param type Type of Pizza being reviewed
	 * @param rating Rating given
	 * @param comment Comment on item
	 * @param timestamp Time review made
	 */
	public Review(String type, Double rating, String comment, String timestamp){
		this.type = type;
		this.rating = rating;
		this.comment = comment;
		this.timestamp = timestamp;
		setLongType();
	}
	/**
	 * Constructor for a review
	 * 
	 * @param type Type of Pizza being reviewed
	 * @param rating Rating given
	 * @param comment Comment on item
	 * @param timestamp Time review made
	 */
	
	public Review(String type, Double rating, String comment){
		this.type = type;
		this.rating = rating;
		this.comment = comment;
		this.timestamp = null;
		setLongType();
	}
	/**
	 * Sets the type of pizza for the review
	 * 
	 */
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
	 * Gets type of pizza
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Gets the long of the type
	 * @return the type
	 */
	public String getLongType() {
		return longType;
	}

	/**
	 * Gets the rating
	 * @return the rating
	 */
	public Double getRating() {
		return rating;
	}

	/**
	 * Gets the comment
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Gets the timestamp
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}
	/**
	 * converts a review into a string
	 * @return String of the review
	 */
	public String toString(){
		if(timestamp!=null){
			return type + ", " + rating + ", " + comment + ", " + timestamp;
		}
		else{
			return type + ", " + rating + ", " + comment;
		}
	}
	
}
