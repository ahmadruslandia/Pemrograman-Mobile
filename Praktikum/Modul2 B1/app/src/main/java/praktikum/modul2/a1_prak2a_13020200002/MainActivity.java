package praktikum.modul2.a1_prak2a_13020200002;

import static praktikum.modul2.a1_prak2a_13020200002.R.id.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private EditText ptStambuk, ptNama;
    private Spinner sAngkatan;
    public RadioGroup rgProdi;

    private CheckBox cb1, cb2, cb3, cb4, cb5, cb6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ptStambuk = findViewById(pt_stambuk);
        ptNama = findViewById(pt_nama);
        sAngkatan = findViewById(s_angkatan);
        rgProdi = findViewById(rg_prodi);
        cb1 = findViewById(cb_1);
        cb2 = findViewById(cb_2);
        cb3 = findViewById(cb_3);
        cb4 = findViewById(cb_4);
        cb5 = findViewById(cb_5);
        cb6 = findViewById(cb_6);
        String SpinnerKontent [] = {"- Pilih Angkatan","2020","2021","2022","2023"};
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1,SpinnerKontent);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sAngkatan.setAdapter(adapter);
    }

    @SuppressLint("NonConstantResourceId")
    public void bukaRingkasan (View view) {

        String stambuk, nama, angkatan, prodi, minat;

        stambuk = ptStambuk.getText().toString();
        nama = ptNama.getText().toString();
        angkatan = sAngkatan.getSelectedItem().toString();
        prodi = " ";
        switch (rgProdi.getCheckedRadioButtonId()){
            case R.id.rb_ti :
                prodi = "Teknik Informatika";
                break;
            case R.id.rb_si :
                prodi = "Sistem Informasi";
                break;
        }
        minat = " ";
        if (cb1.isChecked())
            minat += "- BEM\n";
        if (cb2.isChecked())
            minat += "- Penulisan Karya Ilmiah\n";
        if (cb3.isChecked())
            minat += "- Kewirausahaan\n";
        if (cb4.isChecked())
            minat += "- Kesenian\n";
        if (cb5.isChecked())
            minat += "- Jurnalistik\n";
        if (cb6.isChecked())
            minat += "- Olahraga\n";

        Intent intent = new Intent(this, Activity2. class);
        intent.putExtra("stambuk", stambuk);
        intent.putExtra("nama", nama);
        intent.putExtra("angkatan", angkatan);
        intent.putExtra("prodi", prodi);
        intent.putExtra("minat", minat);


        startActivity(intent);

    }

}
