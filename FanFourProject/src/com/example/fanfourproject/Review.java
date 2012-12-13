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
	
	private static String PIZZA_1_TAG = "Meat-Lovers Pizza";
	private static String PIZZA_2_TAG = "Taco Pizza";
	private static String PIZZA_3_TAG = "Veggie Pizza";
	private static String PIZZA_4_TAG = "Fajita Pizza";
	private static String PIZZA_5_TAG = "Buffalo-Chicken Pizza";
	private static String PIZZA_6_TAG = "Bacon-Cheeseburger Pizza";
	private static String PIZZA_7_TAG = "Dessert Pizza";
	
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
        case 1:  longType = PIZZA_1_TAG;
                 break;
        case 2:  longType = PIZZA_2_TAG;
                 break;
        case 3:  longType = PIZZA_3_TAG;
                 break;
        case 4:  longType = PIZZA_4_TAG;
                 break;
        case 5:  longType = PIZZA_5_TAG;
                 break;
        case 6:  longType = PIZZA_6_TAG;
                 break;
        case 7:  longType = PIZZA_7_TAG;
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
