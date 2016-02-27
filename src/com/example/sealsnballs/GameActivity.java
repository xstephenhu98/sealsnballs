package com.example.sealsnballs;


	
	
	import android.app.Activity;

	import android.graphics.Color;

	import android.os.Bundle;

		public class GameActivity extends Activity {
			
		    GameRender render;

		    @Override
		    public void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        
		       render = new GameRender(this);
		       render.setBackgroundColor(Color.WHITE);
		        setContentView(render);
		    
		    }    
}

		
	  

