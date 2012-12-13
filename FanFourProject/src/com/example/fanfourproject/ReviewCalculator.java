/**
 * Class which aids in calculating the value of a item.
 * 
 */
package com.example.fanfourproject;

import java.util.ArrayList;
import java.util.TreeMap;

public class ReviewCalculator {
	
	public static final String currentYear = "2012";
	public static final String currentMonth = "12";
	
	/**
	 * Calculates the value of a particular item based on the reviews and ratings.
	 * 
	 * @param reviewArray Array of reviews
	 * @return Ordered list of Pizzas
	 */
	public ArrayList<String> calculatePizzaOrder(ArrayList<Review> reviewArray){
		ArrayList<String> returnArray = new ArrayList<String>();
		
		ArrayList<Review> type1Pizzas = new ArrayList<Review>();
		ArrayList<Review> type2Pizzas = new ArrayList<Review>();
		ArrayList<Review> type3Pizzas = new ArrayList<Review>();
		ArrayList<Review> type4Pizzas = new ArrayList<Review>();
		ArrayList<Review> type5Pizzas = new ArrayList<Review>();
		ArrayList<Review> type6Pizzas = new ArrayList<Review>();
		ArrayList<Review> type7Pizzas = new ArrayList<Review>();
		
		for(Review r: reviewArray){
			switch (Integer.valueOf(r.getType())) {
	        case 1:  type1Pizzas.add(r);
	                 break;
	        case 2:  type2Pizzas.add(r);
	                 break;
	        case 3:  type3Pizzas.add(r);
	                 break;
	        case 4:  type4Pizzas.add(r);
	                 break;
	        case 5:  type5Pizzas.add(r);
	                 break;
	        case 6:  type6Pizzas.add(r);
	                 break;
	        case 7:  type7Pizzas.add(r);
	                 break;
			}
		}
		//extra addition assures no equal values
		Double score1 = calculateScore(type1Pizzas)+0.001;
		Double score2 = calculateScore(type2Pizzas)+0.002;
		Double score3 = calculateScore(type3Pizzas)+0.003;
		Double score4 = calculateScore(type4Pizzas)+0.004;
		Double score5 = calculateScore(type5Pizzas)+0.005;
		Double score6 = calculateScore(type6Pizzas)+0.006;
		Double score7 = calculateScore(type7Pizzas)+0.007;
		TreeMap<Double, Integer> treeMap = new TreeMap<Double, Integer>();
		treeMap.put(score1, 1);
		treeMap.put(score2, 2);
		treeMap.put(score3, 3);
		treeMap.put(score4, 4);
		treeMap.put(score5, 5);
		treeMap.put(score6, 6);
		treeMap.put(score7, 7);
				
		for(int i = 0; i < 7; i++){
			Double highest = treeMap.lastKey();
			returnArray.add(treeMap.get(highest).toString());
			treeMap.remove(highest);
		}
		return returnArray;
	}
	
	/**
	 * Calculates the score of a Array of reviews.
	 * 
	 * @param reviewArray Array of reviews
	 * @return Score of the pizza
	 */
	public Double calculateScore(ArrayList<Review> reviewArray){
		Double score = 0.0;
		Double weight = 0.0;
		
		for(Review r: reviewArray){
			String timeStamp = r.getTimestamp();
			Integer hours = calculateHours(timeStamp);
			
			//1 hour gives a 100% time factor
			//24 hours gives a 75% time factor
			//24^2 hours gives a 50% time factor
			Double timeFactor = 1.0 -(0.078664495*Math.log(hours));
			weight = weight + timeFactor;
			score = score + (timeFactor)*r.getRating();
		}
		
		//calculates the weighted average
		score = score/weight;
		
		return score;
	}
	
	/**
	 * Calculates the age of a review
	 * 
	 * @param timeStamp Time of review
	 * @return Integer age of the review in hours
	 */
	public Integer calculateHours(String timeStamp){
		Integer returnInt = 1;
		
		Integer yearR = Integer.valueOf(timeStamp.substring(0,4));
		Integer monthR = Integer.valueOf(timeStamp.substring(5,7));
		Integer dayR = Integer.valueOf(timeStamp.substring(8,10));
		Integer hourR = Integer.valueOf(timeStamp.substring(11,13));
		
		long currentTime = System.currentTimeMillis();
				
		currentTime = (long) (currentTime-(366*10+365*32)*24*60*60*1000.0-(335)*24*60*60*1000.0);
		Integer currentDay = (int) ((currentTime/(1000.0*60*60*24))+1);
		
		currentTime = (long) (currentTime-((currentDay-1) * 1000.0*60*60*24));
		Integer currentHour = (int) ((currentTime/(1000.0*60*60))-6);
		returnInt = (Integer.valueOf(currentYear)-yearR)*8760 + (Integer.valueOf(currentMonth)-monthR)*720 + (currentDay-dayR)*24 + (currentHour-hourR);
		
		return returnInt;
	}
	
	/**
	 * Places reviews in order from high to low.
	 * 
	 * @param reviewArray ArrayList of reviews
	 * @return Ordered ArrayList of reviews
	 */
	public ArrayList<Review> putReviewsInOrder(ArrayList<Review> reviewArray){
    	ArrayList<Review> returnArray = new ArrayList<Review>();
    	
    	for(Review r: reviewArray){
    		if(r.getType().equals("1")){
    			returnArray.add(r);
    		}
    	}
    	for(Review r: reviewArray){
    		if(r.getType().equals("2")){
    			returnArray.add(r);
    		}
    	}
    	for(Review r: reviewArray){
    		if(r.getType().equals("3")){
    			returnArray.add(r);
    		}
    	}
    	for(Review r: reviewArray){
    		if(r.getType().equals("4")){
    			returnArray.add(r);
    		}
    	}
    	for(Review r: reviewArray){
    		if(r.getType().equals("5")){
    			returnArray.add(r);
    		}
    	}
    	for(Review r: reviewArray){
    		if(r.getType().equals("6")){
    			returnArray.add(r);
    		}
    	}
    	for(Review r: reviewArray){
    		if(r.getType().equals("7")){
    			returnArray.add(r);
    		}
    	}
    	
    	return returnArray;
    }
}
