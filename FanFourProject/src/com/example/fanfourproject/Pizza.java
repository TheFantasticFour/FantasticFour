package com.example.fanfourproject;

import java.util.ArrayList;

public class Pizza {
	
	private ArrayList<String> toppings = new ArrayList<String>();
	private String pizzaSize = "";
	private String specialtyType = null;
	
	public Pizza(String size, ArrayList<String> tops){
		for(String top: tops){
			toppings.add(top);
		}
		this.pizzaSize = size;
	}
	
	public Pizza(int specialtyType){
		pizzaSize = "Special";
		toppings = new ArrayList<String>();
		switch (specialtyType){
        case 1:  this.specialtyType = "Special Pizza: Meat-Lovers Pizza";
                 break;
        case 2:  this.specialtyType = "Special Pizza: Taco Pizza";
                 break;
        case 3:  this.specialtyType = "Special Pizza: Veggie Pizza";
                 break;
        case 4:  this.specialtyType = "Special Pizza: Fajita Pizza";
                 break;
        case 5:  this.specialtyType = "Special Pizza: Buffalo-Chicken Pizza";
                 break;
        case 6:  this.specialtyType = "Special Pizza: Bacon-Cheeseburger Pizza";
                 break;
        case 7:  this.specialtyType = "Special Pizza: Dessert Pizza";
                 break;
		}		
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
		if(specialtyType == null){
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
		else{
			return specialtyType;
		}
	}
}
