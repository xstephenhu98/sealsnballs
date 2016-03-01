package com.example.sealsnballs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	public void goToGame(View view){
		startActivity(new Intent(this, GameActivity.class));
	}
	
	public void goToScores(View view){
    	startActivity(new Intent(this, ListView.class));
    }
}
