package praktikum.modul2.a1_prak2a_13020200002;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    private TextView  txtStambuk, txtNama, txtAngkatan, txtProdi, txtMinat;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        txtStambuk = findViewById(R.id.tv_stambuk);
        txtNama = findViewById(R.id.tv_nama);
        txtAngkatan = findViewById(R.id.tv_angkatan);
        txtProdi = findViewById(R.id.tv_prodi);
        txtMinat = findViewById(R.id.tv_minat);

        String stambuk = getIntent().getStringExtra("stambuk");
        String nama = getIntent().getStringExtra("nama");
        String angkatan = getIntent().getStringExtra("angkatan");
        String prodi = getIntent().getStringExtra("prodi");
        String minat = getIntent().getStringExtra("minat");

        txtStambuk.setText(stambuk);
        txtNama.setText(nama);
        txtAngkatan.setText(angkatan);
        txtProdi.setText(prodi);
        txtMinat.setText(minat);


    }
}