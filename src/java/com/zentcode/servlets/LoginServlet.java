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

public class LoginServlet extends HttpServlet {
    
    private final String LOGIN = "login";
    private final String LOGOUT = "logout";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getParameter("email"));
        System.out.println(request.getParameter("password"));
        String route = "login.jsp";
        String required = "email, password";
        AuthImplement service = new AuthImplement(request);
        switch (request.getParameter("action")) {
            case LOGIN:
                System.out.println("ENTRO EN EL LOGIN");
                Map<String, String> credentials = new HashMap<>();
                List<ValidatorError> errors = Validator.validate(request, required);
                if (errors.isEmpty()) {
                    System.out.println("NO TIENE ERRORES");
                    credentials.put("email", request.getParameter("email"));
                    credentials.put("password", request.getParameter("password"));
                    if (service.auth(credentials)) {
                        System.out.println("CREDENCIALES VALIDAS");
                        route = "pages/Home";
                    } else {
                        System.out.println("CREDENCIALES INVALIDAS");
                        request.setAttribute("error", "Error al iniciar sesión, verifique su email y password.");
                    }
                } else {
                    System.out.println("TIENE ERRORES");
                    request.setAttribute("errors", errors);
                }   
                break;
            case LOGOUT:
                service.logout();
                break;
        }
        
        response.sendRedirect(route);
//        request.getRequestDispatcher(route).forward(request, response);
    }
}