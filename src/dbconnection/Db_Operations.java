/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author pande
 */
public class Db_Operations {
    public static boolean login(String email , String pass){
        boolean Status = false;
        try {
            Connection con = dbconnection.DbConnect.getConnection(); //database connection
            PreparedStatement ps = con.prepareStatement("select * from register where email=? and password=?");
            ps.setString(1, email);
            ps.setString(2, pass);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Status = true;
                
            }else{
                Status = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Status;
    }
    
}
