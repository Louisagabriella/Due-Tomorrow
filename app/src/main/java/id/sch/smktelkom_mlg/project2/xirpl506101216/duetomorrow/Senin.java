package id.sch.smktelkom_mlg.project2.xirpl506101216.duetomorrow;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Senin extends Activity implements OnClickListener {
    //inisilisasi elemen-elemen pada layout
    private Button buttonSubmit;
    private EditText edJam;
    private EditText edNama;
    //inisialisasi kontroller/Data Source
    private DBDataSource dataSource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senin);

        buttonSubmit = (Button) findViewById(R.id.buttom_submit);
        buttonSubmit.setOnClickListener(this);
        edNama = (EditText) findViewById(R.id.jam);
        edJam = (EditText) findViewById(R.id.nama);

        // instanstiasi kelas DBDataSource
        dataSource = new DBDataSource(this);

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
        if (edNama.getText() != null && edJam.getText() != null) {
            /* jika field nama, merk, dan harga tidak kosong
             * maka masukkan ke dalam data barang*/
            jam = edJam.getText().toString();
            nama = edNama.getText().toString();
        }

        switch (v.getId()) {
            case R.id.buttom_submit:
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
