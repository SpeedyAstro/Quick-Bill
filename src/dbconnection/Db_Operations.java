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
    public static boolean register(String name1,String email1,String pass,String phone_no,String module1,String gender){
        boolean status = false;
        try{
            Connection con = dbconnection.DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?,?)"); //sql query
            ps.setString(1, name1);
            ps.setString(2, email1);
            ps.setString(3, pass);
            ps.setString(4, gender);
            ps.setString(5, phone_no);
            ps.setString(6, module1);
            
            int test = ps.executeUpdate();
            if(test>0){
                status = true;
                
            }
            else{
                status = false;
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return status;
    }
}
