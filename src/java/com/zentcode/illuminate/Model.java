package com.zentcode.illuminate;

import javax.servlet.http.HttpServletRequest;

public interface Model {
    
    public String requiredParams();
    
    public void fill(HttpServletRequest request);
}
