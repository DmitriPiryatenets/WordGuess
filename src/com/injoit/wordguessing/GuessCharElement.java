package com.injoit.wordguessing;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

public class GuessCharElement extends Button{

	private Context context;
	
	private GuessCharObject guessCharObject;
	
	public GuessCharElement(Context context){
		super(context);
		this.context = context;
	}
	
	public GuessCharElement(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
	}
	
	public GuessCharObject getCharObject(){
		return guessCharObject;
	}
	
	public void setCharObject(GuessCharObject gco){
		guessCharObject = gco;
		System.out.println(gco);
		updateImage();
	}
	
	private void updateImage(){
		if (guessCharObject.isSpace()){
			setBackgroundResource(R.drawable.cell_transparent);
		}
		else{
			if (guessCharObject.getCurrentCharSymbol() == null){
				setBackgroundResource(R.drawable.cellquestion);
			}
			else{
				setBackgroundResource(R.drawable.cell_transparent);
				setText(guessCharObject.getCurrentCharSymbol());
			}
		}
	}
	
}
