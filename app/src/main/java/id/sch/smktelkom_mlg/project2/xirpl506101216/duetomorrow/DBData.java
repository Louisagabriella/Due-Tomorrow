package id.sch.smktelkom_mlg.project2.xirpl506101216.duetomorrow;

/**
 * Created by Louisa on 3/28/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class DBData {
    //inisialiasi SQLite Database
    private SQLiteDatabase database;

    //inisialisasi kelas DBHelper
    private DBHe dbHelper;

    //ambil semua nama kolom
    private String[] allColumns = {DBHe.COLUMN_ID3, DBHe.COLUMN_JAM3,
            DBHe.COLUMN_NAME3};

    //DBHelper diinstantiasi pada constructor
    public DBData(Context context) {
        dbHelper = new DBHe(context);
    }

    //membuka/membuat sambungan baru ke database
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    //menutup sambungan ke database
    public void close() {
        dbHelper.close();
    }

    //method untuk create/insert barang ke database
    public Barang createBarang(String jam, String nama) {

        // membuat sebuah ContentValues, yang berfungsi
        // untuk memasangkan data dengan nama-nama
        // kolom pada database
        ContentValues values = new ContentValues();
        values.put(DBHe.COLUMN_JAM3, jam);
        values.put(DBHe.COLUMN_NAME3, nama);

        // mengeksekusi perintah SQL insert data
        // yang akan mengembalikan sebuah insert ID
        long insertId = database.insert(DBHe.TABLE_NAME3, null,
                values);

        // setelah data dimasukkan, memanggil
        // perintah SQL Select menggunakan Cursor untuk
        // melihat apakah data tadi benar2 sudah masuk
        // dengan menyesuaikan ID = insertID
        Cursor cursor = database.query(DBHe.TABLE_NAME3,
                allColumns, DBHe.COLUMN_ID3 + " = " + insertId, null,
                null, null, null);

        // pindah ke data paling pertama
        cursor.moveToFirst();

        // mengubah objek pada kursor pertama tadi
        // ke dalam objek barang
        Barang newBarang = cursorToBarang(cursor);

        // close cursor
        cursor.close();

        // mengembalikan barang baru
        return newBarang;
    }

    private Barang cursorToBarang(Cursor cursor) {
        // buat objek barang baru
        Barang barang = new Barang();
        // debug LOGCAT
        Log.v("info", "The getLONG " + cursor.getLong(0));
        Log.v("info", "The setLatLng " + cursor.getString(1) + "," + cursor.getString(2));

        /* Set atribut pada objek barang dengan
         * data kursor yang diambil dari database*/
        barang.setId(cursor.getLong(0));
        barang.setJamke(cursor.getString(1));
        barang.setNama_pelajaran(cursor.getString(2));

        //kembalikan sebagai objek barang
        return barang;
    }

    //mengambil semua data barang
    public ArrayList<Barang> getAllBarang() {
        ArrayList<Barang> daftarBarang = new ArrayList<Barang>();

        // select all SQL query
        Cursor cursor = database.query(DBHe.TABLE_NAME3,
                allColumns, null, null, null, null, null);

        // pindah ke data paling pertama
        cursor.moveToFirst();
        // jika masih ada data, masukkan data barang ke
        // daftar barang
        while (!cursor.isAfterLast()) {
            Barang barang = cursorToBarang(cursor);
            daftarBarang.add(barang);
            cursor.moveToNext();
        }
        // Make sure to close the cursor
        cursor.close();
        return daftarBarang;
    }
}
