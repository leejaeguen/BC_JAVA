package com.worms.section03.sqlInjection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.worms.common.JDBCTemplate.close;
import static com.worms.common.JDBCTemplate.getConnection;

public class Ex02 {
    private static String empId = "200";
    private static String empName = "' OR 1=1 AND EMP_ID = '200";

    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        /* 설명.
         *  아래 SQL과 같이 PreparedStatement를 활용하면 placeholder(?)로 입력되는 값에 single quotation(')이
         *  있다면 single quotation을 하나 더 이어 붙이고 입력 받은 전체 내용에도 양 옆에 single quotation을
         *  붙여준다.
         *  이를 통해 SQL Injection 공격을 막아낼 수 있다.
         *
         *  SELECT  * FROM EMPLOYEE WHERE EMP_ID = 200 AND EMP_NAME = ''' OR 1=1 AND EMP_ID = ''200'
        * */
        try {
            pstmt = con.prepareStatement("SELECT  * FROM EMPLOYEE WHERE EMP_ID = ? AND EMP_NAME = ?");
            pstmt.setString(1, empId);
            pstmt.setString(2, empName);
            rset = pstmt.executeQuery();

            if (rset.next()) {
                System.out.println(empId + "사번에" + rset.getString("EMP_NAME") + "조회 완료!");
            }else {
                System.out.println("그런 사람 없습니다.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(con);
            close(pstmt);
            close(rset);
        }

    }

}
