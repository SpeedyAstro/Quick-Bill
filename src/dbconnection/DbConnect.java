/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author pande
 * Database - MySql
 * version - 8+
 * 
 */
public class DbConnect {
    static Connection con;
    public static Connection  getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing_software","root","792002");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
