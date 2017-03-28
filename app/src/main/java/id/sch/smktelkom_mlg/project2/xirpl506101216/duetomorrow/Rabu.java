package id.sch.smktelkom_mlg.project2.xirpl506101216.duetomorrow;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Rabu extends Activity implements OnClickListener {
    //inisilisasi elemen-elemen pada layout
    private Button buttomSubmit3;
    private EditText edJam3;
    private EditText edNama3;
    //inisialisasi kontroller/Data Source
    private DBDataSo dataSource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rabu);

        buttomSubmit3 = (Button) findViewById(R.id.button_submit3);
        buttomSubmit3.setOnClickListener(this);
        edNama3 = (EditText) findViewById(R.id.jam3);
        edJam3 = (EditText) findViewById(R.id.nama3);

        // instanstiasi kelas DBDataSource
        dataSource = new DBDataSo(this);

        //membuat sambungan baru ke database
        dataSource.open();
    }

    //KETIKA Tombol Submit Diklik
    @Override
    public void onClick(View v) {
        // Inisialisasi data barang
        String jam = null;
        String nama = null;
        @SuppressWarnings("unused")

        //inisialisasi barang baru (masih kosong)
                Barang barang = null;
        if (edNama3.getText() != null && edJam3.getText() != null) {
            /* jika field nama, merk, dan harga tidak kosong
             * maka masukkan ke dalam data barang*/
            jam = edJam3.getText().toString();
            nama = edNama3.getText().toString();
        }

        switch (v.getId()) {
            case R.id.button_submit3:
                // insert data barang baru
                barang = dataSource.createBarang(jam, nama);

                //konfirmasi kesuksesan
                Toast.makeText(this, "Data Berhasil Ditambahkan\n" +
                        "Jam Ke-" + barang.getId() +
                        "Nama Pelajaran" + barang.getNama_pelajaran(), Toast.LENGTH_LONG).show();
                break;
        }

    }
}
