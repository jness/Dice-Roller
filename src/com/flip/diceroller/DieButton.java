package com.flip.diceroller;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import com.flip.diceroller.Die;

public class DieButton extends Button {

	Die die;
	
	public DieButton(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		int sides = new Integer(this.getTag().toString());
		this.die = new Die(sides);
	}

	public DieButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		int sides = new Integer(this.getTag().toString());
		this.die = new Die(sides);
	}

	public DieButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		int sides = new Integer(this.getTag().toString());
		this.die = new Die(sides);
	}
	
	public Die getDie() {
		return this.die;
	}
	
	public void setDie(Die die) {
		this.die = die;
	}

}
