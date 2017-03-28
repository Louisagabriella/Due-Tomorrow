package id.sch.smktelkom_mlg.project2.xirpl506101216.duetomorrow;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Jumat extends Activity implements OnClickListener {
    //inisilisasi elemen-elemen pada layout
    private Button buttomSubmit5;
    private EditText edJam5;
    private EditText edNama5;
    //inisialisasi kontroller/Data Source
    private DBDa dataSource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jumat);

        buttomSubmit5 = (Button) findViewById(R.id.button_submit5);
        buttomSubmit5.setOnClickListener(this);
        edNama5 = (EditText) findViewById(R.id.jam5);
        edJam5 = (EditText) findViewById(R.id.nama5);

        // instanstiasi kelas DBDataSource
        dataSource = new DBDa(this);

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
        if (edNama5.getText() != null && edJam5.getText() != null) {
            /* jika field nama, merk, dan harga tidak kosong
             * maka masukkan ke dalam data barang*/
            jam = edJam5.getText().toString();
            nama = edNama5.getText().toString();
        }

        switch (v.getId()) {
            case R.id.button_submit5:
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
