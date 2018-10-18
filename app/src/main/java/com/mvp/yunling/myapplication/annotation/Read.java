package com.mvp.yunling.myapplication.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by yunling on 2018/10/18.
 */

public class Read {
    //四种元注解：@Target、@Retention、@Documented、@Inherited）
    //注解按运行机制分类
    /*@Target(ElementType.ANNOTATION_TYPE) //目标
    @Retention(RetentionPolicy.RUNTIME)//保留
    @Inherited //遗传
    @Documented//记录*/
     //1.源码注解 2.编译注解 3. 运行时注解
    /**
     * 1 只是在源码中存在,编译生成.class后就不存在了
     */
    /**
     * 2 @Override @Deprecated 等  3. @Autowired 可能响应运行程序
     */
}
