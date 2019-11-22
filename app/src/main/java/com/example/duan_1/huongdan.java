package com.example.duan_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class huongdan extends AppCompatActivity {
Button btnT5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huongdan);
        btnT5=findViewById(R.id.btnT5);
        btnT5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
private AlertDialog alertDialog;
    public void huongdan(View view) {
        Button btnHieu;
        AlertDialog.Builder builder= new AlertDialog.Builder(huongdan.this);
        View dialog= LayoutInflater.from(huongdan.this).inflate(R.layout.my_dialog_hd,null);
        builder.setView(dialog);
        btnHieu=dialog.findViewById(R.id.btnHieu);
        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),manhinhchinh.class);
                startActivity(intent);
            }
        });
        builder.create();
        alertDialog=builder.show();
    }
}
