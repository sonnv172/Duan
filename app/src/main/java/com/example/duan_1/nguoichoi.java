package com.example.duan_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class nguoichoi extends AppCompatActivity {
Button btnT3;
ListView lvNguoichoi;
ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoichoi);

        lvNguoichoi=findViewById(R.id.lvNguoichoi);
        arrayList=new ArrayList<>();
        arrayList.add("Nguyễn Văn Sơn");
        arrayList.add("Nguyễn Thị Hải");
        arrayList.add("Nguyễn Thị Xuân");
        arrayList.add("Nguyễn Thị Thùy Linh");
        arrayList.add("Nguyễn Chí Hải");
        arrayList.add("Nguyễn Khắc Tiến");
        arrayList.add("Nguyễn Văn Sơn");
        arrayList.add("Nguyễn Thị Hải");
        arrayList.add("Nguyễn Thị Xuân");
        arrayList.add("Nguyễn Thị Thùy Linh");
        arrayList.add("Nguyễn Chí Hải");
        arrayList.add("Nguyễn Khắc Tiến");

        ArrayAdapter adapter=new ArrayAdapter(
                nguoichoi.this,
                android.R.layout.simple_list_item_1,
                arrayList
        );
        lvNguoichoi.setAdapter(adapter);

        btnT3=findViewById(R.id.btnT3);
                btnT3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent= new Intent(getApplicationContext(),Menu.class);
                        startActivity(intent);
                    }
                });
    }
}
