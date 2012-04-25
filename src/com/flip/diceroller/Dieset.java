package com.flip.diceroller;

import java.util.Scanner;
import java.util.regex.MatchResult;

import com.flip.diceroller.Die;

public class Dieset<pubic> {

	private Die[] dice;
	private int value;
	private String label;
	
	public Dieset() {
		this.value = 0;
		this.dice = new Die[0];
	}
	
	public Dieset(String input) {
		this.value = 0;
		this.dice = new Die[0];
		try {
			Scanner s = new Scanner(input);
			s.findInLine("(\\d+)d(\\d+)");
			MatchResult result = s.match();	
			int quantity = Integer.parseInt(result.group(1));
			int size = Integer.parseInt(result.group(2));
		
			for (int i = 0; i < quantity; i++) {
				Die die = new Die(size);
				this.addDie(die);
			}
		} catch(Exception e) {
			this.label = "Error";
			this.value = 0;
		}
	}
	
	public void addDie(Die die) {
		Die[] d = new Die[this.dice.length + 1];
		for (int i = 0; i < this.dice.length; i++) {
			d[i] = this.dice[i];
		}
		d[this.dice.length] = die;
		this.dice = d;
	}
	
	public void clearDice() {
		this.dice = new Die[0];
	}
	
	public void roll() {
		this.value = 0;
		for (int i = 0; i < this.dice.length; i++) {
			dice[i].roll();
			this.value += dice[i].getIntValue();
		}
		// hacky way to determine label
		this.label = dice.length + "d" + dice[0].getSides();
	}
	
	public int getIntValue() {
		return this.value;
	}
	
	public String getStrValue() {
		return Integer.toString(this.value);
	}
	
	public String getLabel() {
		return this.label;
	}
}
