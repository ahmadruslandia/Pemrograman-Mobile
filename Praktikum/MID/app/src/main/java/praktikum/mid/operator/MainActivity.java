package praktikum.mid.operator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private EditText Input1, Input2, Hasil;
    private RadioGroup Operator;
    private RadioButton tambah, kurang, kali, bagi;
    private Button btnClear;


    private RadioGroup.OnCheckedChangeListener operator = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            hitung();
        }
    };

    private TextWatcher eventChangeTxt = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            hitung();
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            hitung();
        }

        @Override
        public void afterTextChanged(Editable s) {
            hitung();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Input1 = findViewById(R.id.pt_input1);
        Input2 = findViewById(R.id.pt_input2);
        Hasil = findViewById(R.id.pt_hasil);
        Button btnClear = findViewById(R.id.button);

        tambah = findViewById(R.id.rb_pertambah);
        kurang = findViewById(R.id.rb_pengurangan);
        kali = findViewById(R.id.rb_perkalian);
        bagi = findViewById(R.id.rb_pembagian);


        Operator = findViewById(R.id.rg_operator);

        Input1.addTextChangedListener(eventChangeTxt);
        Input2.addTextChangedListener(eventChangeTxt);

        Operator.setOnCheckedChangeListener(operator);


        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Input1.setText("");
                Input2.setText("");
                Hasil.setText("");
                Operator.clearCheck();
            }
        });
    }


    protected void hitung() {
        float a,b, c=0;

        try {a = Float.parseFloat(Input1.getText().toString());} catch (Exception e){a=0;}
        try {b = Float.parseFloat(Input2.getText().toString());} catch (Exception e){b=0;}

        switch(Operator.getCheckedRadioButtonId()){
            case R.id.rb_pertambah:
                c=a +b;
                break;
            case R.id.rb_pengurangan:
                c=a -b;
                break;
            case R.id.rb_perkalian:
                c=a *b;
                break;
            case R.id.rb_pembagian:
                c=a /b;
                break;
        }

        Hasil.setText(String.valueOf(c));

    }

}
