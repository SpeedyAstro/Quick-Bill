/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author pande
 */
public class RegExValidations {
    private Pattern name,email,phno,password;
    private Matcher matcher;
    
    String name_pattern = "^[a-zA-Z]{3,30}$";
    String email_pattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    String phone_pattern = "^[0-9]{10}$";
    String pass_pattern = "^[a-zA-Z0-9]{5,20}$";
    public RegExValidations(){
        name = Pattern.compile(name_pattern);
        email = Pattern.compile(email_pattern,Pattern.CASE_INSENSITIVE);
        phno = Pattern.compile(phone_pattern);
        password = Pattern.compile(pass_pattern);
        
    }
    public boolean emailValidation(String user_email){
        matcher = email.matcher(user_email);
        return matcher.matches();
    }
    public boolean nameValidation(String user_name){
        matcher = name.matcher(user_name);
        return matcher.matches();
    }
    public boolean phoneNoValidation(String phone_no){
        matcher = phno.matcher(phone_no);
        return matcher.matches();
    }
    public boolean passwordValidate(String pass){
        matcher = password.matcher(pass);
        return matcher.matches();
    }
}
