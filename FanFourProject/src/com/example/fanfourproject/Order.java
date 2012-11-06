package com.example.fanfourproject;

import java.util.ArrayList;

public class Order {
	
	private ArrayList<Pizza> pizzas;
	private ArrayList<Pop> pops;
	
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
	
	public String toString(){
		return "finishMe";
	}
}
