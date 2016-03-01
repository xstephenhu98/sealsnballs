package com.example.sealsnballs;


import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class GameRender extends View {
	int score = 0;
	Canvas canvas;
    Paint paint = new Paint();
    Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.seal);
    int y = 0;
    ArrayList<Seal> seals = new ArrayList<Seal>();
    boolean isOver = false;
    
 int speed=0;
 

  public GameRender(Context context) {
        super(context);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10f);
        
        //setBackgroundResource(R.drawable.cscbackground);  this didn't work
        
        Timer timer = new Timer();
        
        timer.scheduleAtFixedRate(new TimerTask(){
        	public void run(){
        	int rand = (int)Math.ceil(Math.random()*12);
        	int value = (int)Math.ceil(Math.random()*5);
        	
        	if(rand == 1){
        		Seal seal= new Seal(600,800,value,false);
        		seals.add(seal);
        	}
        		for(int i=0;i<seals.size();i++){
        			Seal s = seals.get(i);
        			int curX = s.getX();
        			curX -= 30;
        			s.setX(curX);
        			

        		}
        		
        			
        			
        		
        		
        	}
        	
        }, 
        		500,50);
		invalidate();
		
		
    
    }
  
  
  

  public boolean onTouchEvent(MotionEvent touch) {
		speed = -30;
		speed+=5;
		y+=speed;
        
		invalidate();
		return true;
		
	}

  	public boolean getGameOverStatus(){
  		return isOver;
  	}
  	
  	public int returnScore(){
  		return score;
  	}
  	
  	protected void onDraw(Canvas canvas) 
    {canvas.drawPaint(paint);
    
    paint.setStyle(Paint.Style.FILL);
    
    paint.setColor(Color.parseColor("#FFFF00"));
       
       canvas.drawCircle(100, y, 35, paint);
       
       paint.setColor(Color.parseColor("#CD5C5C"));
       
       speed+=5;
       y+=speed;
      
       for (int i=0;i<seals.size();i++){
       	Seal s = seals.get(i);
       	canvas.drawBitmap(b, s.getX(), s.getY(), paint);
       	if (y >= s.getY()){
       		s.setHitStatus(true);
       		score+=s.getVal();
       	}
       }
       
	   if (y>=950) {
		   isOver = true;
		   //Log.d("", "message");
	   }
    	 
       
       invalidate();
     
   }


  


}
