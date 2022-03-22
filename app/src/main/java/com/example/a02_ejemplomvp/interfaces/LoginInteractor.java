package com.example.a02_ejemplomvp.interfaces;

public interface LoginInteractor {
    void validarUsuario(String user, String pass, LoginPresentador presentador);
}
