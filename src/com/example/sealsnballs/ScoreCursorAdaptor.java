package com.example.sealsnballs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class ScoreCursorAdaptor extends CursorAdapter {
	  @SuppressLint("NewApi")
	public ScoreCursorAdaptor(Context context, Cursor cursor, int flags) {
	      super(context, cursor, 0);
	  }

	  // The newView method is used to inflate a new view and return it, 
	  // you don't bind any data to the view at this point. 
	  @Override
	  public View newView(Context context, Cursor cursor, ViewGroup parent) {
	      return LayoutInflater.from(context).inflate(R.layout.activity_score_cursor_adaptor, parent, false);
	  }

	  // The bindView method is used to bind all data to a given view
	  // such as setting the text on a TextView. 
	  @Override
	  public void bindView(View view, Context context, Cursor cursor) {
	      // Find fields to populate in inflated template
	      TextView nameEntry = (TextView) view.findViewById(R.id.name_entry);
	      // Extract properties from cursor
	      String body = cursor.getString(cursor.getColumnIndexOrThrow("name"));
	      
	      // Populate fields with extracted properties
	      nameEntry.setText(body);
	      
	  }
	}
