/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtils;

import Model.Income;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class TblStockInOutDetails {
    public ArrayList<Income> loadStoreAmount() 
            throws ClassNotFoundException, SQLException {
        ArrayList<Income> incomeList = new ArrayList<>();
        Connection con = new DBConnect().sqlConnect();
        String loadQuery = "SELECT tblProduct.ProductID, tblStockInOutDetails.Amount, modifyDay, tblProduct.Price "
                + "FROM ((tblStockInOutDetails "
                + "INNER JOIN tblStockInOut ON tblStockInOut.StockInOutID = tblStockInOutDetails.StockInOutID)"
                + "INNER JOIN tblProduct ON tblStockInOutDetails.ProductID = tblProduct.ProductID)";
        Statement stm = null;
        ResultSet rs = null;
        
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(loadQuery);
            
            while (rs.next()) {
                Income ic = new Income();
                ic.setProductId(rs.getInt(1));
                ic.setAmount(rs.getInt(2));
                ic.setDate(rs.getDate(3));
                ic.setPrice(rs.getInt(4));
                incomeList.add(ic);
            }
            
            if (incomeList.size() > 0) {
                return incomeList;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
        }
        return null;
    }
    
    public boolean insertStock(int id, int productID, int amount) throws ClassNotFoundException {
        Connection con = new DBConnect().sqlConnect();
        String insertQuery = "INSERT INTO tblStockInOutDetails " + "VALUES ("+id+","+productID+","+amount+")";
     
        try {
            Statement stm = con.createStatement();
            stm.execute(insertQuery);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
}
