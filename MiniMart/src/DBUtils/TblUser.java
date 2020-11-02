/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtils;

import Model.User;
import java.util.ArrayList;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class TblUser {
    User transferedUser;
    
    public ArrayList loadUser() {
        ArrayList<User> userList = new ArrayList<>();
        ResultSet rs;
        ResultSetMetaData meta;
        DBConnect condb = new DBConnect();
        Vector data = new Vector();
        
        try {
            Connection con = condb.sqlConnect();
            if (con == null) System.out.println("a2");
            Statement sta = con.createStatement();
            
            rs = sta.executeQuery("SELECT * FROM tblUser");
            meta = rs.getMetaData();
            
            while (rs.next()) {
                User tempUser = new User();
                tempUser.setUserID(rs.getInt(1));
                tempUser.setUserName(rs.getString(2));
                tempUser.setGroup(rs.getInt(3));
                tempUser.setUserLoginName(rs.getString(4));
                tempUser.setPassword(rs.getString(5));
                userList.add(tempUser);
            }
            
            rs.close(); sta.close(); con.close();
            return userList;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
    }
    
    public DefaultTableModel loadUserTable() {
        DefaultTableModel empModel = new DefaultTableModel();
        ResultSet rs;
        ResultSetMetaData meta;
        DBConnect condb = new DBConnect();
        Vector<String> header = new Vector<>();
        Vector data = new Vector();
        
        try {
            Connection con = condb.sqlConnect();
            Statement sta = con.createStatement();
            
            rs = sta.executeQuery("SELECT * FROM tblUser");
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
    
    public boolean insertDB(int id, String name, int group, String loginName, String password) 
            throws ClassNotFoundException {
        Connection con = new DBConnect().sqlConnect();
        
        String insertQuery = "INSERT INTO tblUser "
                + "VALUES ("+id+",'"+name+"',"+group+",'"+loginName+"','"+password+"')";
        
        try {
            Statement stm = con.createStatement();
            stm.execute(insertQuery);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean updateDB(int id, String name, int group, String loginName, String password) 
            throws ClassNotFoundException {
        Connection con = new DBConnect().sqlConnect();
        
        String updateQuery = "UPDATE tblUser SET UserName='"+name+"',UserGroup="+group+",UserLoginName='"+
                loginName+"',UserLoginPassword='"+password+"' WHERE UserID="+id+"";
        
        try {
            Statement stm = con.createStatement();
            stm.execute(updateQuery);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean deleteDB(int id) throws ClassNotFoundException {
        Connection con = new DBConnect().sqlConnect();
        String deteleQuery = "DELETE FROM tblUser WHERE UserID="+id+"";
        Statement stm;
        try {
            stm = con.createStatement();
            stm.execute(deteleQuery);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean changePassword(int id, String newPass) {
        Connection con;
        String changeQuery = "UPDATE tblUser SET UserLoginPassword=? WHERE UserID=?";
        PreparedStatement stm;
        
        try {
            con = new DBConnect().sqlConnect();
            stm = con.prepareStatement(changeQuery);
            stm.setString(1, newPass);
            stm.setInt(2, id);
            int result = stm.executeUpdate();
            
            if (result > 0) {
                return true;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
