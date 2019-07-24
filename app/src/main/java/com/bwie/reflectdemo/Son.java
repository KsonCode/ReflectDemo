package com.bwie.reflectdemo;

public class Son extends Father {

    private boolean isRun = true;
    @Override
    public void fun() {
        super.fun();

        new Thread(new Runnable() {
            @Override
            public void run() {

                if (isRun){
                    System.out.println("");
                }
                //
                //
                //

            }
        }).start();
    }

    public void stop(){
        isRun = false;
    }
}
