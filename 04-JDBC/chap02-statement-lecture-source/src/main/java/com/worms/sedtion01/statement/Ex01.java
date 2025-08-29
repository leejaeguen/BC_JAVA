package com.worms.sedtion01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.worms.common.JDBCTemplate.close;
import static com.worms.common.JDBCTemplate.getConnection;

public class Ex01 {
    public static void main(String[] args) {

        Connection con = getConnection();
        System.out.println("con = " + con);      // DB와 연동 확인

        Statement stmt = null;                  // SQL 및 쿼리 실행 결과를 싣고 dbms 오가는 트럭같은 개념
        ResultSet rset = null;                  // 쿼리(SELECT)와 결과(JAVA의 타입)


        
        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery("select * from EMPLOYEE");
            
            /* 설명. 다중행 조회 결과를 반복하며 추출 */
            while (rset.next()) {

                /* 설명. 반복문 안에서는 단일행을 하나하나 컬럼별로 꺼내쓴다. */
                System.out.println(rset.getString("EMP_NAME") + ", " + rset.getString("SALARY"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            /* 설명. 코드의 줄 수를 줄이고 가독성을 높이기 위해 모듈화 */
            close(rset);
            close(stmt);
            close(con);
        }
    }
}
