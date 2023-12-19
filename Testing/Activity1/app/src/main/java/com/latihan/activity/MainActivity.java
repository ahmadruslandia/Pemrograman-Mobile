package com.latihan.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    EditText name,id;
    ImageView image;
    Button submit;
    ImageButton upload;
    Uri uri;
    int SELECT_IMAGE_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image =findViewById(R.id.img_image);

        name = findViewById(R.id.inputName);
        id = findViewById(R.id.inputID);
        upload = findViewById(R.id.imageButton);

        submit = findViewById(R.id.btn_submit);

        submit. setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = name.getText().toString();
                String user_id = id.getText().toString();

                Intent intent = new Intent (MainActivity. this, Activity2.class);
                intent.putExtra( "img", uri) ;
                intent.putExtra( "keyname", user_name) ;
                intent.putExtra( "keyid", user_id) ;
                startActivity(intent);
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Title"), SELECT_IMAGE_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            uri = data.getData();
            image.setImageURI(uri);
        }
    }
}
