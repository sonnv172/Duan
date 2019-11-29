package com.example.duan_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duan_1.themnguoichoi.DAO;

public class dangnhap extends AppCompatActivity {
    Button btnDN1,btnT1;
    EditText edUserName, edPassword;
    String strUser, strPass;
    CheckBox chkRememberPass;
    DAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        btnDN1=findViewById(R.id.btnDN1);
        btnT1=findViewById(R.id.btnT1);
        edUserName = (EditText) findViewById(R.id.edUserName);
        edPassword = (EditText) findViewById(R.id.edPassword);

        chkRememberPass = (CheckBox) findViewById(R.id.chkRememberPass);
        dao = new DAO(dangnhap.this);

        btnT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),Menu.class);
                startActivity(intent);
            }
        });
    }
    public void Login(View view) {
        strUser = edUserName.getText().toString();
        strPass = edPassword.getText().toString();
        if (strUser.isEmpty()||strPass.isEmpty()){
            Toast.makeText(getApplicationContext(),"Tên đăng nhập và mật khẩu không được bỏ trống",
                    Toast.LENGTH_SHORT).show();
        }else {
            if (dao.checkLogin(strUser,strPass)>0){
                Toast.makeText(getApplicationContext(),"Login thành công",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(dangnhap.this,manhinhchinh.class);
                startActivity(intent);
            }

            else if (strUser.equalsIgnoreCase("sonson@gmail.com")&&strPass.equalsIgnoreCase("123456")){
                rememberUser(strUser,strPass,chkRememberPass.isChecked());
                Intent intent=new Intent(dangnhap.this,manhinhchinh.class);
                startActivity(intent);
            }else {
                Toast.makeText(getApplicationContext(),"Tên đăng nhập và mật khẩu không đúng",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void rememberUser(String u, String p, boolean status){
        SharedPreferences pref = getSharedPreferences("USER_FILE",MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        if (!status){
            //xoa tinh trang luu tru truoc do
            edit.clear();
        }else {
            //luu du lieu
            edit.putString("USERNAME",u);
            edit.putString("PASSWORD",p);
            edit.putBoolean("REMEMBER",status);
        }
        //luu lai toan bo
        edit.commit();
    }
}
