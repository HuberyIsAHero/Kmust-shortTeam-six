package com.six.until;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUntil {
    public static Connection getConnectionFromPool() throws NamingException, SQLException {
        Connection result = null;
        InitialContext ctx = new InitialContext();
        DataSource ds = (DataSource)ctx.lookup("java:/comp/env/jdbc/mysql");
        result = ds.getConnection();
        return result;
    }
}
