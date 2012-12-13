/**
 * Class which is the base Pop. Made up of two strings, size and type.
 * 
 */
package com.example.fanfourproject;

public class Pop {
	
	private String size = "";
	private String type = "";
	/**
	 * Contructor for the Object.
	 * 
	 * @param s Size
	 * @param t Type
	 */
	public Pop(String s, String t){
		this.size = s;
		this.type = t;
	}
	/**
	 * Gets pop size
	 * 
	 * @return String of the size
	 */
	public String getPopSize(){
		return size;
	}
	/**
	 * Sets the pop size
	 * 
	 * @param s Size to be set
	 */
	public void setPopSize(String s){
		this.size = s;
	}
	/**
	 * Gets pop type
	 * 
	 * @return String of the type
	 */
	public String getPopType(){
		return type;
	}
	/**
	 * Sets the pop type
	 * 
	 * @param t String of the type
	 */
	public void setPopType(String t){
		this.type = t;
	}
	/**
	 * Converts pop to a string
	 * 
	 * @return String of the pop object
	 */
	public String toString(){
		return size + " of " + type;
	}
}
