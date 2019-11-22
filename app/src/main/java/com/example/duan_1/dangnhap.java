package com.example.duan_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dangnhap extends AppCompatActivity {
Button btnDN1,btnT1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        btnDN1=findViewById(R.id.btnDN1);
        btnT1=findViewById(R.id.btnT1);

        btnDN1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),manhinhchinh.class);
                startActivity(intent);
            }
        });
        btnT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),Menu.class);
                startActivity(intent);
            }
        });
    }
}
