package com.newcoder.zhike.model;

public class User {
    private String name;
    private int id;
    private String password;
    private String headurl;
    private String salt;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadurl() {
        return headurl;
    }

    public void setHeadurl(String headurl) {
        this.headurl = headurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(){

    }
    public User(String name){
        this.name = name;
        this.password = "";
        this.salt = "";
        this.headurl = "";
    }
    public String getDescription(){
        return "This is "+ name;
    }
}
