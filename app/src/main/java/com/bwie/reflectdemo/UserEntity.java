package com.bwie.reflectdemo;

public class UserEntity {
    private String name="zs";
    public int age;
    private UserEntity(){

    }

    public UserEntity(String name,int age){
        System.out.println("name "+name+"  age:"+age);

    }

    private void fun(){
        System.out.println("=====");

    }
    protected void fun(String uid){
        System.out.println("uid:"+uid);

    }
}
