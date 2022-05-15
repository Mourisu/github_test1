package com.gsh.utils;

public class ServiceFactory {
    //传递 目标对象 得到 代理对象
    public static Object getService(Object service){
        return  new TransactionInvocationHandler(service).getProxy();
    }
}
