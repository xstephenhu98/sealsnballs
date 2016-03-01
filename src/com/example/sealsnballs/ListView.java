package com.example.sealsnballs;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

public class ListView extends ListActivity {

	DBAdapter db = new DBAdapter(this);
	ScoreCursorAdaptor ScoreAdapter;

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);
		
		db.open();
		Cursor allcontacts = db.getHighScores();
		ScoreAdapter = new ScoreCursorAdaptor(this, allcontacts, 0);
		
		android.widget.ListView listView = getListView();
		// Setup cursor adapter using cursor from last step
		// Attach cursor adapter to the ListView 
		listView.setAdapter(ScoreAdapter);
		


	}
	
	public void toMainMenu(View view){
		startActivity(new Intent(this, MainActivity.class));
	}
}
