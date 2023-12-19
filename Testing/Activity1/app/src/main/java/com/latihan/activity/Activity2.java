package com.latihan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    ImageView image;
    TextView name, id;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        intent = getIntent();
        image =findViewById(R.id.img_received);
        name = findViewById(R.id. txt_name);
        id = findViewById(R.id. txt_id);

        String user_name = getIntent().getStringExtra("keyname") ;
        String user_id = getIntent().getStringExtra("keyid") ;
        Uri uri =(Uri) intent.getParcelableExtra("img");
        image.setImageURI(uri);

        name.setText (user_name) ;
        id.setText (user_id) ;

    }


}