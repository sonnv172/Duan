package com.example.duan_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.duan_1.themnguoichoi.Adapter;
import com.example.duan_1.themnguoichoi.DAO;
import com.example.duan_1.themnguoichoi.Model;

import java.util.ArrayList;
import java.util.List;

public class nguoichoi extends AppCompatActivity {
    Button btnT3;
    ListView listView ;
    List<Model> list = new ArrayList<>();
    DAO dao;
    Adapter adapter;
    ArrayList<String> arrayCourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoichoi);
        listView=findViewById(R.id.lvNguoichoi);
        btnT3=findViewById(R.id.btnT3);
        
        registerForContextMenu(listView);
        dao = new DAO(nguoichoi.this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        list = dao.getAllT();
        adapter = new Adapter(list, this);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);


                btnT3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent= new Intent(getApplicationContext(),Menu.class);
                        startActivity(intent);
                    }
                });

    }
    @Override
    protected void onResume() {
        super.onResume();
        list.clear();
        list=dao.getAllT();
        adapter.chang(list);
    }

}
