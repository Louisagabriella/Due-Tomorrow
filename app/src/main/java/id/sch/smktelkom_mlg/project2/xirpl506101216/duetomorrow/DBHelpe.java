package id.sch.smktelkom_mlg.project2.xirpl506101216.duetomorrow;

/**
 * Created by Louisa on 3/28/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelpe extends SQLiteOpenHelper {
    /**
     * deklarasi konstanta-konstanta yang digunakan pada database, seperti nama tabel,
     * nama-nama kolom, nama database, dan versi dari database
     **/
    public static final String TABLE_NAME1 = "data_inventori1";
    public static final String COLUMN_ID1 = "_id1";
    public static final String COLUMN_JAM1 = "Jam_ke1";
    public static final String COLUMN_NAME1 = "nama_pelajaran1";
    private static final String db_name = "inventori1.db";
    private static final int db_version = 1;

    // Perintah SQL untuk membuat tabel database baru
    private static final String db_create = "create table "
            + TABLE_NAME1 + "("
            + COLUMN_ID1 + " integer primary key autoincrement, "
            + COLUMN_JAM1 + " varchar(50) not null, "
            + COLUMN_NAME1 + " varchar(50) not null);";

    public DBHelpe(Context context) {
        super(context, db_name, null, db_version);
        // Auto generated
    }

    //mengeksekusi perintah SQL di atas untuk membuat tabel database baru
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(db_create);
    }

    // dijalankan apabila ingin mengupgrade database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBHelpe.class.getName(), "Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);

    }
}
