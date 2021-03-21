package com.LatticeAssignment.util;

import java.util.regex.Pattern;

public class ValidationUtil {

    // password check-> one digit, one lowercase, one uppercase
    public boolean passwordVal(String password) {
        Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
        Pattern lowerCasePatten = Pattern.compile("[a-z ]");
        Pattern digitCasePatten = Pattern.compile("[0-9 ]");

        if(!UpperCasePatten.matcher(password).find() || !lowerCasePatten.matcher(password).find() || !digitCasePatten.matcher(password).find())
            return false;

        return true; // validated
    }
}
