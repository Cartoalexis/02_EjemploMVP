package com.example.a02_ejemplomvp.interactor;

import android.os.Handler;

import com.example.a02_ejemplomvp.interfaces.LoginInteractor;
import com.example.a02_ejemplomvp.interfaces.LoginPresentador;

public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void validarUsuario(String user, String pass, LoginPresentador presentador) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(user.equals("")){
                    presentador.setErrorUser();
                }
                else if(pass.equals("")){
                    presentador.setErrorPassword();
                }
                else{
                    if(user.equals("alexis") && pass.equals("123")){
                        presentador.exito();
                    }
                    else{
                        presentador.noExiste();
                    }
                }
            }
        }, 5000);


    }
}
