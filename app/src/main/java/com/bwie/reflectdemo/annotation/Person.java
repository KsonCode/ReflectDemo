package com.bwie.reflectdemo.annotation;


@PersonAnnotation(id = 2)
public class Person {

    @PersonAnnotation(id = 2)
    private String name;

    @PersonAnnotation(id = 3)
    private Person(){

    }

    @PersonAnnotation(id = 3)
    public void fun(@Query("userid") String userid){

    }
}
