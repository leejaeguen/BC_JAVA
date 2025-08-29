package com.worms.section03.sqlInjection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.worms.common.JDBCTemplate.close;
import static com.worms.common.JDBCTemplate.getConnection;

public class Ex01 {
    private static String empId = "200";
    private static String empName = "' OR 1=1 AND EMP_ID = '200";

    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = '" + empId +
                "' AND EMP_NAME = '" + empName + "'";

        System.out.println("query: " + query);

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            if (rset.next()) {
                System.out.println(empId + "사번에" + rset.getString("EMP_NAME") + "조회 완료!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
            close(con);
        }
    }
}
