package com.flip.diceroller;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;

import java.util.Scanner;
import java.util.regex.MatchResult;

import com.flip.diceroller.Die;
import com.flip.diceroller.DieButton;
import com.flip.diceroller.Dieset;


public class DiceRollerActivity extends Activity {
	
	private TextView value, label;
	private EditText text;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        this.value = (TextView) findViewById(R.id.textViewValue);
    	this.label = (TextView) findViewById(R.id.textViewLabel);
    	this.text = (EditText) findViewById(R.id.editText);
    }	
    
    public void typeDie(View btn) {
    	if (text.getText().length() != 0) {
	    		Dieset dieset = new Dieset(text.getText().toString());
	    		dieset.roll();
	    		int total = dieset.getIntValue();
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