package com.worms.sedtion01.statement;

import java.sql.Connection;

import static com.worms.common.JDBCTemplate.getConnection;

public class Ex01 {
    public static void main(String[] args) {

        Connection con = getConnection();
        System.out.println("con = "+ con);
    }
}
