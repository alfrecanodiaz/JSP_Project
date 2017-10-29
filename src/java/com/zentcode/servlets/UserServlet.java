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
import javax.servlet.http.HttpSession;

public class UserServlet extends HttpServlet implements Controller {
    
    UserService service;
    HttpServletResponse mResponse;
    HttpServletRequest mRequest;
    HttpSession session;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        mRequest = request;
        mResponse = response;
        session = request.getSession();
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public void index() throws ServletException, IOException {
        List<User> users = service.listAll();
        
        mRequest.setAttribute("users", users);

        mRequest.getRequestDispatcher("/pages/users/index.jsp").forward(mRequest, mResponse);
    }

    @Override
    public void create() throws ServletException, IOException {
        mRequest.getRequestDispatcher("/pages/users/create.jsp").forward(mRequest, mResponse);
    }

    @Override
    public void store() throws ServletException, IOException {
        User user = new User();
        
        List<ValidatorError> errors = Validator.validate(mRequest, user.requiredParams());
        if (errors.isEmpty()) {
            user.fill(mRequest);
            service.insert(user);
            session.setAttribute("success", "Usuario creado correctamente.");
            mResponse.sendRedirect(mRequest.getContextPath() + "/pages/user?action=index");
        } else {
            session.setAttribute("errors", errors);
            mRequest.getRequestDispatcher("/pages/users/create.jsp").forward(mRequest, mResponse);
        }
    }

    @Override
    public void edit() throws ServletException, IOException {
        Integer id = Integer.valueOf(mRequest.getParameter("id"));
        User user = service.findById(id);
        
        mRequest.setAttribute("user", user);
        
        mRequest.getRequestDispatcher("/pages/users/edit.jsp").forward(mRequest, mResponse);
    }

    @Override
    public void update() throws ServletException, IOException {
        User user = new User();
        
        List<ValidatorError> errors = Validator.validate(mRequest, user.requiredParams());
        if (errors.isEmpty()) {
            user.fill(mRequest);
            service.update(user);
            mResponse.sendRedirect(mRequest.getContextPath() + "/pages/user?action=index");
        } else {
            session.setAttribute("errors", errors);
            mRequest.getRequestDispatcher("/pages/users/edit.jsp").forward(mRequest, mResponse);
        }
    }

    @Override
    public void delete() throws ServletException, IOException {
        Integer id = Integer.valueOf(mRequest.getParameter("id"));
        
        service.delete(id);
        
        session.setAttribute("success", "Usuario eliminado correctamente.");
        
        mResponse.sendRedirect(mRequest.getContextPath() + "/pages/user?action=index");
    }   
}