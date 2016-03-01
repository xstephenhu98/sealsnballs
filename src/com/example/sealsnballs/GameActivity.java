package com.example.sealsnballs;


	
	
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

		public class GameActivity extends Activity {
			
		    GameRender render;
		    DBAdapter db = new DBAdapter(this);
		    int score = render.returnScore();
		    

		    @Override
		    public void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        
		       render = new GameRender(this);
		       render.setBackgroundColor(Color.WHITE);
		        setContentView(render);
		        
		        
		        
		       if(render.gameOver() == true){
		    	   	db.insertScore(score);
		    		startActivity(new Intent(this, PopupWindow.class));
		    	}
		    
		    }    
		    
		    
}

		
	  

