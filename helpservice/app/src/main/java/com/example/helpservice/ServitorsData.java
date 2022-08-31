package com.example.helpservice;

public class ServitorsData {

    private String servitorName, servitorPhoneno, servitorAddress, servitorAge, image,key;

    public ServitorsData() {

    }

    public ServitorsData(String servitorName, String servitorPhoneno, String servitorAddress, String servitorAge, String image,String key) {
        this.servitorName = servitorName;
        this.servitorPhoneno = servitorPhoneno;
        this.servitorAddress = servitorAddress;
        this.servitorAge = servitorAge;
        this.image = image;
        this.key = key;
    }

    public String getServitorName() {
        return servitorName;
    }

    public void setServitorName(String servitorName) {
        this.servitorName = servitorName;
    }

    public String getServitorPhoneno() {
        return servitorPhoneno;
    }

    public void setServitorPhoneno(String servitorPhoneno) {
        this.servitorPhoneno = servitorPhoneno;
    }

    public String getServitorAddress() {
        return servitorAddress;
    }

    public void setServitorAddress(String servitorAddress) {
        this.servitorAddress = servitorAddress;
    }

    public String getServitorAge() {
        return servitorAge;
    }

    public void setServitorAge(String servitorAge) {
        this.servitorAge = servitorAge;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getKey() {
       return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
