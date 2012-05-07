package com.flip.diceroller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;

import com.flip.diceroller.Die;
import com.flip.diceroller.DieButton;
import com.flip.diceroller.Dieset;


public class DiceRollerActivity extends Activity {
	
	private TextView value, label;
	private EditText text;
	private WakeLock wl;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {

    	// wake lock to avoid screen locking
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wl = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "WakeLock");
    	
    	super.onCreate(savedInstanceState);
    	wl.acquire();
    	
        setContentView(R.layout.main);

        this.value = (TextView) findViewById(R.id.textViewValue);
    	this.label = (TextView) findViewById(R.id.textViewLabel);
    	this.text = (EditText) findViewById(R.id.editText);
    }	
    
    
    @Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		wl.release();
	}


	public void typeDie(View btn) {
    	if (text.getText().length() != 0) {
	    		Dieset dieset = new Dieset(text.getText().toString());
	    		dieset.roll();
	    		label.setText(dieset.getLabel());
	    		value.setText(dieset.getStrValue());
    	}
    }
    
    public void onClickDie(View btn) {
    	DieButton button = (DieButton) btn; 
    	Die die = (Die) button.getDie();
    	die.roll();
    	label.setText(button.getText().toString());
    	value.setText(die.getStrValue());  
    }

    public void onClickCoin(View btn) {
    	CoinButton button = (CoinButton) btn; 
    	Coin coin = (Coin) button.getCoin();
    	coin.roll();
    	label.setText(button.getText().toString());
    	value.setText(coin.getValue());  
    }
    
}