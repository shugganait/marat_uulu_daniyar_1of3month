package com.kg.marat_uulu_daniyar_1of3month;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText subject, text, to;
    private Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initObjects();
        btn_send.setOnClickListener(view -> {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL  ,  new String[]{to.getText().toString()});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
            emailIntent.putExtra(Intent.EXTRA_TEXT   , text.getText().toString());

            startActivity(emailIntent);
        });
    }

    private void initObjects(){
        to = findViewById(R.id.et_email);
        subject = findViewById(R.id.et_theme);
        text = findViewById(R.id.et_text);
        btn_send = findViewById(R.id.btn_send);
    }
}