package com.injoit.wordguessing;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	
	private GuessLine gl;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gl = (GuessLine) findViewById(R.id.guessLine);
//        List<GuessCharObject> list = new ArrayList<GuessCharObject>();
//        for (int i=0;i<5;i++){
//        	boolean is_space = false;
//        	if (i == 3)
//        		is_space = true;
//        	GuessCharObject gce = new GuessCharObject();
//        	list.add(gce);
//        	gl.setGuessCharObjectList(list);
//        }
        gl.setWord("ab de");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void addSymbol(View view){
    	gl.setCurrentSymbol("a");
    }

    public void removeSymbol(View view){
    	gl.removeLastElement();
    }
    
}
