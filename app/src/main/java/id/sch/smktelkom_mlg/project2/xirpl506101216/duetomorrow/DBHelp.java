package id.sch.smktelkom_mlg.project2.xirpl506101216.duetomorrow;

/**
 * Created by Louisa on 3/28/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelp extends SQLiteOpenHelper {
    /**
     * deklarasi konstanta-konstanta yang digunakan pada database, seperti nama tabel,
     * nama-nama kolom, nama database, dan versi dari database
     **/
    public static final String TABLE_NAME2 = "data_inventori2";
    public static final String COLUMN_ID2 = "_id2";
    public static final String COLUMN_JAM2 = "Jam_ke2";
    public static final String COLUMN_NAME2 = "nama_pelajaran2";
    private static final String db_name = "inventori2.db";
    private static final int db_version = 1;

    // Perintah SQL untuk membuat tabel database baru
    private static final String db_create = "create table "
            + TABLE_NAME2 + "("
            + COLUMN_ID2 + " integer primary key autoincrement, "
            + COLUMN_JAM2 + " varchar(50) not null, "
            + COLUMN_NAME2 + " varchar(50) not null);";

    public DBHelp(Context context) {
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
        Log.w(DBHelp.class.getName(), "Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db);

    }
}
