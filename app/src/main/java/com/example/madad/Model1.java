package com.example.madad;

public class Model1 {




    Model1(){

    }

     String name ,url;

    public Model1(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
