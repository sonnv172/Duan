package com.example.duan_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dangky extends AppCompatActivity {
Button btnDN2,btnT2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        btnDN2=findViewById(R.id.btnDN2);
        btnT2=findViewById(R.id.btnT2);

        btnDN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),manhinhchinh.class);
                startActivity(intent);
            }
        });
        btnT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),Menu.class);
                startActivity(intent);
            }
        });
    }
}
