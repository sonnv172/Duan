package com.example.duan_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.duan_1.themnguoichoi.Adapter;
import com.example.duan_1.themnguoichoi.DAO;
import com.example.duan_1.themnguoichoi.Model;

import java.util.ArrayList;
import java.util.List;

public class dangky extends AppCompatActivity {
    Button btnDN2,btnT2;
    EditText t1, t2, t3, t4;
    DAO dao;
    List<Model> list = new ArrayList<>();
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        btnDN2=findViewById(R.id.btnDN2);
        btnT2=findViewById(R.id.btnT2);
        t1 = findViewById(R.id.ed_t1);
        t2 = findViewById(R.id.ed_t2);
        t3 = findViewById(R.id.ed_t3);
        t4 = findViewById(R.id.ed_t4);
        btnT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),Menu.class);
                startActivity(intent);
            }
        });
    }
    public void Them(View view) {
        dao = new DAO(dangky.this);
        Model s = new Model(t1.getText().toString(), t2.getText().toString(), t3.getText().toString());
        try{
            if(validateForm()>0){
                if(dao.Them(s)>0){
                    Toast.makeText(getApplicationContext(),"Đăng ký thành công",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getApplicationContext(),manhinhchinh.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Đăng ký không thành công",Toast.LENGTH_LONG).show();
                }
            }
        }catch (Exception e){
            Log.e("Error",e.toString());
        }
    }
    public int validateForm(){
        int check = 1;
        if (t1.getText().length() == 0 || t2.getText().length() == 0
                || t3.getText().length() == 0 || t4.getText().length()==0) {
            Toast.makeText(getApplicationContext(), "Bạn phải nhập đầy đủ thông ",
                    Toast.LENGTH_SHORT).show();
            check = -1;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(t2.getText()).matches()){
            Toast.makeText(getApplicationContext(), "Bạn phải nhập đúng định dạng email",
                    Toast.LENGTH_SHORT).show();
            check = -1;
        }else {
            String pass = t3.getText().toString();
            String rePass = t4.getText().toString();
            if(pass.length()<6){
                Toast.makeText(getApplicationContext(), "Mật khẩu phải từ 6 ký tự trở lên",
                        Toast.LENGTH_SHORT).show();
                check = -1;
            }else if (!pass.equals(rePass)) {
                Toast.makeText(getApplicationContext(), "Mật khẩu không trùng khớp",
                        Toast.LENGTH_SHORT).show();
                check = -1;
            }
        }
        return check;
    }


}
