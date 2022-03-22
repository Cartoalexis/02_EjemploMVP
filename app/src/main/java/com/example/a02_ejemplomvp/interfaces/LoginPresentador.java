package com.example.a02_ejemplomvp.interfaces;

public interface LoginPresentador {

    void validarUsuario(String user, String pass);
    void setErrorUser();
    void setErrorPassword();
    void exito();
    void noExiste();

}
