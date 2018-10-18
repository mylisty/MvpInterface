package com.mvp.yunling.myapplication.annotation;

import java.lang.annotation.Annotation;

/**
 * Created by yunling on 2018/10/18.
 */

public class Test {

    public static void main(String[] arg){
        try {
            Class  aClass = Class.forName("com.mvp.yunling.myapplication.annotation.Child");
            boolean annotationPresent = aClass.isAnnotationPresent(Description.class);
            System.out.println("aaaaa   ee "+annotationPresent );
            if (annotationPresent){
             Description description = (Description) aClass.getAnnotation(Description.class);
                System.out.println("aaaaa "+description.age());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
