package com.zentcode.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class Validator {
    
    public static List<ValidatorError> validate(HttpServletRequest request, String requiredParams) {
        List<ValidatorError> errors = new ArrayList<>();
        List<String> required = splitString(requiredParams);
        
        for (String param : required) {
            if (request.getParameter(param) == null) {
                ValidatorError error = new ValidatorError();
                error.setField(param);
                error.setError("El campo " + param + " es requerido.");
                errors.add(error);
            }
        }
        
        return errors;
    }
    
    private static List<String> splitString(String str) {
        List<String> list = new ArrayList<>(Arrays.asList(str.split(", ")));
        return list;
    }
}
