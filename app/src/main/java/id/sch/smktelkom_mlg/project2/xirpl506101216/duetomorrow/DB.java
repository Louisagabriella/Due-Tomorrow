package id.sch.smktelkom_mlg.project2.xirpl506101216.duetomorrow;

/**
 * Created by Louisa on 3/28/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DB extends SQLiteOpenHelper {
    /**
     * deklarasi konstanta-konstanta yang digunakan pada database, seperti nama tabel,
     * nama-nama kolom, nama database, dan versi dari database
     **/
    public static final String TABLE_NAME4 = "data_inventori4";
    public static final String COLUMN_ID4 = "_id4";
    public static final String COLUMN_JAM4 = "Jam_ke4";
    public static final String COLUMN_NAME4 = "nama_pelajaran4";
    private static final String db_name = "inventori4.db";
    private static final int db_version = 1;

    // Perintah SQL untuk membuat tabel database baru
    private static final String db_create = "create table "
            + TABLE_NAME4 + "("
            + COLUMN_ID4 + " integer primary key autoincrement, "
            + COLUMN_JAM4 + " varchar(50) not null, "
            + COLUMN_NAME4 + " varchar(50) not null);";

    public DB(Context context) {
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
        Log.w(DB.class.getName(), "Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME4);
        onCreate(db);

    }
}
