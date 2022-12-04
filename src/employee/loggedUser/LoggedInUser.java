/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.loggedUser;

import java.sql.ResultSet;

/**
 *
 * @author pande
 */
public class LoggedInUser {
    String name ;
    String email , password , gender , phoneNo , module;
    ResultSet rs;

//    public void setRs(ResultSet rs) {
//        this.rs = rs;
//        try{
//            this.name = rs.getString("name");
//            System.out.println(name);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getModule() {
        return module;
    }
    public String getName() {
//        System.out.println(name+"getName fun called");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
