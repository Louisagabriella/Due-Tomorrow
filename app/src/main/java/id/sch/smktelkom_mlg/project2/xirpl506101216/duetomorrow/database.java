package id.sch.smktelkom_mlg.project2.xirpl506101216.duetomorrow;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kyle on 05/09/16.
 * <p/>
 * SQLite database for storing notes/alerts
 */
public class database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME1 = "reminderData.db1";
    public static final String DB_TABLE_NAME1 = "reminders1";
    public static final String DB_COLUMN_ID1 = "_id1";
    public static final String DB_COLUMN_TYPE1 = "type1";
    public static final String DB_COLUMN_TITLE1 = "title1";
    public static final String DB_COLUMN_CONTENT1 = "content1";
    public static final String DB_COLUMN_TIME1 = "time1";
    public static final String DB_COLUMN_FREQUENCY1 = "frequency1";
    private static final int DATABASE_VERSION1 = 1;

    public database(Context context) {
        super(context, DATABASE_NAME1, null, DATABASE_VERSION1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + DB_TABLE_NAME1 + "(" +
                DB_COLUMN_ID1 + " INTEGER PRIMARY KEY, " +
                DB_COLUMN_TYPE1 + " TEXT, " +
                DB_COLUMN_TITLE1 + " TEXT, " +
                DB_COLUMN_CONTENT1 + " TEXT, " +
                DB_COLUMN_FREQUENCY1 + " TEXT, " +
                DB_COLUMN_TIME1 + " LONG)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE_NAME1);
        onCreate(db);
    }

    public boolean insertNote(String title, String content) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DB_COLUMN_TYPE1, "note");
        values.put(DB_COLUMN_TITLE1, title);
        values.put(DB_COLUMN_CONTENT1, content);
        db.insert(DB_TABLE_NAME1, null, values);
        return true;
    }

    public long insertAlert(String title, String content, long time, int frequency) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DB_COLUMN_TYPE1, "alert");
        values.put(DB_COLUMN_TITLE1, title);
        values.put(DB_COLUMN_CONTENT1, content);
        values.put(DB_COLUMN_TIME1, time);
        values.put(DB_COLUMN_FREQUENCY1, frequency);
        return db.insert(DB_TABLE_NAME1, null, values);
    }

    public boolean updateNote(Integer id, String title, String note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DB_COLUMN_CONTENT1, note);
        values.put(DB_COLUMN_TITLE1, title);
        db.update(DB_TABLE_NAME1, values, DB_COLUMN_ID1 + " = ? ",
                new String[]{Integer.toString(id)});
        return true;
    }

    public boolean updateAlert(Integer id, String title, String note, long time, int frequency) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DB_COLUMN_CONTENT1, note);
        values.put(DB_COLUMN_TITLE1, title);
        values.put(DB_COLUMN_TIME1, time);
        values.put(DB_COLUMN_FREQUENCY1, frequency);
        db.update(DB_TABLE_NAME1, values, DB_COLUMN_ID1 + " = ? ",
                new String[]{Integer.toString(id)});
        return true;
    }

    public boolean updateTime(Integer id, long time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DB_COLUMN_TIME1, time);
        db.update(DB_TABLE_NAME1, values, DB_COLUMN_ID1 + " = ? ",
                new String[]{Integer.toString(id)});
        return true;
    }

    public Cursor getItem(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + DB_TABLE_NAME1 + " WHERE " +
                DB_COLUMN_ID1 + " = ? ", new String[]{Integer.toString(id)});
    }

    public Cursor getAllItems() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + DB_TABLE_NAME1 + " ORDER BY " + DB_COLUMN_ID1 + " DESC", null);
    }

    public Cursor getAllAlerts() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + DB_TABLE_NAME1 + " WHERE " +
                DB_COLUMN_TYPE1 + " = ? ", new String[]{"alert"});
    }

    public Cursor getAllNotes() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + DB_TABLE_NAME1 + " WHERE " +
                DB_COLUMN_TYPE1 + " = ? ", new String[]{"note"});
    }

    public Integer deleteItem(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(DB_TABLE_NAME1, DB_COLUMN_ID1 + " = ? ",
                new String[]{Integer.toString(id)});
    }

    public boolean isEmpty() {
        return getAllItems().getCount() == 0;
    }

}
