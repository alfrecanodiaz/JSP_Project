package com.zentcode.dao;

import com.zentcode.database.DatabaseConnection;
import com.zentcode.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import com.zentcode.services.UserService;
import java.sql.SQLException;

public class UserImplement implements UserService {

    private final DatabaseConnection dbconn;
    private String message;
    
    public UserImplement() {
        this.dbconn = new DatabaseConnection();
    }

    @Override
    public List<User> listAll() {
        List<User> list = null;
        
        String sql = "SELECT id, nombre, direccion, telefono, celular, email, password FROM users";
        
        Connection conn = dbconn.getConnection();
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                list = new LinkedList<>();
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt(1));
                    user.setNombre(rs.getString(2));
                    user.setDireccion(rs.getString(3));
                    user.setTelefono(rs.getString(4));
                    user.setCelular(rs.getString(5));
                    user.setEmail(rs.getString(6));
                    user.setPassword(rs.getString(7));
                    list.add(user);
                }
                ps.close();
            } catch (SQLException e) {
                setMessage("Error listAll: " + e.getMessage());
                System.out.println(getMessage());
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    setMessage(e.getMessage());
                    System.out.println(getMessage());
                }
            }
        } else {
            setMessage("Error de conexión: " + dbconn.getMessage());
            System.out.println(getMessage());
        }
        
        return list;
    }

    @Override
    public Long insert(User user) {
        String sql = "INSERT INTO users(nombre, direccion, telefono, celular, email, password) VALUES(?,?,?,?,?,?)";
        long id = 0;
        
        Connection conn = dbconn.getConnection();
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                
                ps.setString(1, user.getNombre());
                ps.setString(2, user.getDireccion());
                ps.setString(3, user.getTelefono());
                ps.setString(4, user.getCelular());
                ps.setString(5, user.getEmail());
                ps.setString(6, user.getPassword());
                
                int affectedRows = ps.executeUpdate();
                
                if (affectedRows == 0)
                    throw new SQLException();
                
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next())
                        id = generatedKeys.getLong(1);
                    else
                        throw new SQLException("Insert user error, ningun ID obtenido");
                }
                
                ps.close();
            } catch (SQLException e) {
                setMessage("Error insert: " + e.getMessage());
                System.out.println(getMessage());
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    setMessage(e.getMessage());
                    System.out.println(getMessage());
                }
            }
        } else {
            setMessage("Error de conexión: " + dbconn.getMessage());
            System.out.println(getMessage());
        }
        
        return id;
    }

    @Override
    public User findById(Integer id) {
        User user = null;
        
        String sql = "SELECT id, nombre, direccion, telefono, celular, email, password FROM users WHERE id=?";
        
        Connection conn = dbconn.getConnection();
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
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
                setMessage("Error findById: " + e.getMessage());
                System.out.println(getMessage());
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    setMessage(e.getMessage());
                    System.out.println(getMessage());
                }
            }
        } else {
            setMessage("Error de conexión: " + dbconn.getMessage());
            System.out.println(getMessage());
        }
        
        return user;
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET nombre=?, direccion=?, telefono=?, celular=?, email=?, password=? WHERE id=?";
        
        Connection conn = dbconn.getConnection();
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, user.getNombre());
                ps.setString(2, user.getDireccion());
                ps.setString(3, user.getTelefono());
                ps.setString(4, user.getCelular());
                ps.setString(5, user.getEmail());
                ps.setString(6, user.getPassword());
                ps.setInt(7, user.getId());
                
                int affectedRows = ps.executeUpdate();
                
                if (affectedRows == 0)
                    throw new SQLException();
                
                ps.close();
            } catch (SQLException e) {
                setMessage("Error update: " + e.getMessage());
                System.out.println(getMessage());
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    setMessage(e.getMessage());
                    System.out.println(getMessage());
                }
            }
        } else {
            setMessage("Error de conexión: " + dbconn.getMessage());
            System.out.println(getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM users WHERE id=?";
        
        Connection conn = dbconn.getConnection();
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                
                int affectedRows = ps.executeUpdate();
                
                if (affectedRows == 0)
                    throw new SQLException();
                
                ps.close();
            } catch (SQLException e) {
                setMessage("Error delete: " + e.getMessage());
                System.out.println(getMessage());
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    setMessage(e.getMessage());
                    System.out.println(getMessage());
                }
            }
        } else {
            setMessage("Error de conexión: " + dbconn.getMessage());
            System.out.println(getMessage());
        }
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}