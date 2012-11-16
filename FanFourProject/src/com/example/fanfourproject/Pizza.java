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
	
	public String getPizzaSize(){
		return pizzaSize;
	}
	
	public void setPizzaSize(String size){
		pizzaSize = size;
	}
	
	public ArrayList<String> getPizzaToppings(){
		return toppings;
	}
	
	public void addPizzaToppings(String top){
		toppings.add(top);
	}
	
	public void clearPizzaToppings(){
		toppings = new ArrayList<String>();
	}
	
	public String toString(){
//		PrintWriter myOut = null;
//		try {
//			//myOut = new PrintWriter(new BufferedWriter(new FileWriter("/home/f10/pghardy/Desktop/"+"testName")));
//			myOut = new PrintWriter(new BufferedWriter(new FileWriter("testName")));
//		} catch (Exception e) {
//			System.out.println(e);
//		}
			
		/////
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
		
		
		/////
		//myOut.print(s);
		//myOut.close();
		return s;
	}
}
