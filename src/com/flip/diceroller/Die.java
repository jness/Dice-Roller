package com.flip.diceroller;

import java.util.Random;

public class Die {
	
	protected int sides;
	protected int value;
	  
	public Die(int sides) {  
	  this.sides = sides;
	 } 
	
	public int getIntValue() {
		return this.value;
	}
	
	public String getStrValue() {
		return Integer.toString(this.value);
	}
	
	public int getSides() {
		return this.sides;
	}
	
    public void roll() {
    	Random rand = new Random();
    	this.value = rand.nextInt(this.sides) + 1;
    	}
    
}

