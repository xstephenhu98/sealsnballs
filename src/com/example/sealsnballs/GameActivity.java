package com.example.sealsnballs;


	
	
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

		public class GameActivity extends Activity {
			
		    GameRender render;
		    DBAdapter db = new DBAdapter(this);
		   
		    

		    @Override
		    public void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        
		       render = new GameRender(this);
		       render.setBackgroundColor(Color.WHITE);
		        setContentView(render);
		        
		       Timer time = new Timer();
		       
		       time.scheduleAtFixedRate(new TimerTask(){
		    	   public void run(){
		    		   endGame();
		    	   }
		       },
		    		   100,50);
		 
		        
		        
		    }  
		    
		    
		    
		    public void endGame(){
		    	if(render.getGameOverStatus() == true){
		    		//int score = render.returnScore();
		    		//db.insertScore(score);
		    		startActivity(new Intent(this, MainActivity.class));
		    		Log.d("", "true");
		    	}
		    }
}

		
	  

