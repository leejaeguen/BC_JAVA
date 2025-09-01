package com.worms.section03.delete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.worms.common.JDBCTemplate.*;

public class Ex01 {
    public static void main(String[] args) {
        Connection con = getConnection();

        PreparedStatement pstmt = null;
        int reult = 0;

        /* 설명. 1. soft delete */
//        String query = "UPDATE TBL_MENU SET ORDERABLE_STATUS = 'N' WHERE MENU_CODE = ? ";

        /* 설명. 2. hard delete */
        String query = "DELETE FROM TBL_MENU WHERE MENU_CODE = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, 33);

            reult = pstmt.executeUpdate();

            if (reult == 1) {
                commit(con);
            } else {
                rollback(con);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(con);
        }
    }
}
