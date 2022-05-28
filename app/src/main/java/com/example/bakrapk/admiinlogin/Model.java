package com.example.bakrapk.admiinlogin;

public class Model {
    String userName1, password1;

    public Model() {
    }


    public Model(String userName1, String password1) {
        this.userName1 = userName1;
        this.password1 = password1;
    }

    public String getUserName1() {
        return userName1;
    }

    public void setUserName1(String userName1) {
        this.userName1 = userName1;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }
}
