/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbconnection;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author pande
 */
public class Db_Operations {
    public static ResultSet login(String email , String pass){
        ResultSet rs = null;
        try {
            Connection con = dbconnection.DbConnect.getConnection(); //database connection
            PreparedStatement ps = con.prepareStatement("select * from register where email=? and password=?");
            ps.setString(1, email);
            ps.setString(2, pass);
            
             rs = ps.executeQuery();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
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
    public static ResultSet showAllEmployee(){
        ResultSet rs = null;
        try{
            Connection con = dbconnection.DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from register where module='Employee'");
            rs = ps.executeQuery();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    public static ResultSet getSelectedEmployee(String email){
        ResultSet rs = null;
        try{
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from register where email=?");
            ps.setString(1, email);
            rs = ps.executeQuery();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    
    public static int UpdateEmployeeDetails(String name,String email,String phone_no,String gender,String password){
        int i = 0;
        try{
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("update register set name=?, password=?, gender=?, phone_no=? where email=?");
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3, gender);
            ps.setString(4, phone_no);
            ps.setString(5, email);
            
            i = ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return i;
    }
    
    public static int DeleteEmployee(String email){
        int i =0;
        try{
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from register where email=?");
            ps.setString(1, email);
            i = ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return i;
    }
    
    public static boolean ProductMeta(FileInputStream file , String... str){
        boolean status = false;
        try{
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into items values(?,?,?,?,?,?)");
            ps.setString(1, str[0]);
            ps.setString(2, str[1]);
            ps.setString(3, str[2]);
            ps.setString(4, str[3]);
            ps.setString(5, str[4]);
            ps.setBinaryStream(6, file);
            
            int i = ps.executeUpdate();
            if(i>0){
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
    
    public static ResultSet getAllItems()
    {
        ResultSet rs = null;
        try
        {
            Connection con=dbconnection.DbConnect.getConnection();
            
            PreparedStatement ps=con.prepareStatement("select * from items");
            rs=ps.executeQuery();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return rs;
    }
    
    public static ResultSet getItemDetails(String item_id)
    {
        ResultSet rs = null;
        try
        {
            Connection con=DbConnect.getConnection();
            
            PreparedStatement ps=con.prepareStatement("select * from items where item_id=?");
            ps.setString(1, item_id);
            rs=ps.executeQuery();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return rs;
    }
    
    public static boolean deleteItem(String item_id)
    {
        boolean status=false;
        try
        {
            Connection con=DbConnect.getConnection();
            
            PreparedStatement ps=con.prepareStatement("delete from items where item_id=?");
            ps.setString(1, item_id);
            
            int i=ps.executeUpdate();
            if(i>0)
            {
                status=true;
            }
            else
            {
                status=false;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return status;
    }
    
    public static boolean updateItemWithImage(FileInputStream fis, String... str)
    {
        boolean status=false;
        try
        {
            Connection con=DbConnect.getConnection();
            
            PreparedStatement ps=con.prepareStatement("update items set item_name=?, item_price=?, item_desc=?, item_category=?, item_img=? where item_id=?");
            ps.setString(1, str[1]);
            ps.setString(2, str[2]);
            ps.setString(3, str[3]);
            ps.setString(4, str[4]);
            ps.setBinaryStream(5, fis);
            ps.setString(6, str[0]);
            
            int i=ps.executeUpdate();
            if(i>0)
            {
                status=true;
            }
            else
            {
                status=false;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return status;
    }
    
    public static boolean updateItemWithoutImage(String... str)
    {
        boolean status=false;
        try
        {
            Connection con=DbConnect.getConnection();
            
            PreparedStatement ps=con.prepareStatement("update items set item_name=?, item_price=?, item_desc=?, item_category=? where item_id=?");
            ps.setString(1, str[1]);
            ps.setString(2, str[2]);
            ps.setString(3, str[3]);
            ps.setString(4, str[4]);
            ps.setString(5, str[0]);
            
            int i=ps.executeUpdate();
            if(i>0)
            {
                status=true;
            }
            else
            {
                status=false;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
    
        public static boolean checkOldPassword(String email , String old_pwd)
    {
        boolean status=false;
        try
        {
            Connection con=DbConnect.getConnection();
            
            PreparedStatement ps=con.prepareStatement("select * from register where email=? and password=?");
            ps.setString(1, email);
            ps.setString(2, old_pwd);
            
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                status=true;
            }
            else
            {
                status=false;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        return status;
    }
        
    public static boolean updateAdminPassword(String email,String pass){
        boolean status = false;
        try{
            Connection con = DbConnect.getConnection();
            
            PreparedStatement ps = con.prepareStatement("update register set password=? where email=?");
            ps.setString(1, pass);
            ps.setString(2, email);
            
            int i = ps.executeUpdate();
            if(i>0){
                status = true;
            }else{
                status = false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return status;
    }
    
    public static boolean updateEmployeePassword(String email,String pass){
        boolean status = false;
        try{
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("update register set password =? where email=?");
            ps.setString(1, pass);
            ps.setString(2, email);
            
            int i = ps.executeUpdate();
            if(i>0){
                status = true;
            }else{
                status = false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return status;
    }
    
    public static boolean UpdateEmployeeProfile(String ... args){
        boolean status = false;
        try{
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("update register set name=?,phone_no=?, gender=? where email=?");
            ps.setString(1, args[0]);
            ps.setString(2, args[1]);
            ps.setString(3, args[2]);
            ps.setString(4, args[3]);
            
            int i = ps.executeUpdate();
            if(i>0) status = true;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return status;
    }
    
    public static boolean InsertCustomerDetails(String... str){
        boolean status = false;
        String name = str[0];
        String email = str[1];
        String pass = str[2];
        String gender = str[3];
        String phone_no = str[4];
        String module = str[5];
        
        try{
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, pass);
            ps.setString(4, gender);
            ps.setString(5, phone_no);
            ps.setString(6, module);
            
            int i = ps.executeUpdate();
            if(i>0){
                status = true;
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return status;
    }
    
    public static ResultSet checkCustomerExists(String phone_no){
        ResultSet rs = null;
        try{
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from register where phone_no=?");
            ps.setString(1, phone_no);
            rs = ps.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    
    public static boolean customerBillingDetails(String customer_phno, String items, String date1, String time1, String emp_email) {
        boolean status = false;
        try {
            Connection con = DbConnect.getConnection();

            PreparedStatement ps = con.prepareStatement("insert into customer values(?,?,?,?,?)");
            ps.setString(1, customer_phno);
            ps.setString(2, items);
            ps.setString(3, date1);
            ps.setString(4, time1);
            ps.setString(5, emp_email);
            int i = ps.executeUpdate();
            if (i > 0) {
                status = true;
            } else {
                status = false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    
    public static ResultSet CustomerDataFetch(String phone_no){
        ResultSet rs = null;
        try{
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from register where phone_no=?");
            ps.setString(1, phone_no);
            rs = ps.executeQuery();
        }catch(Exception e){
            System.out.println("test");
            e.printStackTrace();
        }
        return rs;
    }
    
    public static ResultSet getCustomerPurchasedItems(String phone_no){
        ResultSet rs = null;
        try{
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from customer where customer_phno=?");
            ps.setString(1,phone_no);
            rs = ps.executeQuery();
        }catch(Exception e){
            System.out.println("testing hehe");
            e.printStackTrace();
        }
        return rs;
    }
}
