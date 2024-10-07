package org.example;

public class MyBean {
    private String str;
    public void setStr (String str) {
        this.str = str;
    }
    public String doSomething () {
        System.out.println("from MyBean " + str);
        return "from MyBean return >> " + str;
    }
}