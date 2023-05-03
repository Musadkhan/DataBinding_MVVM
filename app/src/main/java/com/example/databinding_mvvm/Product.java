package com.example.databinding_mvvm;

public class Product {

    String pname,pid;
    int pcode;

    public Product(String pname, int pcode,String pid) {
        this.pname = pname;
        this.pcode = pcode;
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPcode() {
        return pcode;
    }

    public void setPcode(int pcode) {
        this.pcode = pcode;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
