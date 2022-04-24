package com.harneet.androidattendancesystem;

import java.util.regex.Pattern;

/**
 * Created by Windows-10 on 11/1/2018.
 */

public class Validators {
    public static boolean validatename(String name){
        try {
            if (Pattern.matches("^[a-z,A-Z, ]+$", name) == false){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean validatepass(String pass){
        try {
            if (pass.length() < 2){
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean validatephno(String phno){
        try {
            if (Pattern.matches("^0?[7-9]{1}\\d{9}$",phno) == false){
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean validateemail(String email){
        try {
            if (Pattern.matches("^\\w+@\\w+\\.\\w+$",email)== false){
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
