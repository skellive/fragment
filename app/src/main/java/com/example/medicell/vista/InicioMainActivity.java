package com.example.medicell.vista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medicell.R;

public class InicioMainActivity extends AppCompatActivity {
    Button mButtonSiguiente;
    EditText etUsuario, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_inicio_main);

        mButtonSiguiente = findViewById(R.id.button_Siguiente);
        etUsuario = findViewById(R.id.edittext_nombre);




        mButtonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SiguienteIntent = new Intent(InicioMainActivity.this, SintomasMainActivity.class);
                startActivity(SiguienteIntent);
            }
        });
    }


}