package com.worms.section01.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Ex01 {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";

        /* 설명. JDBC에서의 Connection 객체 같은 개념 */
        SqlSession session = null;

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);

            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession(false); // false를 주어야 수동 커밋 가능

            java.util.Date nowDate = session.selectOne("mapper.selectNow");
            System.out.println("nowDate=" + nowDate);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }
}
