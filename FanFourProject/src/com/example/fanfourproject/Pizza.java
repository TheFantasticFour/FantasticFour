package com.example.fanfourproject;

import java.util.ArrayList;

public class Pizza {
	
	private ArrayList<String> toppings = new ArrayList<String>();
	private String pizzaSize = "";
	
	public Pizza(String size, ArrayList<String> tops){
		for(String top: tops){
			toppings.add(top);
		}
		this.pizzaSize = size;
	}
	/**
	 * Gets pizza size
	 * 
	 * @return Size returned
	 */
	public String getPizzaSize(){
		return pizzaSize;
	}
	/**
	 * Sets pizza size
	 * 
	 * @param size size to be set
	 */
	
	public void setPizzaSize(String size){
		pizzaSize = size;
	}
	/**
	 * Gets pizza toppings
	 * 
	 * @return ArrayList of Strings which are the toppings.
	 */
	public ArrayList<String> getPizzaToppings(){
		return toppings;
	}
	/**
	 * Adds pizza toppings
	 * 
	 * @param top Topping to be added
	 */
	public void addPizzaToppings(String top){
		toppings.add(top);
	}
	/**
	 * Clears pizza toppings
	 * 
	 */
	public void clearPizzaToppings(){
		toppings = new ArrayList<String>();
	}
	/**
	 * Converts pizza object to a string. Aids in displaying
	 * 
	 * @return String of the pizza.
	 */
	public String toString(){
		String s = "";
		if(toppings.size()>1){
			s = s + pizzaSize + " Pizza with ";
			for(int i = 0; i < toppings.size(); i++){
				if(i==toppings.size()-2){
					s = s + toppings.get(i);
				}
				else if(i!=toppings.size()-1){
					s = s + toppings.get(i) + ", ";
				}				
				else{
					s = s + " and " + toppings.get(i);
				}
			}
		}
		else if(toppings.size()==1){
			s = s + pizzaSize + " Pizza with " + toppings.get(0);
		}
		else{//no toppings
			s = s + pizzaSize + " Pizza";
		}
		return s;
	}
}
