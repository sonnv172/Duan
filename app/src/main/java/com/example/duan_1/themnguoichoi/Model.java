package com.example.duan_1.themnguoichoi;

import androidx.annotation.NonNull;

public class Model {

    private String T1;
    private String T2;
    private String T3;

    public Model(String t1, String t2, String t3) {
        T1 = t1;
        T2 = t2;
        T3 = t3;
    }

    public Model() {
    }

    public String getT1() {
        return T1;
    }

    public void setT1(String t1) {
        T1 = t1;
    }

    public String getT2() {
        return T2;
    }

    public void setT2(String t2) {
        T2 = t2;
    }

    public String getT3() {
        return T3;
    }

    public void setT3(String t3) {
        T3 = t3;
    }

    @NonNull
    @Override
    public String toString() {
        return T1+T2+T3;
    }
}
