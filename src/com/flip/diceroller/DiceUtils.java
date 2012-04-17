package com.flip.diceroller;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.MatchResult;

import android.widget.TextView;

public class DiceUtils {
	private String value;
	private String label;
	private int dice_count;
	private int dice_size;
	
	public String getValue() {
		return this.value;
	}
	
	public String getLabel() {
		return this.label;
	}
	
    public void flipCoin() {	    	
    	Random rand = new Random();
    	boolean x = rand.nextBoolean();
    	this.label = "coin";
    	if (x) {
    		this.value = "Heads";
    	} else {
    		this.value = "Tails";
    	}
    }
    
    public void rollDice(String input) {
    	this.getDice(input);
    	int total = 0;
    	Random rand = new Random();
    	for (int i=1; i<=this.dice_count; i++) {
    		total = total + rand.nextInt(this.dice_size) + 1;
    	}
   		this.value = Integer.toString(total);
    }
    
    public void getDice(String input) {
    	Scanner s = new Scanner(input);
    	s.findInLine("(\\d+)d(\\d+)");
    	MatchResult result = s.match();
    	this.dice_count = Integer.parseInt(result.group(1));
    	this.dice_size = Integer.parseInt(result.group(2));	
    	this.label = this.dice_count + "d" + this.dice_size;
    }
}