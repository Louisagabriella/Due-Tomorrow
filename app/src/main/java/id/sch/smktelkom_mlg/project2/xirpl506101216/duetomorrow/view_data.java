package id.sch.smktelkom_mlg.project2.xirpl506101216.duetomorrow;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class view_data extends ListActivity {
    //inisialisasi kontroller
    private DBDataSource dataSource;

    //inisialisasi arraylist
    private ArrayList<Barang> values;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        dataSource = new DBDataSource(this);
        // buka kontroller
        dataSource.open();

        // ambil semua data barang
        values = dataSource.getAllBarang();

        // masukkan data barang ke array adapter
        ArrayAdapter<Barang> adapter = new ArrayAdapter<Barang>(this,
                android.R.layout.simple_list_item_1, values);

        // set adapter pada list
        setListAdapter(adapter);
    }
}
