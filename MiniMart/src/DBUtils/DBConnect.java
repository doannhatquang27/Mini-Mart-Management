/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class DBConnect {
    public Connection sqlConnect() throws ClassNotFoundException {
        Connection con = null;
        String url = "jdbc:sqlserver://localhost:1433;" + " databaseName=MiniMartManagement;" 
                + " username=sa;" + " password=japonisme";
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        
        
        Class.forName(driver);
        try {
            con = DriverManager.getConnection(url);
        } catch (SQLException ex) {
        }
        return con;
    }    
}
