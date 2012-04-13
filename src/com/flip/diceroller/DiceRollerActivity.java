package com.flip.diceroller;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import java.util.Random;

public class DiceRollerActivity extends Activity {
	   // Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void reset(View view) {
    	TextView value = (TextView) findViewById(R.id.textViewValue);
    	TextView label = (TextView) findViewById(R.id.textViewLabel);
    	
    	// set all text fields to blank
		value.setText("");
		label.setText("");
    }
    
    public void flip(View view) {	    	
    	TextView value = (TextView) findViewById(R.id.textViewValue);
    	TextView label = (TextView) findViewById(R.id.textViewLabel);
    	
    	// random boolean
    	Random rand = new Random();
    	boolean x = rand.nextBoolean();
    	
    	
    	// Set the the value and label
    	if (x) {
    		value.setText("Heads");
    		label.setText("coin");
    	} else {
    		value.setText("Tails");
    		label.setText("coin");
    	}
    	
    }

    public void roll(View view) {
    	Button button = (Button) view;
    	TextView value = (TextView) findViewById(R.id.textViewValue);
    	TextView label = (TextView) findViewById(R.id.textViewLabel);
    	
    	// Get our Button Tag and convert to Int
    	String tag = button.getTag().toString();
    	int d = Integer.parseInt(tag);

    	// Using tag Int generate a random number
    	Random rand = new Random();
    	int x = rand.nextInt(d) + 1;

    	// Set the the value and label
    	label.setText(String.format("d%d", d));
    	value.setText(String.format("%d", x));
    }

}