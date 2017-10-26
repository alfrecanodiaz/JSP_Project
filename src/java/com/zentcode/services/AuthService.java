package com.zentcode.services;

import com.zentcode.models.User;
import java.util.Map;

public interface AuthService {
    
    public boolean auth(Map<String, String> credentials);
    
    public void login(User user);
    
    public void logout();
    
    public User getCurrentAuth();
    
    public boolean check();
}
