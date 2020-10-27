package com.example.medicell.vista;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medicell.R;

public class EnfermedadesMainActivity extends AppCompatActivity {

    EditText edtUsuariofe;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_enfermedades_main);

        getSupportActionBar().hide();




    }


}
