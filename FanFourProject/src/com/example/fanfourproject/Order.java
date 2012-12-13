/**
 * Class which characterizes our version of an order. Made up of two ArrayLists, one of Pizza's one of Pop's.
 * 
 * @author FantasticFour
 */
package com.example.fanfourproject;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Order {
	
	private ArrayList<Pizza> pizzas;
	private ArrayList<Pop> pops;
	
	private static final double POP_CAN_PRICE = 0.99;
	private static final double POP_LITER_PRICE = 2.99;
	private static final double PIZZA_SMALL_PRICE = 8.99;
	private static final double PIZZA_MEDIUM_PRICE = 13.99;
	private static final double PIZZA_LARGE_PRICE = 18.99;
	private static final double PIZZA_SPECIAL_PRICE = 21.99;
	
	private static final double TAX_RATE = 0.075;
	
	/**
	 * Constructor for the Class.
	 * 
	 */
	public Order(){
		pizzas = new ArrayList<Pizza>();
		pops = new ArrayList<Pop>();
	}
	/**
	 * Method which gets the initial price for an order.
	 * 
	 * @return Returns a string of the new price.
	 */
	public String getInitialPrice(){
		Double total = 0.0;
		for(Pop p: pops){
			if(p.getPopSize().equals("Can")){
				total = total + POP_CAN_PRICE;
			}
			else{
				total = total + POP_LITER_PRICE;
			}
		}
		for(Pizza p: pizzas){
			if(p.getPizzaSize().equals("Small")){
				total = total + PIZZA_SMALL_PRICE;
			}
			else if(p.getPizzaSize().equals("Medium")){
				total = total + PIZZA_MEDIUM_PRICE;
			}
			else if(p.getPizzaSize().equals("Large")){
				total = total + PIZZA_LARGE_PRICE;
			}
			else{//specialty pizza
				total = total + PIZZA_SPECIAL_PRICE;
			}
			total = total + p.getPizzaToppings().size();
		}
		return checkDecimals(total);
	}
	/**
	 * Calculates the tax necessary for a price of an order.
	 * 
	 * @return Returns a string of the new price with tax included.
	 */
	public String getTax(){
		Double tax = 0.0;
		tax = Double.valueOf(getInitialPrice())*TAX_RATE;
		String dis = checkDecimals(tax);
		return dis;
	}
	
	//Use DiscountCalculate Class
	/**
	 * Gathers Discounts applied to the order. (unused)
	 * 
	 * @return String of the amount of discounted.
	 */
	public String getDiscounts(){
		Double price = Double.valueOf(getInitialPrice()) + Double.valueOf(getTax());
		DiscountCalculate dc = new DiscountCalculate(MainMenuActivity.codeString, MainMenuActivity.bannerString, price.toString());
		
		return dc.getDiscountAmount();
	}
	/**
	 * Returns final price for an order.
	 * 
	 * @return String of the final price.
	 */
	
	public String getFinalPrice(){
		Double price =  Double.valueOf(getInitialPrice())+Double.valueOf(getTax())-Double.valueOf(getDiscounts());
		
		String finalPrice = checkDecimals(price);
		
		return finalPrice;
	}
	/**
	 * Retrieves Pizza's in an order.
	 * 
	 * @return ArrayList of Pizza's.
	 */
	public ArrayList<Pizza> getPizzas(){
		return pizzas;
	}
	/**
	 * Retrieves Pop's in an order.
	 * 
	 * @return ArrayList of Pop's.
	 */
	public ArrayList<Pop> getPop(){
		return pops;
	}
	/**
	 * Adds a pizza to the order.
	 * 
	 * @param newPiz New Pizza to be added to the order.
	 */
	public void addPizza(Pizza newPiz){
		pizzas.add(newPiz);
	}
	/**
	 * Adds a pop to the order.
	 * 
	 * @param newPiz New Pop to be added to the order.
	 */
	public void addPop(Pop newPop){
		pops.add(newPop);
	}
	/**
	 * Clears the array of Pizzas.
	 * 
	 */
	public void clearPizzas(){
		pizzas = new ArrayList<Pizza>();
	}
	/**
	 * Clears the array of Pops.
	 * 
	 */
	
	public void clearPops(){
		pops = new ArrayList<Pop>();
	}
	/**
	 * Ensures prices are rounded accordingly.
	 * 
	 * @param d the decimals of a value.
	 * @return String of new decimals.
	 */
	private String checkDecimals(Double d){
		BigDecimal bd = new BigDecimal(d);
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		String value = bd.toString();
		return value;
	}
	/**
	 * Converts the ArrayLists (Pizza and Pop both) onto one string. Pizzas first followed by pop.
	 * 
	 */
	public String toString(){
		String s = "";
		for(Pizza p: pizzas){
			s = s + p + "\n";
		}
		for(Pop p : pops){
			s = s + p + "\n";
		}
		return s;
	}
}
