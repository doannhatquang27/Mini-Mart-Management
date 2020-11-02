/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class TblBillDetails {
    public boolean insertBillDetail(int billId, int productID, int amount, 
            int price, int totalPrice) throws ClassNotFoundException {
        Connection con = new DBConnect().sqlConnect();
        String insertQuery = "INSERT INTO tblBillDetails " + 
                "VALUES ("+billId+","+productID+","+amount+","+price+","+totalPrice+")";
     
        try {
            Statement stm = con.createStatement();
            stm.execute(insertQuery);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
}
