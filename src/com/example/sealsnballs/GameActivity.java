package com.example.sealsnballs;


	
	
	import java.util.Timer;
import java.util.TimerTask;

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
		        
		        genSeals seals = new genSeals();
		        Timer timer = new Timer();
		        
		        timer.scheduleAtFixedRate(new TimerTask(){
		        	public void run(){
		        		Seal seal= new Seal(render.canvas.getWidth(),800,1,false);
		        		render.seals.add(seal);
		        		
		        		for(int i=0;i<render.seals.size();i++){
		        			Seal s = render.seals.get(i);
		        			int curX = s.getX();
		        			curX -= 5;
		        			s.setX(curX);
		        			
		        			render.invalidate();
		        		}
		        	}
		        	
		        }, 
		        		500,500);
		    
		    }    
}

		
	  

