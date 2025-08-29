package com.worms.section01.section02.template;

import java.sql.Connection;

import static com.worms.section01.section02.template.JDBCTemplate.close;
import static com.worms.section01.section02.template.JDBCTemplate.getConnection;

public class Ex01 {
    public static void main(String[] args) {

        /* 설명. main 로직에서 Connection 객체가 필요한 순간에 한 줄 코딩으로 받아내기 */
//        Connection con = JDBCTemplate.getConnection();
        Connection con = getConnection();
        System.out.println("con" + con);
        
        /* 설명. connection 객체를 활용한 구문(SQL문을 통해 DB와의 CRUD) */

//        JDBCTemplate.close(con);
        close(con);

    }
}
