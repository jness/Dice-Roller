package com.flip.diceroller;

import java.util.Random;

public class Die {
	
	protected int sides;
	protected int value;
	  
	public Die(int sides) {  
	  this.sides = sides;
	 } 
	
	public int getSides() {
		return this.sides;
	}
	
	public int getValue() {
		return this.value;
	}
	
    public int roll() {
    	Random rand = new Random();
    	this.value = rand.nextInt(this.sides) + 1;
    	return this.value;
    	}
    
}

