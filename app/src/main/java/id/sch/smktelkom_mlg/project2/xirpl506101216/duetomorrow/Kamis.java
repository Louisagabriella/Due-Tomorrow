package id.sch.smktelkom_mlg.project2.xirpl506101216.duetomorrow;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Kamis extends Activity implements OnClickListener {
    //inisilisasi elemen-elemen pada layout
    private Button buttomSubmit4;
    private EditText edJam4;
    private EditText edNama4;
    //inisialisasi kontroller/Data Source
    private DBData dataSource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamis);

        buttomSubmit4 = (Button) findViewById(R.id.button_submit4);
        buttomSubmit4.setOnClickListener(this);
        edNama4 = (EditText) findViewById(R.id.jam4);
        edJam4 = (EditText) findViewById(R.id.nama4);

        // instanstiasi kelas DBDataSource
        dataSource = new DBData(this);

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
        if (edNama4.getText() != null && edJam4.getText() != null) {
            /* jika field nama, merk, dan harga tidak kosong
             * maka masukkan ke dalam data barang*/
            jam = edJam4.getText().toString();
            nama = edNama4.getText().toString();
        }

        switch (v.getId()) {
            case R.id.button_submit4:
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
