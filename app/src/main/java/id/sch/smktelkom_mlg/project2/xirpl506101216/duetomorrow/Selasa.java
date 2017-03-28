package id.sch.smktelkom_mlg.project2.xirpl506101216.duetomorrow;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Selasa extends Activity implements OnClickListener {
    //inisilisasi elemen-elemen pada layout
    private Button buttomSubmit1;
    private EditText edJam1;
    private EditText edNama1;
    //inisialisasi kontroller/Data Source
    private DBDataSour dataSource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selasa);

        buttomSubmit1 = (Button) findViewById(R.id.button_submit2);
        buttomSubmit1.setOnClickListener(this);
        edNama1 = (EditText) findViewById(R.id.jam2);
        edJam1 = (EditText) findViewById(R.id.nama2);

        // instanstiasi kelas DBDataSource
        dataSource = new DBDataSour(this);

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
        if (edNama1.getText() != null && edJam1.getText() != null) {
            /* jika field nama, merk, dan harga tidak kosong
             * maka masukkan ke dalam data barang*/
            jam = edJam1.getText().toString();
            nama = edNama1.getText().toString();
        }

        switch (v.getId()) {
            case R.id.button_submit2:
                // insert data barang baru
                barang = dataSource.createBarang(jam, nama);

                //konfirmasi kesuksesan
                Toast.makeText(this, "Data Berhasil Ditambahkan\n" +
                        "Jam Ke-" + barang.getJamke() +
                        "Nama Pelajaran" + barang.getNama_pelajaran(), Toast.LENGTH_LONG).show();
                break;
        }

    }
}
