package com.mvp.yunling.myapplication.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *   Created by yunling on 2018/10/18.
 */
@Target({ElementType.METHOD,ElementType.TYPE}) //目标
@Retention(RetentionPolicy.RUNTIME)//保留
@Inherited //遗传
@Documented//记录
public @interface Description {//没有成员的称为标识注解
    String desc();
    String anthor();
    int age() default 18;
    //ElementType
    //type 类 接口 parameter 参数 LOCAL_VARIABLE 局部变量申明 FIELD 字段声明 CONSTRUCTOR 构造函数
    //@Target 作用域
    //@Retention：表示该注解的生命周期
    //@Inherited:此注解是标识性的元注解，表示当前注解可以由子注解来继承
   // @Documented:表示生成javadoc的时候会包含注解
  //定义注解时，会需要一些元注解（meta-annotation），如@Target和@Retention。
    // @Target用来定义你的注解将用于什么地方（例如是一个方法或一个域）
    // 。@Retention用来定义该注解在哪一个级别可用，在源代码（SOURCE 只在源码中存在）、
    // 类文件中（CLASS(编译时)）或者运行时（RUNTIME 可能什么时候都存在 会影响运行情况）。

}
