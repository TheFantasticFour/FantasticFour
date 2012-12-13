/**
 * This Class aids in gathering comparing the User input to a desired discount code and returning whether the code given is valid.
 * 
 * @author FantasticFour
 */
package com.example.fanfourproject;

import java.math.BigDecimal;

public class DiscountCalculate {
	
	public static final String CODE_1 = "DISC10";
	public static final String CODE_2 = "DISC15";
	public static final String CODE_3 = "DISC20";
	public static final String CODE_4 = "DISC4OFF";
	
	public static final int LOWEST_BANNER_ID = 900190000;
	public static final int HIGHEST_BANNER_ID = 900209999;

	private String code = "";
	private String price = "";
	private String id = "";
	
	/**
	 * Constructor for when user uses a non-Banner ID code.
	 * 
	 * @param code The discount code entered.
	 * @param price The original price.
	 */
	
	public DiscountCalculate(String code, String price) {
		this.code = code;
		this.price = price;
	}
	
	/**
	 * Constructor for when user uses a Banner ID code.
	 * 
	 * @param code The discount code entered.
	 * @param id The Banner ID for the User.
	 * @param price The original price.
	 */
	public DiscountCalculate(String code, String id, String price) {
		this.code = code;
		this.id = id;
		this.price = price;
	}
	
	/**
	 *  This method takes the original amounts and codes and determines the new price for a given User.
	 * 
	 * @return Returns the string of the new amount.
	 */
	public String getDiscountAmount(){
		String discountAmount1 = "0.0";
		String discountAmount2 = "0.0";
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
		int idNum;
		try{
			idNum = Integer.valueOf(id);
		}
		catch(Exception e){
			idNum = -1;
		}
				
		if(id == null){
			discountAmount2 = "0.0";
		}
		else if(idNum >= LOWEST_BANNER_ID && idNum <= HIGHEST_BANNER_ID){
			double temp = Double.parseDouble(price);
			temp = temp * 0.1;
			discountAmount2 = getBigDecimalString(temp);
		}
		
		Double totalDiscount = Double.valueOf(discountAmount1) + Double.valueOf(discountAmount2);
		
		return getBigDecimalString(totalDiscount);
	}
	
	/**
	 * Helper method for formatting
	 * 
	 * @param temp The original double value.
	 * @return String of the corresponding value.
	 */
	private String getBigDecimalString(double temp){
		BigDecimal bd = new BigDecimal(temp);
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		return bd.toString();
	}
}
