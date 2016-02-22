package com.example.sealsnballs;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;

public class ListViewActivity extends ListActivity {

	DBAdapter db = new DBAdapter(this);
	ScoreCursorAdaptor scoreAdapter;

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);
		
		db.open();
		Cursor allscores = db.getAllScores();
		scoreAdapter = new ScoreCursorAdaptor(this, allscores, 0);
		
		ListView listView = getListView();
		// Setup cursor adapter using cursor from last step
		// Attach cursor adapter to the ListView 
		listView.setAdapter(scoreAdapter);

	}	
}
