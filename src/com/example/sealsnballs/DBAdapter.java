package com.example.sealsnballs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
//Mike

public class DBAdapter {
    static final String KEY_ROWID = "_id";
    static final String KEY_SCORE = "score";
    static final String TAG = "DBAdapter";

    static final String DATABASE_NAME = "MyDB";
    static final String DATABASE_TABLE = "contacts";
    static final int DATABASE_VERSION = 4;

    static final String DATABASE_CREATE =
        "create table contacts (_id integer primary key autoincrement, "
        + "score text not null);";

    final Context context;

    DatabaseHelper DBHelper;
    SQLiteDatabase db;
    
    public DBAdapter(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            try {
                db.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS contacts");
            onCreate(db);
        }
    }

    //---opens the database---
    public DBAdapter open() throws SQLException 
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---
    public void close() 
    {
        DBHelper.close();
    }

    //---insert a contact into the database---
    public long insertScore(int score) 
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_SCORE, score);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }


    public Cursor getAllScores()
    {
        return db.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_SCORE}, null, null, null, null, null);
    }
    public int getHighScore()
    {
    	int highscore = 0;
    	Cursor c = getAllScores();
    	if(c.moveToFirst()){
    			if(c.getInt(2)>highscore){
    					highscore = (c.getInt(2));
    			}
    	}
    	if(c.moveToNext()){
    		if(c.getInt(2)>highscore){
    			highscore = (c.getInt(2));
    		}
    	}
    	return highscore;
    }
    
   public Cursor getHighScores(){
	   return db.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_SCORE}, "order by score desc limit 10", null, null, null, null);
    	
    }
}
    
 