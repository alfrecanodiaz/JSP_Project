package com.zentcode.servlets;

import com.zentcode.dao.AuthImplement;
import com.zentcode.utils.Validator;
import com.zentcode.utils.ValidatorError;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    
    private final String LOGIN = "login";
    private final String LOGOUT = "logout";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AuthImplement service = new AuthImplement(request);
        if (service.check())
            response.sendRedirect("pages/home");
        else
            request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String route = "index.jsp";
        String required = "email, password";
        AuthImplement service = new AuthImplement(request);
        switch (request.getParameter("action")) {
            case LOGIN:
                Map<String, String> credentials = new HashMap<>();
                List<ValidatorError> errors = Validator.validate(request, required);
                if (errors.isEmpty()) {
                    credentials.put("email", request.getParameter("email"));
                    credentials.put("password", request.getParameter("password"));
                    if (service.auth(credentials)) {
                        route = "pages/home";
                    } else {
                        session.setAttribute("error", "Error al iniciar sesión, verifique su email y password.");
                    }
                } else {
                    session.setAttribute("errors", errors);
                }   
                break;
            case LOGOUT:
                service.logout();
                break;
        }
        
        response.sendRedirect(route);
    }
}