package com.example.fanfourproject;

import java.math.BigDecimal;

public class DiscountCalculate {

	//private boolean discounted = false;
	
	public static final String CODE_1 = "DISC10";
	public static final String CODE_2 = "DISC15";
	public static final String CODE_3 = "DISC20";
	public static final String CODE_4 = "DISC4OFF";
	
	public static final int LOWEST_BANNER_ID = 900190000;
	public static final int HIGHEST_BANNER_ID = 900209999;

	private String code = "";
	private String price = "";
	private String id = "";

	public DiscountCalculate(String code, String price) {
		this.code = code;
		this.price = price;
	}

	public DiscountCalculate(String code, String id, String price) {
		this.code = code;
		this.id = id;
		this.price = price;
	}
	
	public String getDiscountAmount(){
		String discountAmount1 = "";
		String discountAmount2 = "";
		if(code == null){
			discountAmount1 = "0.0";
		}
		else if(code.equals(CODE_1)){
			double temp = Double.parseDouble(price);
			temp = temp * 0.1;
			discountAmount1 = getBigDecimalString(temp);
		}
		else if(code.equals(CODE_2)){
			double temp = Double.parseDouble(price);
			temp = temp * 0.15;
			discountAmount1 = getBigDecimalString(temp);
		}
		else if(code.equals(CODE_3)){
			double temp = Double.parseDouble(price);
			temp = temp * 0.2;
			discountAmount1 = getBigDecimalString(temp);
		}
		else if(code.equals(CODE_4)){
			double temp = Double.parseDouble(price);
			temp = 4;
			discountAmount1 = getBigDecimalString(temp);
		}
		
		int idNum = Integer.valueOf(id);
		if(id == null){
			discountAmount2 = "0.0";
		}
		else if(idNum >= LOWEST_BANNER_ID && idNum <= HIGHEST_BANNER_ID){
			double temp = Double.parseDouble(price);
			temp = temp * 0.1;
			discountAmount2 = getBigDecimalString(temp);
		}
		
		Double totalDiscount = Double.valueOf(discountAmount1) + Double.valueOf(discountAmount2);
		
		return totalDiscount.toString();
	}

	// Student get 10% off
	public String discountID() {
		int idNum;
		try {
			idNum = Integer.valueOf(id);
			if (idNum >= LOWEST_BANNER_ID && idNum <= HIGHEST_BANNER_ID) {
				code = CODE_1;
				return getDiscountAmount();
			} 
			else {
				return "0.00";
			}
		} catch (Exception e) {
			System.out.println("Invalid ID number");
			return "0.00";
		}
	}
	
	//Helper method for formatting
	private String getBigDecimalString(double temp){
		BigDecimal bd = new BigDecimal(temp);
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		return bd.toString();
	}
}
