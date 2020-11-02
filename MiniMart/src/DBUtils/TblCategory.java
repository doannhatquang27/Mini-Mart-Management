/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class TblCategory {
    public DefaultTableModel loadCateloryTable() {
        DefaultTableModel empModel = new DefaultTableModel();
        ResultSet rs;
        ResultSetMetaData meta;
        DBConnect condb = new DBConnect();
        Vector<String> header = new Vector<>();
        Vector data = new Vector();
        
        try {
            Connection con = condb.sqlConnect();
            Statement sta = con.createStatement();
            
            rs = sta.executeQuery("SELECT * FROM tblCategory");
            meta = rs.getMetaData();
            for (int i = 1; i <= 2; i++) {
                header.add(meta.getColumnName(i));
            }
            
            while (rs.next()) {
                Vector<String> v = new Vector<>();
                for (int i = 1; i <= 2; i++) {
                    v.add(rs.getString(i));
                }
                data.add(v);
            }
            
            empModel.setDataVector(data, header);
            rs.close(); sta.close(); con.close();
            return empModel;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
    }
    
    public boolean insertCategoryDB(int id, String name) throws ClassNotFoundException {
        Connection con = new DBConnect().sqlConnect();
        String insertQuery = "INSERT INTO tblCategory " + "VALUES ('"+name+"',"+id+")";
        
        try {
            Statement stm = con.createStatement();
            stm.execute(insertQuery);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean updateCategoryDB(int id, String name) throws ClassNotFoundException {
        Connection con = new DBConnect().sqlConnect();
        
        String updateQuery = "UPDATE tblCategory SET CategoryName='"+name+"' WHERE CategoryID="+id+"";
        
        try {
            Statement stm = con.createStatement();
            stm.execute(updateQuery);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean deleteCategoryDB(int id) throws ClassNotFoundException {
        Connection con = new DBConnect().sqlConnect();
        String deteleQuery = "DELETE FROM tblCategory WHERE CategoryID="+id+"";
        Statement stm;
        try {
            stm = con.createStatement();
            stm.execute(deteleQuery);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }  
}
