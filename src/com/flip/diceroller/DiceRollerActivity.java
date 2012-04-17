package com.flip.diceroller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.flip.diceroller.DiceUtils;


public class DiceRollerActivity extends Activity implements OnClickListener {
	private Button d4, d6, d8, d10, d12, d20, d100, coin, roll;
	private EditText text;
	private TextView value, label;
	private DiceUtils dicetools;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // handle the correct theme for 2.1 and ICS devices
        setContentView(R.layout.main);
        
        // link to each of our textviews
        this.value = (TextView) findViewById(R.id.textViewValue);
    	this.label = (TextView) findViewById(R.id.textViewLabel);
    	
    	// link to each of our edittext
    	this.text = (EditText) findViewById(R.id.editText);
        
        // link to each of our xml buttons
        this.d4 = (Button) findViewById(R.id.d4);
        this.d6 = (Button) findViewById(R.id.d6);
        this.d8 = (Button) findViewById(R.id.d8);
        this.d10 = (Button) findViewById(R.id.d10);
        this.d12 = (Button) findViewById(R.id.d12);
        this.d20 = (Button) findViewById(R.id.d20);
        this.d100 = (Button) findViewById(R.id.d100);
        this.coin = (Button) findViewById(R.id.coin);
        this.roll = (Button) findViewById(R.id.roll);
        
        // set the listeners
        this.d4.setOnClickListener(this);
        this.d6.setOnClickListener(this);
        this.d8.setOnClickListener(this);
        this.d10.setOnClickListener(this);
        this.d12.setOnClickListener(this);
        this.d20.setOnClickListener(this);
        this.d100.setOnClickListener(this);
        this.roll.setOnClickListener(this);
        this.coin.setOnClickListener(this);
         
    }
        
    public void onClick(View v) {
    	// handle user input
    	if (this.roll.getId() == v.getId()) {
    		if (this.text.getText().length() != 0) {
    			String input = this.text.getText().toString();
        		this.dicetools = new DiceUtils();
        		this.dicetools.rollDice(input);
        		label.setText(this.dicetools.getLabel());
        		value.setText(this.dicetools.getValue());
        		
        		// hide the keyboard
        		InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        		imm.hideSoftInputFromWindow(this.text.getWindowToken(), 0);
    		}
    	
    	// handle flip coin
    	} else if (this.coin.getId() == v.getId()) {
    		this.dicetools = new DiceUtils();
    		this.dicetools.flipCoin();
    		label.setText(this.dicetools.getLabel());
    		value.setText(this.dicetools.getValue());
    		
    	// handle dice buttons
    	} else {
    		String input = v.getTag().toString();
    		this.dicetools = new DiceUtils();
    		this.dicetools.rollDice(input);
    		label.setText(this.dicetools.getLabel());
    		value.setText(this.dicetools.getValue());
    		
    	}	
    }
    
}