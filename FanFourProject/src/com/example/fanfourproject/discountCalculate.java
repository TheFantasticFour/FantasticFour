package com.example.fanfourproject;

import java.math.BigDecimal;

public class discountCalculate {
	private boolean discounted = false;
	private String code, price, id;
	public discountCalculate(String code, String price){
		this.code = code;
		this.price = price;
	}
	public discountCalculate(String code, String id, String price){	
		this.code = code;
		this.id = id;
		this.price = price;
	}
	public String discountCode(){
		String discountPrice;
		if (!discounted ){
			discounted = true;
			if(code.equals("DISC10")){
				double temp=Double.parseDouble(price);
				temp=temp*0.1;
				BigDecimal bd = new BigDecimal(temp);
			bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
			discountPrice=bd.toString();
			return discountPrice;
		}
		else if(code.equals("DISC15")){
			double temp=Double.parseDouble(price);
			temp=temp*0.15;
			BigDecimal bd = new BigDecimal(temp);
			bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
			discountPrice=bd.toString();
			return discountPrice;
		}
		else if(code.equals("DISC20")){
			double temp=Double.parseDouble(price);
			temp=temp*0.2;
			BigDecimal bd = new BigDecimal(temp);
			bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
			discountPrice=bd.toString();
			return discountPrice;
		}
		else if(code.equals("DISC4OFF")){
			double temp = 4;
			BigDecimal bd = new BigDecimal(temp);
			bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
			discountPrice=bd.toString();
			return discountPrice;
		}
		else if(code.equals("DISC10OFF100")){
			double priced=Double.parseDouble(price);
			double temp = 0;
			if (priced>=100){
				temp = 10;
			}
			BigDecimal bd = new BigDecimal(temp);
			bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
			discountPrice=bd.toString();
			return discountPrice;
		}
		else {
			discountPrice = price;
			discounted = false;
			return discountPrice;
		}
		}
		else {
			discountPrice = price;
			return discountPrice;
		}
	}
	
	
	//Student get 15% off
	public String discountID(){
		String discountPrice = price;
		int idNum;
		try{
			idNum = Integer.parseInt(id);
			if(!discounted){
				if (idNum >= 900190000 && idNum <=900209999){
					code = "DISC15";
					discountPrice = discountCode();
					discounted = true;
				}
				else{
					discountPrice = price;
				}
			}
		}
		catch(Exception e){
			System.out.println("Invalid ID number");
		}		
		return discountPrice;
	}

}
