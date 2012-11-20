package com.example.fanfourproject;

import java.math.BigDecimal;

public class discountCalculate {

	//private boolean discounted = false;
	
	public static final String CODE_1 = "DISC10";
	public static final String CODE_2 = "DISC15";
	public static final String CODE_3 = "DISC20";
	public static final String CODE_4 = "DISC4OFF";
	public static final String CODE_5 = "DISC10OFF100";
	
	public static final int LOWEST_BANNER_ID = 900190000;
	public static final int HIGHEST_BANNER_ID = 900209999;

	private String code, price, id;

	public discountCalculate(String code, String price) {
		this.code = code;
		this.price = price;
	}

	public discountCalculate(String code, String id, String price) {
		this.code = code;
		this.id = id;
		this.price = price;
	}
	
	public String getDiscountAmount(){
		String discountAmount = "";
		if(code == null){
			return "0.00";
		}
		if(code.equals(CODE_1)){
			double temp = Double.parseDouble(price);
			temp = temp * 0.1;
			discountAmount = getBigDecimalString(temp);
			return discountAmount;
		}
		else if(code.equals(CODE_2)){
			double temp = Double.parseDouble(price);
			temp = temp * 0.15;
			discountAmount = getBigDecimalString(temp);
			return discountAmount;
		}
		else if(code.equals(CODE_3)){
			double temp = Double.parseDouble(price);
			temp = temp * 0.2;
			discountAmount = getBigDecimalString(temp);
			return discountAmount;
		}
		else if(code.equals(CODE_4)){
			double temp = Double.parseDouble(price);
			temp = 4;
			discountAmount = getBigDecimalString(temp);
			return discountAmount;
		}
		
		return "0.00";
	}
	
	public String discountCode() {
		String discountPrice;
		//if (!discounted) {
			//discounted = true;
			if (code.equals(CODE_1)) {
				double temp = Double.parseDouble(price);
				temp = temp * 0.1;
				discountPrice = getBigDecimalString(temp);
				return discountPrice;
			} 
			else if (code.equals(CODE_2)) {
				double temp = Double.parseDouble(price);
				temp = temp * 0.15;
				discountPrice = getBigDecimalString(temp);
				return discountPrice;
			} 
			else if (code.equals(CODE_3)) {
				double temp = Double.parseDouble(price);
				temp = temp * 0.2;
				discountPrice = getBigDecimalString(temp);
				return discountPrice;
			} 
			else if (code.equals(CODE_4)) {
				double temp = 4;
				discountPrice = getBigDecimalString(temp);
				return discountPrice;
			} 
//			else if (code.equals(CODE_5)) {
//				double priced = Double.parseDouble(price);
//				double temp = 0;
//				if (priced >= 100) {
//					temp = 10;
//				}
//				discountPrice = getBigDecimalString(temp);
//				return discountPrice;
//			} 
			else {
				discountPrice = price;
				//discounted = false;
				return discountPrice;
			}
		} 
//		else {
//			discountPrice = price;
//			return discountPrice;
//		}
	//}
	
	private String getBigDecimalString(double temp){
		BigDecimal bd = new BigDecimal(temp);
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		return bd.toString();
	}

	// Student get 10% off
	public String discountID() {
		int idNum;
		try {
			idNum = Integer.parseInt(id);
			// if (!discounted) {
			if (idNum >= LOWEST_BANNER_ID && idNum <= HIGHEST_BANNER_ID) {
				code = CODE_1;
				return getDiscountAmount();
				// discounted = true;
			} 
			else {
				return "0.00";
			}
			// }
		} catch (Exception e) {
			System.out.println("Invalid ID number");
			return "0.00";
		}
	}

}
