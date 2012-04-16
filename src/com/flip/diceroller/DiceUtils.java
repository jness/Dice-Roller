package com.flip.diceroller;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.MatchResult;

import android.widget.TextView;

public class DiceUtils {
	
	private String value;

    public String flip() {	    	
    	// random boolean
    	Random rand = new Random();
    	boolean x = rand.nextBoolean();
    	
    	if (x) {
    		value = "Heads";
    	} else {
    		value = "Tails";
    	}
    	return value;
    }
    
    public String diceNotation(String notation) {
    	int total = new Integer(0);
    	Scanner s = new Scanner(notation);
    	try {
    		s.findInLine("(\\d+)d(\\d+)");
    		MatchResult result = s.match();
    		int count = Integer.parseInt(result.group(1));
    		int size = Integer.parseInt(result.group(2));
    		String s_dice = result.group(1) + "d" + result.group(2);

    		// loop over our count and roll dice
    		for (int i=1; i<=count; i++) {
    			String x = this.roll(s_dice);
    			total = total + Integer.parseInt(x);
    		}
    		String s_total = Integer.toString(total);
    		return s_total;
        
    	} catch(Exception e3) {
    		String s_error = "Error..";
        	return s_error;
    	}
        	
    }
    
    public String diceNotationLabel(String notation) {
     	int total = new Integer(0);
    	Scanner s = new Scanner(notation);
    	try {
    		s.findInLine("(\\d+)d(\\d+)");
    		MatchResult result = s.match();
    		String count = result.group(1);
    		String size = result.group(2);
    		String s_dice = result.group(1) + "d" + result.group(2);
    		return s_dice;
        
    	} catch(Exception e3) {
    		String s_error = "Error..";
        	return s_error;
    	}
        	
    }
    	
    public String roll(String dice) {
    	Scanner s = new Scanner(dice);
    	s.findInLine("(\\d+)d(\\d+)");
    	MatchResult result = s.match();
    	int size = Integer.parseInt(result.group(2));

    	Random rand = new Random();
   		int x = rand.nextInt(size) + 1;

    	String s_total = Integer.toString(x);
   		return s_total;
    }

}
