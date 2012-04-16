package com.flip.diceroller;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.KeyEvent;
import android.view.View;

import java.util.Scanner;
import java.util.regex.MatchResult;

import com.flip.diceroller.DiceUtils;


public class DiceRollerActivity extends Activity implements OnClickListener {
	
	private Button d4, d6, d8, d10, d12, d20, d100, coin, reset;
	private EditText text;
	private TextView value, label;
	private DiceUtils dicetools;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        this.dicetools = new DiceUtils();
        
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
        this.reset = (Button) findViewById(R.id.reset);
        
        // set the listeners
        this.d4.setOnClickListener(this);
        this.d6.setOnClickListener(this);
        this.d8.setOnClickListener(this);
        this.d10.setOnClickListener(this);
        this.d12.setOnClickListener(this);
        this.d20.setOnClickListener(this);
        this.d100.setOnClickListener(this);
        this.reset.setOnClickListener(this);
        this.coin.setOnClickListener(this);
        this.text.setOnClickListener(this);
         
    }
        
    public void onClick(View v) {
    	// handle user input
    	if (this.text.getId() == v.getId()) {
    		if (this.text.getText().length() != 0) {
    			String label_text = this.text.getText().toString();
    			String results = this.dicetools.diceNotation(label_text);
    			label.setText(this.dicetools.diceNotationLabel(label_text));
    			value.setText(results);
    			this.text.setText("");
    		}
    			
    	// handle reset button
    	} else if (this.reset.getId() == v.getId()) {
    		label.setText("");
    		value.setText("");
    	
    	// handle flip coin
    	} else if (this.coin.getId() == v.getId()) {
    		String results = this.dicetools.flip();
    		label.setText(v.getTag().toString());
    		value.setText(results);
    		
    	// handle dice buttons
    	} else {
    		String label_text = v.getTag().toString();
    		String results = this.dicetools.roll(label_text);
    		label.setText(label_text);
    		value.setText(results);
    		
    	}	
    }
    
}