package com.worms.sedtion01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.worms.common.JDBCTemplate.close;
import static com.worms.common.JDBCTemplate.getConnection;

public class EX02 {
    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        // Scnner를 활용해 사용자의 입력에 따른 사원 조회
        Scanner sc = new Scanner(System.in);
        System.out.print("조회하고자 하는 사원의 번호를 입력하새요: ");
        String empId = sc.nextLine();

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery("select * from EMPLOYEE where EMP_ID='" + empId + "'");
            if (rset.next()) {
                System.out.println("조회하신" + empId + "번의 사원은 " + rset.getString("EMP_NAME")+ "입니다.");
            } else {
                System.out.println("그런사람 없습니다.");
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
