package com.example.duan_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
Button btnDN,btnDK,btnFB,btnNC,btnT;
Intent intent;
private AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnDN=findViewById(R.id.btnDangnhap);
        btnDK=findViewById(R.id.btnDangKy);
        btnFB=findViewById(R.id.btnFB);
        btnNC=findViewById(R.id.btnNguoichoi);
        btnT=findViewById(R.id.btnThoat);

        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(getApplicationContext(),dangnhap.class);
                startActivity(intent);
            }
        });
        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),dangky.class);
                startActivity(intent);
            }
        });
        btnFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),Facebook.class);
                startActivity(intent);
            }
        });
        btnNC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),nguoichoi.class);
                startActivity(intent);
            }
        });
    }

    public void exit(View view) {
        Button btnOK,btnCancel;
        AlertDialog.Builder builder= new AlertDialog.Builder(Menu.this);
        View dialog= LayoutInflater.from(Menu.this).inflate(R.layout.my_dialog_exit,null);
        builder.setView(dialog);
        btnOK=dialog.findViewById(R.id.btnOk);
        btnCancel=dialog.findViewById(R.id.btnCancel);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent starMain=new Intent(Intent.ACTION_MAIN);
                starMain.addCategory(Intent.CATEGORY_HOME);
                startActivity(starMain);
                finish();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        builder.create();
        alertDialog=builder.show();
    }
}
