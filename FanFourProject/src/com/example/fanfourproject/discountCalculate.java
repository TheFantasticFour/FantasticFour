package com.example.fanfourproject;

import java.math.BigDecimal;

public class discountCalculate {
	private boolean discounted = false;
	public discountCalculate(String code, String price){
	}
	public discountCalculate(String code, String id, String price){	
	}
	public String discountCode(String code, String price){
		String finalPrice;
		if (!discounted ){
			discounted = true;
			if(code.equals("DISC10")){
				double temp=Double.parseDouble(price);
				temp=temp*0.9;
				BigDecimal bd = new BigDecimal(temp);
			bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
			finalPrice=bd.toString();
			return finalPrice;
		}
		else if(code.equals("DISC15")){
			double temp=Double.parseDouble(price);
			temp=temp*0.85;
			BigDecimal bd = new BigDecimal(temp);
			bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
			finalPrice=bd.toString();
			return finalPrice;
		}
		else if(code.equals("DISC20")){
			double temp=Double.parseDouble(price);
			temp=temp*0.8;
			BigDecimal bd = new BigDecimal(temp);
			bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
			finalPrice=bd.toString();
			return finalPrice;
		}
		else if(code.equals("DISC4OFF")){
			double temp=Double.parseDouble(price);
			temp=temp - 4;
			BigDecimal bd = new BigDecimal(temp);
			bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
			finalPrice=bd.toString();
			return finalPrice;
		}
		else if(code.equals("DISC10OFF100")){
			double temp=Double.parseDouble(price);
			if (temp>=100){
				temp = temp - 10;
			}
			BigDecimal bd = new BigDecimal(temp);
			bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
			finalPrice=bd.toString();
			return finalPrice;
		}
		else {
			finalPrice = price;
			discounted = false;
			return finalPrice;
		}
		}
		else {
			finalPrice = price;
			return finalPrice;
		}
	}
	
	
	//Student get 15% off
	public String discountID(String id, String price){
		String finalPrice = price;
		int idNum;
		try{
			idNum = Integer.parseInt(id);
			if(!discounted){
				if (idNum >= 900190000 && idNum <=900209999){
					finalPrice = discountCode("DISC15", price);
					discounted = true;
				}
				else{
					finalPrice = price;
				}
			}
		}
		catch(Exception e){
			System.out.println("Invalid ID number");
		}		
		return finalPrice;
	}

}
