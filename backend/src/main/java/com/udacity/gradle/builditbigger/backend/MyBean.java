package com.udacity.gradle.builditbigger.backend;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String name;
    private String myData;

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}