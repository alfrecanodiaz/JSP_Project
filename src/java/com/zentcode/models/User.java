package com.zentcode.models;

import com.zentcode.illuminate.Model;
import com.zentcode.utils.PasswordHashing;
import javax.servlet.http.HttpServletRequest;

public class User implements Model {

    private Integer id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String celular;
    private String email;
    private String password;

    public User() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", celular=" + celular + ", email=" + email + ", password=" + password + '}';
    }
    
    @Override
    public String requiredParams() {
        return "nombre, direccion, telefono, email, password";
    }

    @Override
    public void fill(HttpServletRequest request) {
        if (request.getParameter("id") != null)
            this.id = Integer.valueOf(request.getParameter("id"));
        this.nombre = request.getParameter("nombre");
        this.direccion = request.getParameter("direccion");
        this.telefono = request.getParameter("telefono");
        this.celular = request.getParameter("celular");
        this.email = request.getParameter("email");
        if (request.getParameter("password") != null && !request.getParameter("password").isEmpty())
            this.password = PasswordHashing.generateHash(request.getParameter("password"));
    }
}