package com.example.a02_ejemplomvp.interfaces;

public interface LoginView {
    void mostrarProgreso();
    void esconderProgreso();
    void setErrorUser();
    void setErrorPassword();
    void exito();
    void noExiste();
}
