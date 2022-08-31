package com.example.helpservice;

public class BookingData {

    String BUname, BUemail, BUphoneNo, BUaddress,BUid;

    public BookingData() {
    }

    public BookingData(String BUname, String BUemail, String BUphoneNo, String BUaddress, String BUid) {
        this.BUname = BUname;
        this.BUemail = BUemail;
        this.BUphoneNo = BUphoneNo;
        this.BUaddress = BUaddress;
        this.BUid = BUid;
    }

    public String getBUname() {
        return BUname;
    }

    public void setBUname(String BUname) {
        this.BUname = BUname;
    }

    public String getBUemail() {
        return BUemail;
    }

    public void setBUemail(String BUemail) {
        this.BUemail = BUemail;
    }

    public String getBUphoneNo() {
        return BUphoneNo;
    }

    public void setBUphoneNo(String BUphoneNo) {
        this.BUphoneNo = BUphoneNo;
    }

    public String getBUaddress() {
        return BUaddress;
    }

    public void setBUaddress(String BUaddress) {
        this.BUaddress = BUaddress;
    }

    public String getBUid() {
        return BUid;
    }

    public void setBUid(String Buid) {
        this.BUid = BUid;
    }
}
