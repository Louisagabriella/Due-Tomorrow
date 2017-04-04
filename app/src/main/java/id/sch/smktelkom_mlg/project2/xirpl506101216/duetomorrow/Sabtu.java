package id.sch.smktelkom_mlg.project2.xirpl506101216.duetomorrow;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sabtu extends Activity implements OnClickListener {
    //inisilisasi elemen-elemen pada layout
    private Button buttomSubmit6;
    private EditText edJam6;
    private EditText edNama6;
    //inisialisasi kontroller/Data Source
    private DBD dataSource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabtu);

        buttomSubmit6 = (Button) findViewById(R.id.button_submit6);
        buttomSubmit6.setOnClickListener(this);
        edNama6 = (EditText) findViewById(R.id.jam6);
        edJam6 = (EditText) findViewById(R.id.nama6);

        // instanstiasi kelas DBDataSource
        dataSource = new DBD(this);

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
        if (edNama6.getText() != null && edJam6.getText() != null) {
            /* jika field nama, merk, dan harga tidak kosong
             * maka masukkan ke dalam data barang*/
            jam = edJam6.getText().toString();
            nama = edNama6.getText().toString();
        }

        switch (v.getId()) {
            case R.id.button_submit6:
                // insert data barang baru
                barang = dataSource.createBarang(jam, nama);

                //konfirmasi kesuksesan
                Toast.makeText(this, " Data Berhasil Ditambahkan\n " +
                        " Jam Ke- " + barang.getId() +
                        " Nama Pelajaran " + barang.getNama_pelajaran(), Toast.LENGTH_LONG).show();
                break;
        }

    }
}
