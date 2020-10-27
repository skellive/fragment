package com.example.medicell.modelo;

public class usuario {
    String nombre;
    String usuario;
    String contrasenia;
    String correo;

    public usuario(String usuario, String contrasenia){
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.correo = correo;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
