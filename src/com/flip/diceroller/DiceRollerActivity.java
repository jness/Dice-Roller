package com.flip.diceroller;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import java.util.Scanner;
import java.util.regex.MatchResult;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

import com.flip.diceroller.Die;
import com.flip.diceroller.Coin;


public class DiceRollerActivity extends Activity {

	private Button d4Button, d6Button, d8Button, d10Button, d12Button;
	private Button d100Button, d20Button, coinButton, rollButton;
	private Die d4, d6, d8, d10, d12, d20, d100, coin, udie;
	private TextView value, label;
	private EditText text;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        this.value = (TextView) findViewById(R.id.textViewValue);
    	this.label = (TextView) findViewById(R.id.textViewLabel);
    	this.text = (EditText) findViewById(R.id.editText);
    	
    	// Text input form
        this.rollButton = (Button) findViewById(R.id.roll);
        this.rollButton.setOnClickListener(new Button.OnClickListener() {  
        public void onClick(View v)
            {
        		if (text.getText().length() != 0) {
        			try {
        	    		Scanner s = new Scanner(text.getText().toString());
        	    		s.findInLine("(\\d+)d(\\d+)");
        	    		MatchResult result = s.match();
        	    	
        	    		udie = new Die(Integer.parseInt(result.group(1)), Integer.parseInt(result.group(2)));
        	    		udie.roll();
        	    		label.setText(udie.getQuantity() + "d" + udie.getSides());
        	    		value.setText(Integer.toString(udie.getResults()));
        	    		
        			} catch(Exception e) {
        	    		label.setText("error");
        	    		value.setText("0");
        			}
        			
        			// hide the keyboard
            		InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            		imm.hideSoftInputFromWindow(text.getWindowToken(), 0);
        		}
            }
         });

    	// our 4 sided die
    	this.d4 = new Die(1, 4);
        this.d4Button = (Button) findViewById(R.id.d4);
        this.d4Button.setOnClickListener(new Button.OnClickListener() {  
        public void onClick(View v)
            {
                d4.roll();
                label.setText(d4.getQuantity() + "d" + d4.getSides());
                value.setText(Integer.toString(d4.getResults()));
            }
         });
        
    	// our 6 sided die
    	this.d6 = new Die(1, 6);
        this.d6Button = (Button) findViewById(R.id.d6);
        this.d6Button.setOnClickListener(new Button.OnClickListener() {  
        public void onClick(View v)
            {
                d6.roll();
                label.setText(d6.getQuantity() + "d" + d6.getSides());
                value.setText(Integer.toString(d6.getResults()));
            }
         });
        
    	// our 8 sided die
    	this.d8 = new Die(1, 8);
        this.d8Button = (Button) findViewById(R.id.d8);
        this.d8Button.setOnClickListener(new Button.OnClickListener() {  
        public void onClick(View v)
            {
                d8.roll();
                label.setText(d8.getQuantity() + "d" + d8.getSides());
                value.setText(Integer.toString(d8.getResults()));
            }
         });
        
    	// our 10 sided die
    	this.d10 = new Die(1, 10);
        this.d10Button = (Button) findViewById(R.id.d10);
        this.d10Button.setOnClickListener(new Button.OnClickListener() {  
        public void onClick(View v)
            {
                d10.roll();
                label.setText(d10.getQuantity() + "d" + d10.getSides());
                value.setText(Integer.toString(d10.getResults()));
            }
         });
        
    	// our 12 sided die
    	this.d12 = new Die(1, 12);
        this.d12Button = (Button) findViewById(R.id.d12);
        this.d12Button.setOnClickListener(new Button.OnClickListener() {  
        public void onClick(View v)
            {
                d12.roll();
                label.setText(d12.getQuantity() + "d" + d12.getSides());
                value.setText(Integer.toString(d12.getResults()));
            }
         });
        
    	// our 20 sided die
    	this.d20 = new Die(1, 20);
        this.d20Button = (Button) findViewById(R.id.d20);
        this.d20Button.setOnClickListener(new Button.OnClickListener() {  
        public void onClick(View v)
            {
                d20.roll();
                label.setText(d20.getQuantity() + "d" + d20.getSides());
                value.setText(Integer.toString(d20.getResults()));
            }
         });
        
    	// our 100 sided die
    	this.d100 = new Die(1, 100);
        this.d100Button = (Button) findViewById(R.id.d100);
        this.d100Button.setOnClickListener(new Button.OnClickListener() {  
        public void onClick(View v)
            {
                d100.roll();
                label.setText(d100.getQuantity() + "d" + d100.getSides());
                value.setText(Integer.toString(d100.getResults()));
            }
         });
        
    	// our coin
    	this.coin = new Coin(1, 2);
        this.coinButton = (Button) findViewById(R.id.coin);
        this.coinButton.setOnClickListener(new Button.OnClickListener() {  
        public void onClick(View v)
            {
                coin.roll();
                label.setText("coin");
                value.setText(((coin.getResults() != 0) ? "Heads" : "Tails"));
            }
         });
         
    }
    
}