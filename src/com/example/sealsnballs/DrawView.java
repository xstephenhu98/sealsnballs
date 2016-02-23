package com.example.sealsnballs;


	
	import android.R;
	import android.app.Activity;
	import android.graphics.Canvas;
	import android.graphics.Color;
	import android.graphics.Paint;
	import android.os.Bundle;
	import android.view.View;

		public class DrawView  extends Activity {
			
		    Ballmove move;

		    @Override
		    public void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);

		       move = new Ballmove(this);
		       move.setBackgroundColor(Color.WHITE);
		        setContentView(move);

		    }
		}
	  

