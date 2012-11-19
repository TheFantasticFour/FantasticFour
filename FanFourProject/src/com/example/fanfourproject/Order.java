package com.example.fanfourproject;

import java.util.ArrayList;

public class Order {
	
	private ArrayList<Pizza> pizzas;
	private ArrayList<Pop> pops;
	
	private static final double POP_CAN_PRICE = 0.99;
	private static final double POP_LITER_PRICE = 2.99;
	private static final double PIZZA_SMALL_PRICE = 8.99;
	private static final double PIZZA_MEDIUM_PRICE = 13.99;
	private static final double PIZZA_LARGE_PRICE = 18.99;
	
	private static final double TAX_RATE = 0.075;
	
	public Order(){
		pizzas = new ArrayList<Pizza>();
		pops = new ArrayList<Pop>();
	}
	
	public ArrayList<Pizza> getPizzas(){
		return pizzas;
	}
	
	public ArrayList<Pop> getPop(){
		return pops;
	}
	
	public void addPizza(Pizza newPiz){
		pizzas.add(newPiz);
	}
	
	public void addPop(Pop newPop){
		pops.add(newPop);
	}
	
	public void clearPizzas(){
		pizzas = new ArrayList<Pizza>();
	}
	
	public void clearPops(){
		pops = new ArrayList<Pop>();
	}
	
	public String checkDecimals(Double d){
		BigDecimal bd = new BigDecimal(d);
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		String value = bd.toString();
		return value;
	}
	
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
			else{
				total = total + PIZZA_LARGE_PRICE;
			}
			for(String top : p.getPizzaToppings()){
				total = total + 1.00;
			}
		}
		return checkDecimals(total);
	}
	
	public String getTax(){
		Double tax = 0.0;
		tax = Double.valueOf(getInitialPrice())*TAX_RATE;
		String dis = checkDecimals(tax);
		
		return dis;
	}
	
	public String getDiscounts(){
		discountCalculate dc = new discountCalculate("DISC15", getInitialPrice());
		
		return dc.discountCode();
	}
	
	public String getFinalPrice(){
		Double price = 0.0;
		price = price + Double.valueOf(getInitialPrice())+Double.valueOf(getTax())-Double.valueOf(getDiscounts());
		
		String finalPrice = checkDecimals(price);
		
		return finalPrice;
	}
	
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
