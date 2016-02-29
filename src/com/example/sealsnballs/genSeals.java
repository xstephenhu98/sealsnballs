package com.example.sealsnballs;

import java.util.TimerTask;

import android.content.Context;

public class genSeals extends TimerTask {
	Context context = new Context();
	GameRender render = new GameRender(context);
	int length = render.seals.size();
	
	public void run(){
		int count = 0;
		count++;
		
		Seal seal= new Seal(render.canvas.getWidth(),800,1,false);
		render.seals.add(seal);
		
		for(int i=0;i<length;i++){
			Seal s = render.seals.get(i);
			int curX = s.getX();
			curX -= 5;
			
			render.invalidate();
			
		}
	}
	
	
}
