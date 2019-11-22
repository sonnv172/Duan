package com.example.duan_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class start extends AppCompatActivity {
Button btnDoi,btnT6,btnA,btnB,btnC,btnD;
TextView tvCauhoi,cau;
int dem=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        cau=findViewById(R.id.cau);
        btnT6=findViewById(R.id.btnT6);
        btnDoi=findViewById(R.id.btnDoi);
        tvCauhoi=findViewById(R.id.tvCauhoi);
        btnA=findViewById(R.id.btnA);
        btnB=findViewById(R.id.btnB);
        btnC=findViewById(R.id.btnC);
        btnD=findViewById(R.id.btnD);

        tvCauhoi.setText("Có Một Con Gà ở trên 1 cái cột gáy ò ó o. Hỏi khi đẻ trứng, quả trúng rơi ở bên nào?");
        btnA.setText("Không rơi");
        btnB.setText("Bên trái");
        btnC.setText("Bên Phải");
        btnD.setText("Xuống dưới");
        cau.setText("Câu số: "+dem);


    }
private AlertDialog alertDialog;
    public void exit(View view) {
        Button btnOK,btnCancel;
        AlertDialog.Builder builder= new AlertDialog.Builder(start.this);
        View dialog= LayoutInflater.from(start.this).inflate(R.layout.my_dialog_exit,null);
        builder.setView(dialog);
        btnOK=dialog.findViewById(R.id.btnOk);
        btnCancel=dialog.findViewById(R.id.btnCancel);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),manhinhchinh.class);
                startActivity(intent);
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

    public void A(View view) {
        tvCauhoi.setText("Có ông già lên núi gặp con rùa và con ngựa, hỏi tại sao ổng quay về");
        btnA.setText("Ma quỹ");
        btnB.setText("Đá rơi");
        btnC.setText("Xa quá");
        btnD.setText("Thấy biển báo");
        dem=dem+1;
        cau.setText("Câu số: "+dem);
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button again,exitt;
                AlertDialog.Builder builder= new AlertDialog.Builder(start.this);
                View dialog= LayoutInflater.from(start.this).inflate(R.layout.my_dialog_win,null);
                builder.setView(dialog);
                again=dialog.findViewById(R.id.again);
                exitt=dialog.findViewById(R.id.exitt);
                again.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(getApplicationContext(),manhinhchinh.class);
                        startActivity(intent);
                    }
                });
                exitt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(getApplicationContext(),Menu.class);
                        startActivity(intent);
                    }
                });
                builder.create();
                builder.show();
            }
        });
    }

    public void B(View view) {
        Button againn,exittt;
        AlertDialog.Builder builder= new AlertDialog.Builder(start.this);
        View dialog= LayoutInflater.from(start.this).inflate(R.layout.my_dialog_over,null);
        builder.setView(dialog);
        dem=1;
        againn=dialog.findViewById(R.id.againn);
        exittt=dialog.findViewById(R.id.exittt);
        againn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),manhinhchinh.class);
                startActivity(intent);
            }
        });
        exittt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Menu.class);
                startActivity(intent);
            }
        });
        builder.create();
        builder.show();
    }

    public void Doi(View view) {
        tvCauhoi.setText("Trong một hồ cá có 10 con cá, 3 con bị chìm, 4 con bơi đi, 4 con chết. Hỏi trong hồ còn lại bao nhiêu con cá?");
        btnA.setText("10");
        btnB.setText("7");
        btnC.setText("3");
        btnD.setText("4");
    }
}
