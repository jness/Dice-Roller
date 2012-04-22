package com.flip.diceroller;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

public class DieButton extends Button {
	
	Die die;

	public DieButton(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public DieButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public DieButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
	
	public void setDie(Die die) {
		this.die = die;
	}
	
	public Die getDie() {
		return this.die;
	}

}
