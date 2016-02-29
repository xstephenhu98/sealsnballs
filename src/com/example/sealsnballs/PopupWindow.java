package com.example.sealsnballs;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.example.sealsnballs.DBAdapter;
import com.example.sealsnballs.R;

public class PopupWindow extends Activity {
	
	DBAdapter db = new DBAdapter(this);
	GameActivity gm = new GameActivity();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_popup_window);
		
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		
		int width = (int)Math.ceil(dm.widthPixels*(.8));
		int height = (int)Math.ceil(dm.heightPixels*(.8));
		
		getWindow().setLayout(width, height);
		
		displayScores();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.popup_window, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void displayScores(){
		int max = db.getHighScore();
		int recent = 0;
				//gm.score(); - once we have a way to get the score from the game.
		
		TextView highScore = (TextView)findViewById(R.id.textView5);
		TextView recentScore = (TextView)findViewById(R.id.textView3);
		
		highScore.setText(max);
		recentScore.setText(recent);
	}
}
