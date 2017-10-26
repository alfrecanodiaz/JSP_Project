package com.zentcode.dao;

import com.zentcode.database.DatabaseConnection;
import com.zentcode.models.User;
import com.zentcode.services.AuthService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthImplement implements AuthService {
    
    private final DatabaseConnection dbconn;
    private final HttpServletRequest mRequest;
    
    public AuthImplement(HttpServletRequest request) {
        this.dbconn = new DatabaseConnection();
        this.mRequest = request;
    }

    @Override
    public boolean auth(Map<String, String> credentials) {
        User user = null;
        String email = credentials.get("email");
        String password = credentials.get("password");
        
        String sql = "SELECT id, nombre, direccion, telefono, celular, email, password FROM users WHERE email=? AND password=?";
        
        Connection conn = dbconn.getConnection();
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    user = new User();
                    user.setId(rs.getInt(1));
                    user.setNombre(rs.getString(2));
                    user.setDireccion(rs.getString(3));
                    user.setTelefono(rs.getString(4));
                    user.setCelular(rs.getString(5));
                    user.setEmail(rs.getString(6));
                    user.setPassword(rs.getString(7));
                }
                ps.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        } else {
            System.out.println("Error de conexión.");
        }
        
        if (user != null) {
            this.login(user);
            return true;
        }
        
        return false;
    }
    
    @Override
    public void login(User user) {
        HttpSession session = mRequest.getSession();
        session.setAttribute("user_logged", true);
        session.setAttribute("user", user);
    }

    @Override
    public void logout() {
        if (this.check())
            mRequest.getSession().invalidate();
    }

    @Override
    public User getCurrentAuth() {
        return (User) mRequest.getSession().getAttribute("user");
    }

    @Override
    public boolean check() {
        return (Boolean) mRequest.getSession().getAttribute("user_logged");
    }
}