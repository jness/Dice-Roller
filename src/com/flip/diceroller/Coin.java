package com.flip.diceroller;

import java.util.Random;
import com.flip.diceroller.Die;

public class Coin extends Die {
	
	public Coin(int quantity, int sides) {
		super(quantity, sides);
	}
	
    public void roll() {
    	this.setResults(0);
    	Random rand = new Random();
    	this.setResults(rand.nextInt(this.getSides()));
    }

}
