package com.example.duan_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class start extends AppCompatActivity implements View.OnClickListener {
    private TextView tvQuestion;
    private Button btnCaseA;
    private Button btnCaseB;
    private Button btnCaseC;
    private Button btnCaseD;
    private My_DataBase myDataBase;
    private TextView tvTimedown;
    private TextView tvSoCau;
    private int trueCase;
    private int i;
    private int dem;
    private int wait;
    private boolean check;
    private boolean run;
    private ArrayList<Model_question> questions=new ArrayList<>();
    private boolean checkPickAnswer;
    int dem1=1,doi=1;
    MediaPlayer mediaPlayer;
    private AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        mediaPlayer=MediaPlayer.create(this,R.raw.funny);
        mediaPlayer.start();
        myDataBase=new My_DataBase(this);
        questions=myDataBase.getData();;
        initView();
        asyncTask.execute();
    }

    private void initView() {
        i=0;
        dem=60;
        wait=30;
        tvQuestion= (TextView) findViewById(R.id.txt_questions);
        tvTimedown= (TextView) findViewById(R.id.tv_timeDown);
        tvSoCau= (TextView) findViewById(R.id.tvSoCau);
        btnCaseA= (Button) findViewById(R.id.answer_A);
        btnCaseB= (Button) findViewById(R.id.answer_B);
        btnCaseC= (Button) findViewById(R.id.answer_C);
        btnCaseD= (Button) findViewById(R.id.answer_D);
        setText(i);
        btnCaseA.setOnClickListener(this);
        btnCaseB.setOnClickListener(this);
        btnCaseC.setOnClickListener(this);
        btnCaseD.setOnClickListener(this);
    }
    public void setText(int i){
        run=true;
        int tm=i+1;
        tvSoCau.setText("Câu số: "+tm);
        checkPickAnswer=true;
        tvQuestion.setText(questions.get(i).getQuestion());
        btnCaseA.setText("A. "+questions.get(i).getCaseA());
        btnCaseB.setText("B. "+questions.get(i).getCaseB());
        btnCaseC.setText("C. "+questions.get(i).getCaseC());
        btnCaseD.setText("D. "+questions.get(i).getCaseD());
        btnCaseA.setEnabled(true);
        btnCaseB.setEnabled(true);
        btnCaseC.setEnabled(true);
        btnCaseD.setEnabled(true);
        dem=60;
        switch (questions.get(i).getTrueCase()){
            case 1:
                trueCase=R.id.answer_A;
                break;
            case 2:
                trueCase=R.id.answer_B;
                break;
            case 3:
                trueCase=R.id.answer_C;
                break;
            case 4:
                trueCase=R.id.answer_D;
                break;
        }
    }
    private AsyncTask<Void,Integer,Void> asyncTask=new AsyncTask<Void, Integer, Void>(){

        @Override
        protected Void doInBackground(Void... voids) {
            for (dem=60;dem>=0;dem--){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(dem);
            }
            return null;

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            if (run) {
                tvTimedown.setText(values[0] + "");
            }
            else{
                dem++;
            }
            wait++;
            if (wait==1 && check) {
                setText(++i);
            }
            if ((wait==1 && !check) || dem==0 ){
                Button againn,exittt;
                AlertDialog.Builder builder= new AlertDialog.Builder(start.this);
                View dialog= LayoutInflater.from(start.this).inflate(R.layout.my_dialog_over,null);
                builder.setView(dialog);
                againn=dialog.findViewById(R.id.againn);
                exittt=dialog.findViewById(R.id.exittt);
                againn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDataBase=new My_DataBase(start.this);
                        questions=myDataBase.getData();;
                        initView();
                        alertDialog.dismiss();
                        doi=1;
                    }
                });
                exittt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mediaPlayer.stop();
                        Button btnOK,btnCancel;
                        AlertDialog.Builder builder= new AlertDialog.Builder(start.this);
                        View dialog= LayoutInflater.from(start.this).inflate(R.layout.my_dialog_exit,null);
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
                });
                builder.create();
                alertDialog=builder.show();
            }
            if(i==31){
                Button again,exitt;
                AlertDialog.Builder builder= new AlertDialog.Builder(start.this);
                View dialog= LayoutInflater.from(start.this).inflate(R.layout.my_dialog_win,null);
                builder.setView(dialog);
                again=dialog.findViewById(R.id.again);
                exitt=dialog.findViewById(R.id.exitt);
                again.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        myDataBase=new My_DataBase(start.this);
                        questions=myDataBase.getData();;
                        initView();
                        alertDialog.dismiss();
                        doi=1;
                    }
                });
                exitt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mediaPlayer.stop();
                        Button btnOK,btnCancel;
                        AlertDialog.Builder builder= new AlertDialog.Builder(start.this);
                        View dialog= LayoutInflater.from(start.this).inflate(R.layout.my_dialog_exit,null);
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
                });
                builder.create();
                alertDialog=builder.show();
            }
        }
    };

    @Override
    public void onClick(View v) {
        run=false;
        if (!checkPickAnswer){
            return;
        }
        if (v.getId()==R.id.answer_A ||
                v.getId()==R.id.answer_B||
                v.getId()==R.id.answer_C||
                v.getId()==R.id.answer_D){
            if (v.getId()==trueCase){
                check=true;
                wait=0;
            }else {
                check=false;
                wait=0;
            }
            checkPickAnswer=false;
        }
    }

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
                mediaPlayer.stop();
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



    public void Doi(View view) {
        if(doi>0){
            Button btnOK,btnCancel;
            AlertDialog.Builder builder= new AlertDialog.Builder(start.this);
            View dialog= LayoutInflater.from(start.this).inflate(R.layout.my_dialog_doi,null);
            builder.setView(dialog);
            btnOK=dialog.findViewById(R.id.btnOk);
            btnCancel=dialog.findViewById(R.id.btnCancel);
            btnOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    myDataBase=new My_DataBase(start.this);
                    questions=myDataBase.getData();
                    initView();
                    dem=60;
                    doi=doi-1;
                    alertDialog.dismiss();
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
        }else {
            Button btnOK;
            AlertDialog.Builder builder= new AlertDialog.Builder(start.this);
            View dialog= LayoutInflater.from(start.this).inflate(R.layout.my_dialog_thongbao,null);
            builder.setView(dialog);
            btnOK=dialog.findViewById(R.id.again);
            btnOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialog.dismiss();
                }
            });

            builder.create();
            alertDialog=builder.show();
        }

    }
}
