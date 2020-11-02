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
public class TblBill {
    public int loadBillList() {
        ResultSet rs;
        ResultSetMetaData meta;
        DBConnect condb = new DBConnect();
        
        try {
            Connection con = condb.sqlConnect();
            Statement sta = con.createStatement();
            
            rs = sta.executeQuery("SELECT * FROM tblBill");
            meta = rs.getMetaData();
            
            int billId, maxId = 0;
            
            while (rs.next()) {
                billId = rs.getInt(2);
                if (billId > maxId) maxId = billId;
            }
            
            rs.close(); sta.close(); con.close();
            return maxId;
        } catch (ClassNotFoundException | SQLException ex) {
            return -1;
        }
    }
    
    public boolean insertNewBill(int userId, int billId, int total) 
            throws ClassNotFoundException {
        Connection con = new DBConnect().sqlConnect();
        String insertQuery = "INSERT INTO tblBill (UserID, BIllID, Total) "
                + "VALUES ("+userId+","+billId+","+total+")";
        String updateDateQuery = "UPDATE tblBill SET createdDate = GETDATE() "
                + "WHERE BillID = " + billId;
     
        try {
            Statement stm = con.createStatement();
            stm.execute(insertQuery);
            stm.execute(updateDateQuery);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public DefaultTableModel loadBillTable() {
        DefaultTableModel empModel = new DefaultTableModel();
        ResultSet rs;
        ResultSetMetaData meta;
        DBConnect condb = new DBConnect();
        Vector<String> header = new Vector<>();
        Vector data = new Vector();
        
        try {
            Connection con = condb.sqlConnect();
            Statement sta = con.createStatement();
            
            rs = sta.executeQuery("SELECT * FROM tblBill");
            meta = rs.getMetaData();
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                header.add(meta.getColumnName(i));
            }
            
            while (rs.next()) {
                Vector<String> v = new Vector<>();
                for (int i = 1; i <= meta.getColumnCount(); i++) {
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
}
