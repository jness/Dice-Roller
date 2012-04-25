package com.flip.diceroller;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import com.flip.diceroller.Coin;

public class CoinButton extends Button {

	private Coin coin;
	
	public CoinButton(Context context) {
		super(context);
		this.coin = new Coin();
	}

	public CoinButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.coin = new Coin();
	}

	public CoinButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.coin = new Coin();
	}

	public Coin getCoin() {
		return coin;
	}

}
