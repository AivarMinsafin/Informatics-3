package ru.itis.aivar.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean validatePassword(String password){
        if (password.length() >= 8){
            return true;
        }
        return false;
    }

    public static boolean validateEmail(String email){
        Pattern pattern = Pattern.compile(".+@.+\\..+");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()){
            return true;
        }
        return false;
    }

}
