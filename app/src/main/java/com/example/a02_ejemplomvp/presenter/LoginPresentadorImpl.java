package com.example.a02_ejemplomvp.presenter;

import com.example.a02_ejemplomvp.interactor.LoginInteractorImpl;
import com.example.a02_ejemplomvp.interfaces.LoginInteractor;
import com.example.a02_ejemplomvp.interfaces.LoginPresentador;
import com.example.a02_ejemplomvp.interfaces.LoginView;

public class LoginPresentadorImpl implements LoginPresentador {

    LoginView vista;
    LoginInteractor interactor;

    public LoginPresentadorImpl(LoginView vista) {
        this.vista = vista;
        interactor = new LoginInteractorImpl();
    }


    @Override
    public void validarUsuario(String user, String pass) {
        if(vista != null){
            vista.mostrarProgreso();
        }
        interactor.validarUsuario(user,pass, this);
    }

    @Override
    public void setErrorUser() {
        if(vista != null){
            vista.esconderProgreso();
            vista.setErrorUser();
        }

    }

    @Override
    public void setErrorPassword() {
        if(vista != null){
            vista.esconderProgreso();
            vista.setErrorPassword();
        }
    }

    @Override
    public void exito() {
        if(vista != null){
            vista.esconderProgreso();
            vista.exito();
        }
    }

    @Override
    public void noExiste() {
        vista.noExiste();
        vista.esconderProgreso();
    }
}
