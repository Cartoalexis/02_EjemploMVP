package com.example.a02_ejemplomvp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.a02_ejemplomvp.R;
import com.example.a02_ejemplomvp.interfaces.LoginPresentador;
import com.example.a02_ejemplomvp.interfaces.LoginView;
import com.example.a02_ejemplomvp.presenter.LoginPresentadorImpl;

public class Login extends AppCompatActivity implements LoginView {

    EditText txtUsuario, txtContrasena;
    Button btnLogin;
    ProgressBar barraProgreso;

    LoginPresentador presentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsuario = findViewById(R.id.txtUsuario);
        txtContrasena = findViewById(R.id.txtContrasena);
        btnLogin = findViewById(R.id.btnLogin);
        barraProgreso = findViewById(R.id.barraProgreso);

        presentador = new LoginPresentadorImpl(this);
    }

    @Override
    public void mostrarProgreso() {
        barraProgreso.setVisibility(View.VISIBLE);
    }

    @Override
    public void esconderProgreso() {
        barraProgreso.setVisibility(View.GONE);
    }

    @Override
    public void setErrorUser() {
        txtUsuario.setError("Campo 'usuario' obligatorio");
    }

    @Override
    public void setErrorPassword() {
        txtContrasena.setError("Campo ´contrasela' obligatorio");
    }

    @Override
    public void exito() {
        startActivity(new Intent(this, Actividad2.class));
    }

    @Override
    public void noExiste() {
        Toast.makeText(this, "La cuenta no existe", Toast.LENGTH_SHORT).show();
    }

    public void solicitarValidacion(View view){
        presentador.validarUsuario(txtUsuario.getText().toString(),txtContrasena.getText().toString());
    }
}