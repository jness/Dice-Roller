package com.flip.diceroller;

import java.util.Random;

public class Die {
	
	protected int sides;
	private int quantity;
	private int results;
	  
	public Die(int quantity, int sides) {  
	  this.sides = sides;
	  this.quantity = quantity;
	 } 
	
	public int getSides() {
		return this.sides;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public int getResults() {
		return this.results;
	}
	
	public void setResults(int results) {
		this.results = results;
	}
	
    public void roll() {
    	this.setResults(0);
    	Random rand = new Random();
    	for (int i=1; i<=this.quantity; i++) {
    		this.setResults(this.getResults() + rand.nextInt(this.sides) + 1);
    	}
    }


}
