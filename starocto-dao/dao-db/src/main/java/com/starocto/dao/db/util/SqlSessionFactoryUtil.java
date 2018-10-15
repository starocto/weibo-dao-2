package com.starocto.dao.db.util;

import com.starocto.dao.db.mapper.WeiboDataMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Author : zjx@.com
 * Date   : 2018/10/6
 * Time   : 06:45
 * ---------------------------------------
 * Desc   :
 */
public class SqlSessionFactoryUtil {

    /**
     * SqlSessionFactory对象
     */
    private static SqlSessionFactory sqlSessionFactory = null;
    private static WeiboDataMapper dataMapper = null;

    /**
     * 类线程锁
     */
    private static final Class CLASS_LOCK = SqlSessionFactoryUtil.class;

    /**
     * 私有化构造参数
     */
    private SqlSessionFactoryUtil() {}

    /**
     * 构建SQLSessionFactory
     */
    public static SqlSessionFactory initSqlSessionFactory() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException ex) {
            Logger.getLogger(SqlSessionFactoryUtil.class.getName()).log(Level.SEVERE,null,ex);
        }
        //下面括号中不能写this、因为initSqlSessionFactory是静态的
        synchronized (CLASS_LOCK) {
            if (sqlSessionFactory==null){
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
        }
        return  sqlSessionFactory;
    }

    /**
     * 打开SqlSession
     */
    public static SqlSession openSqlSession(){
        if (sqlSessionFactory == null){
            initSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }

    public static WeiboDataMapper getDataMapper(){
        if (dataMapper != null){
            return dataMapper;
        }
        SqlSession sqlSession = null;
        try{
            sqlSession = openSqlSession();
            dataMapper = sqlSession.getMapper(WeiboDataMapper.class);
            sqlSession.commit();
        }catch (Exception e){
            System.err.println(e.getMessage());
            sqlSession.rollback();
        }
        return dataMapper;
    }

}
