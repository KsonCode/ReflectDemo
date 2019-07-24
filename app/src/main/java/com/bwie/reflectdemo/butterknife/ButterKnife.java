package com.bwie.reflectdemo.butterknife;

import android.app.Activity;
import android.view.View;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 依赖注入工具类
 */
public class ButterKnife {
    public static void bind(Activity activity){
        setContentView(activity);
        bindView(activity);
    }

    /**
     * 渲染布局
     */
    private static void setContentView(Activity activity) {

        try {
            Class c = activity.getClass();
            Method method = c.getMethod("setContentView",int.class);
            //通过类的类类型实例，获取所需注解
            ContentView contentView = (ContentView) c.getAnnotation(ContentView.class);
            if (contentView!=null){
                int layoutId = contentView.value();
//                activity.setContentView(layoutId);
                method.invoke(activity,layoutId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 绑定view
     */
    private static void bindView(Activity activity) {
        Class c = activity.getClass();

        Field[] fields = c.getDeclaredFields();

        for (Field field : fields) {


                try {

                    field.setAccessible(true);//允许访问

                    BindView bindView = field.getAnnotation(BindView.class);
                    if (bindView!=null) {
                        int viewId = bindView.value();
                        View view = activity.findViewById(viewId);
                        field.set(activity, view);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }




        }


    }
}
