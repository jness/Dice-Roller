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
    		try {
	    		Scanner s = new Scanner(text.getText().toString());
	    		s.findInLine("(\\d+)d(\\d+)");
	    		MatchResult result = s.match();
	    		
	    		int quantity = Integer.parseInt(result.group(1));
	    		int size = Integer.parseInt(result.group(2));
	    		int total = 0;
	    		
	    		Die die = new Die(size);
	    		for (int i=1; i<=quantity; i++) {
	    			die.roll();
	    			total += die.getValue();
	    		}
	    		
	    		label.setText(quantity + "d" + size);
	    		value.setText(Integer.toString(total));
	    		
			} catch(Exception e) {
	    		label.setText("error");
	    		value.setText("0");
			}
    	}
    }
    
    public void clickDie(View btn) {
    	DieButton button = (DieButton) btn; 
    	Die die = (Die) button.getDie();
    	die.roll();
    	label.setText(button.getText().toString());
    	value.setText(Integer.toString(die.getValue()));  
    }

    public void clickCoin(View btn) {
    	DieButton button = (DieButton) btn; 
    	Die coin = (Die) button.getDie();
    	coin.roll();
    	label.setText(button.getText().toString());
    	value.setText(coin.getValue() -1 != 0 ? "Heads" : "Tails");  
    }
    
}