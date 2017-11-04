package com.zentcode.services;

import com.zentcode.models.User;
import java.util.List;

public interface UserService {
    
    public List<User> listAll();
    
    public Long insert(User user);
    
    public User findById(Integer id);
    
    public void update(User user);
    
    public void delete(Integer id);
    
    public String getMessage();
}