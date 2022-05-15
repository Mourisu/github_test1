package com.gsh.utils;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionInvocationHandler implements InvocationHandler {


    private Object target ;

    public TransactionInvocationHandler(Object target){
        this.target =target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        SqlSession session =null;

        Object object =null;


        try {
           session = SqlSessionUtil.getSqlSession();
           object = method.invoke(target, args);
            System.out.println("----->>invoke  动态代理");
           session.commit();

        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        }finally {
            SqlSessionUtil.closeSqlSession(session);
        }


        return object;
    }



    public  Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }

}
