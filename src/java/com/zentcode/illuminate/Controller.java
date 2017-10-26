package com.zentcode.illuminate;

import java.io.IOException;
import javax.servlet.ServletException;

public interface Controller {
    
    public void index() throws ServletException, IOException;
    
    public void create() throws ServletException, IOException;
    
    public void store() throws ServletException, IOException;
    
    public void edit() throws ServletException, IOException;
    
    public void update() throws ServletException, IOException;
    
    public void delete() throws ServletException, IOException;
}
