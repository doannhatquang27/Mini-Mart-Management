/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtils;

import Model.Product;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import microsoft.sql.Types;

/**
 *
 * @author ASUS
 */
public class TblProduct {
    public ArrayList loadProduct() {
        ArrayList<Product> productList = new ArrayList<>();
        ResultSet rs;
        ResultSetMetaData meta;
        DBConnect condb = new DBConnect();
        
        try {
            Connection con = condb.sqlConnect();
            Statement stm = con.createStatement();
            
            rs = stm.executeQuery("SELECT * FROM tblProduct");
            meta = rs.getMetaData();
            
            while (rs.next()) {
                Product temp = new Product();
                temp.setProductId(rs.getInt(1));
                temp.setProductName(rs.getString(2));
                temp.setPrice(rs.getInt(3));
                temp.setCategory(rs.getInt(4));
                temp.setAmount(rs.getInt(5));
                productList.add(temp);
            }
            
            rs.close(); stm.close(); con.close();
            return productList;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TblProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public DefaultTableModel loadProductTable() {
        DefaultTableModel model = new DefaultTableModel();
        ResultSet rs;
        ResultSetMetaData meta;
        Vector<String> header = new Vector<>();
        Vector data = new Vector();
        DBConnect condb = new DBConnect();
        
        try {
            Connection con = condb.sqlConnect();
            Statement stm = con.createStatement();
            
            rs = stm.executeQuery("SELECT * FROM tblProduct");
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
            
            model.setDataVector(data, header);
            rs.close(); stm.close(); con.close();
            return model;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TblProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public DefaultTableModel loadInventoryTable() {
        DefaultTableModel empModel = new DefaultTableModel();
        ResultSet rs;
        ResultSetMetaData meta;
        DBConnect condb = new DBConnect();
        Vector<String> header = new Vector<>();
        Vector data = new Vector();
        
        try {
            Connection con = condb.sqlConnect();
            Statement sta = con.createStatement();
            
            rs = sta.executeQuery("SELECT * FROM tblProduct");
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
    
    public boolean insertDB(int id, String name, int price, int category, int amount) 
            throws ClassNotFoundException, SQLException {
        Connection con = null;
        Statement stm = null;
        
        try {
            con = new DBConnect().sqlConnect();
            if (con != null) {
                String insertQuery = "INSERT INTO tblProduct "
                        + "VALUES ("+id+",'"+name+"',"+price+","+category+","+amount+")";
                
                stm = con.createStatement();
                int row = stm.executeUpdate(insertQuery);
                
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    public DefaultTableModel loadStockTable() {
        DefaultTableModel empModel = new DefaultTableModel();
        ResultSet rs;
        ResultSetMetaData meta;
        DBConnect condb = new DBConnect();
        Vector<String> header = new Vector<>();
        Vector data = new Vector();
        
        try {
            Connection con = condb.sqlConnect();
            Statement sta = con.createStatement();
            
            rs = sta.executeQuery("SELECT * FROM tblProduct");
            meta = rs.getMetaData();
            for (int i = 1; i <= 2; i++) {
                header.add(meta.getColumnName(i));
            }
            header.add(meta.getColumnName(5));
            header.add("Status");
            
            int amount = 0;
            while (rs.next()) {
                Vector<String> v = new Vector<>();
                for (int i = 1; i <= 2; i++) {
                    v.add(rs.getString(i));
                }
                v.add(rs.getString(5));
                amount = Integer.parseInt(rs.getString(5).trim());
                if (amount > 0) v.add("In stock"); else v.add("Out Stock");
                data.add(v);
            }
            
            empModel.setDataVector(data, header);
            rs.close(); sta.close(); con.close();
            return empModel;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
    }
    
    public boolean updateDB(int id, String name, int price, int category, int amount)
            throws ClassNotFoundException, SQLException {
        Connection con = null;
        Statement stm = null;

        try {
            con = new DBConnect().sqlConnect();

            if (con != null) {
                String updateQuery = "UPDATE tblProduct SET ProductName='" + name + "',"
                        + "Price=" + price + ",CategoryID=" + category + ",Amount=" + amount + " "
                        + "WHERE ProductID=" + id + "";

                stm = con.createStatement();
                int row = stm.executeUpdate(updateQuery);

                if (row > 0) {
                    return true;
                }
            }

        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    public boolean deleteDB(int id) throws ClassNotFoundException, SQLException {
        Connection con = null;
        Statement stm = null;

        try {
            con = new DBConnect().sqlConnect();

            if (con != null) {
                String deleteQuery = "DELETE FROM tblProduct WHERE ProductID="+id+"";

                stm = con.createStatement();
                int row = stm.executeUpdate(deleteQuery);

                if (row > 0) {
                    return true;
                }
            }

        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }  
}

