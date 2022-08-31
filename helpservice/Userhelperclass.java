package com.example.helpservice;

public class Userhelperclass {


   private String Uid,Uname, Uemail, UphoneNo, Upassword;

    public Userhelperclass() {

    }

    public Userhelperclass(String uid, String uname, String uemail, String uphoneNo, String upassword) {
        this.Uid = uid;
        this.Uname = uname;
        this.Uemail = uemail;
        this.UphoneNo = uphoneNo;
        this.Upassword = upassword;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        this.Uid = uid;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        this.Uname = uname;
    }

    public String getUemail() {
        return Uemail;
    }

    public void setUemail(String uemail) {
        this.Uemail = uemail;
    }

    public String getUphoneNo() {
        return UphoneNo;
    }

    public void setUphoneNo(String uphoneNo) {
        this.UphoneNo = uphoneNo;
    }

    public String getUpassword() {
        return Upassword;
    }

    public void setUpassword(String upassword) {
        this.Upassword = upassword;
    }
}
