package com.worms.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement;

public class JDBCTemplate {
    public static Connection getConnection() {
        Connection con = null;
        Properties prop = new Properties();

        /* 설명. mysql 드라이버 클래스의 풀 네임을 통해 드라이버 등록(메모리에 등록) */
        try {
            prop.load(
                    new FileReader(
                            "src/main/java/com/worms/config/connection-info.properties"));
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");



            Class.forName(driver);  // 동적 메모리 할당
            con = DriverManager.getConnection(url, username, password);
            
            /* 설명. 수동 커밋 및 롤백 설정 */
            con.setAutoCommit(false);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e){
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /* 설명. Connection 객체를 닫으면 안됨 */

        return con;
    }

    public static void close(Connection con) {
        try {
            if (con != null) con.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public static void close(Statement stmt) {
        try {
            if (stmt != null) stmt.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rset) {
        try {
            if (rset != null) rset.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void  commit(Connection con) {
        try {
            con.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void rollback(Connection con) {
        try {
            con.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
