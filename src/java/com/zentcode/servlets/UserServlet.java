package com.zentcode.servlets;

import com.zentcode.dao.UserImplement;
import com.zentcode.illuminate.Controller;
import com.zentcode.models.User;
import com.zentcode.services.UserService;
import com.zentcode.utils.QueryHelper;
import com.zentcode.utils.Validator;
import com.zentcode.utils.ValidatorError;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet implements Controller {
    
    UserService service;
    HttpServletResponse mResponse;
    HttpServletRequest mRequest;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        mRequest = request;
        mResponse = response;
        service = new UserImplement();
        
        switch (request.getParameter("action")) {
            case QueryHelper.INDEX:
                this.index();
                break;
            
            case QueryHelper.CREATE:
                this.create();
                break;
                
            case QueryHelper.STORE:
                this.store();
                break;
                
            case QueryHelper.EDIT:
                this.edit();
                break;
                
            case QueryHelper.UPDATE:
                this.update();
                break;
                
            case QueryHelper.DELETE:
                this.delete();
                break;
        }
    }

    @Override
    public void index() throws ServletException, IOException {
        List<User> list = service.listAll();
        
        mRequest.setAttribute("list", list);

        mRequest.getRequestDispatcher("user_index.jsp").forward(mRequest, mResponse);
    }

    @Override
    public void create() throws ServletException, IOException {
        mRequest.getRequestDispatcher("user_create.jsp").forward(mRequest, mResponse);
    }

    @Override
    public void store() throws ServletException, IOException {
        User user = new User();
        String route = "User?action="+QueryHelper.INDEX;
                
        List<ValidatorError> errors = Validator.validate(mRequest, user.requiredParams());
        if (errors.isEmpty()) {
            user.fill(mRequest);
            service.insert(user);
        } else {
            mRequest.setAttribute("errors", errors);
            route = "user_create.jsp";
        }
        
        mRequest.getRequestDispatcher(route).forward(mRequest, mResponse);
    }

    @Override
    public void edit() throws ServletException, IOException {
        Integer id = Integer.valueOf(mRequest.getParameter("id"));
        User user = service.findById(id);
        mRequest.setAttribute("user", user);
        
        mRequest.getRequestDispatcher("user_edit.jsp").forward(mRequest, mResponse);
    }

    @Override
    public void update() throws ServletException, IOException {
        User user = new User();
        String route = "User?action="+QueryHelper.INDEX;
        
        List<ValidatorError> errors = Validator.validate(mRequest, user.requiredParams());
        if (errors.isEmpty()) {
            user.fill(mRequest);
            service.update(user);
        } else {
            mRequest.setAttribute("errors", errors);
            route = "user_edit.jsp";
        }
        
        mRequest.getRequestDispatcher(route).forward(mRequest, mResponse);
    }

    @Override
    public void delete() throws ServletException, IOException {
        Integer id = Integer.valueOf(mRequest.getParameter("id"));
        
        service.delete(id);
        
        mRequest.getRequestDispatcher("User?action="+QueryHelper.INDEX).forward(mRequest, mResponse);
    }
}