package com.flip.diceroller;

import java.util.Random;

public class Coin {
	
	protected int value;
	
	public String getValue() {
		return this.value -1 != 0 ? "Heads" : "Tails";
	}
	
    public void roll() {
    	Random rand = new Random();
    	this.value = rand.nextInt(2) + 1;
    }
    
}

