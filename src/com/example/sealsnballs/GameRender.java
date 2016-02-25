package com.example.sealsnballs;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class GameRender extends View {
    Paint paint1 = new Paint();
    Paint paint = new Paint();
    int y = 0;
 int downspeed=7;
 int upspeed=5;

  public GameRender(Context context) {
        super(context);
        paint1.setColor(Color.BLACK);
        paint1.setStrokeWidth(10f);
        
    
    }
  
  
  

  public boolean onTouchEvent(MotionEvent touch) {
		if (y<10) 
        y+=upspeed;
		return true;
		
	}

  
    protected void onDraw(Canvas canvas) 
    {canvas.drawPaint(paint);
    paint.setStyle(Paint.Style.FILL);
    paint.setColor(Color.parseColor("#00BFFF"));
       
      
    canvas.drawCircle(800, 20, 35, paint);
    paint.setColor(Color.parseColor("#FFFF00"));
       
      
       canvas.drawCircle(100, y, 35, paint);
       paint.setColor(Color.parseColor("#CD5C5C"));
   
       y+=downspeed;
       invalidate();
     
   }








}
