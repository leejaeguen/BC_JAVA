package com.worms.section02.update;

import java.sql.Connection;

import static com.worms.common.JDBCTemplate.*;

public class MenuService {
    public void modifyMenu(Menu menu) {
        Connection con = getConnection();

        MenuRepository repository = new MenuRepository();
        int result = repository.updateMenu(menu, con);

        if (result == 1) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
    }
}
