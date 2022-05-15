package com.gsh.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class SqlSessionUtil {

    private SqlSessionUtil(){

    }

    private static SqlSessionFactory sessionFactory;

    static{

        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static ThreadLocal<SqlSession> tl = new ThreadLocal<SqlSession>();


    public static SqlSession getSqlSession(){

        SqlSession sqlSession = tl.get();
        if(sqlSession == null){
             sqlSession = sessionFactory.openSession();
             tl.set(sqlSession);
        }
        return sqlSession;

    }



    public static void closeSqlSession(SqlSession session){

        session.close();

        tl.remove();

    }

}
