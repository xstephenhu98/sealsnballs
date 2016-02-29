package com.example.sealsnballs;


import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.app.NotificationCompat;
import android.view.MotionEvent;
import android.view.View;

public class GameRender extends View {
	
    Paint paint = new Paint();
    Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.seal);
    int y = 0;
    ArrayList<Seal> seals = new ArrayList<Seal>();
    
 int speed=0;
 

  public GameRender(Context context) {
        super(context);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10f);
        Seal s1 = new Seal(200,800,1,false);
        seals.add(s1);
        setBackgroundResource(R.drawable.cscbackground);
        
        
        
    
    }
  
  
  

  public boolean onTouchEvent(MotionEvent touch) {
		speed = -30;
		speed+=5;
		y+=speed;
        
		invalidate();
		return true;
		
	}

  
    protected void onDraw(Canvas canvas) 
    {canvas.drawPaint(paint);
    for (Seal s : seals){
    	canvas.drawBitmap(b, s.getX(), s.getY(), paint);
    }
    paint.setStyle(Paint.Style.FILL);
    
    paint.setColor(Color.parseColor("#FFFF00"));
       
       canvas.drawCircle(100, y, 35, paint);
       
       paint.setColor(Color.parseColor("#CD5C5C"));
       
       speed+=5;
       y+=speed;
      
       invalidate();
     
   }

   





}
