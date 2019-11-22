package com.example.duan_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class manhinhchinh extends AppCompatActivity {
Button btnChoi,btnHd,btnT4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhchinh);
        btnChoi=findViewById(R.id.btnChoi);
        btnHd=findViewById(R.id.btnHd);
        btnT4=findViewById(R.id.btnT4);
        btnChoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),start.class);
                startActivity(intent);
            }
        });
        btnHd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),huongdan.class);
                startActivity(intent);
            }
        });
        btnT4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),Menu.class);
                startActivity(intent);
            }
        });
    }
}
