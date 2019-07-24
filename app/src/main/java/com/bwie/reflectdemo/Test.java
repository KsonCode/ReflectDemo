package com.bwie.reflectdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Test {
    private int a = 5;
    public static void main(String[] args){
        //第一种class类型声明
        Class<Test> c1 = Test.class;
        //第二种
        Test test = new Test();
        Class<Test> c2 = (Class<Test>) test.getClass();
        //第三种
        try {
            Class c3 = Class.forName("com.bwie.reflectdemo.Test");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



        Class<Double> c = double.class;
        try {
            Test test1 = c1.newInstance();
            System.out.println(test1.a);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

//        UserEntity userEntity = new UserEntity();

        try {
            Class userclz = UserEntity.class;
            //实例化第一种方式
//            UserEntity userEntity = (UserEntity) userclz.newInstance();
//            userEntity.age = 100;
//            System.out.println(userEntity.age);

            //实例话第二种方式
            //构造器
            Constructor constructor = userclz.getDeclaredConstructor(null);
            //暴力访问
            constructor.setAccessible(true);
            //通过构造器创建对象，newinstance
            UserEntity o = (UserEntity) constructor.newInstance(null);
            o.age = 100;
            System.out.println(o.age);

            //public构造函数
            Constructor constructor1 = userclz.getConstructor(String.class,int.class);
            UserEntity o1 = (UserEntity) constructor1.newInstance("kson",99);
            System.out.println(o1.age+" ");


            //获取私有属性（域）
            Field field = userclz.getDeclaredField("name");
            field.setAccessible(true);
            field.set(o1,"lisi");
            System.out.println(field.get(o1));

            //获取公共的
            Field field1 = userclz.getField("age");
            field1.set(o1,66);
            System.out.println(field1.get(o1));

            //调用方法
            Method method = userclz.getDeclaredMethod("fun",null);
            method.setAccessible(true);//暴力访问
            method.invoke(o1,null);
            //调用带参数的方法
            Method method1 = userclz.getDeclaredMethod("fun",String.class);
            method1.setAccessible(true);
            method1.invoke(o1,"nninininini");


            Method[] methods = userclz.getDeclaredMethods();
            for (Method method2 : methods) {
                System.out.println(method2.getName());

            }

            List<String> list = new ArrayList<>();
            list.add("1");
            list.add("2");
            list.add("3");
            list.add("4");
            list.add(String.valueOf(1));

            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
