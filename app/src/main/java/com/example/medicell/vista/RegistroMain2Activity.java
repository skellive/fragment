package com.example.medicell.vista;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.medicell.R;
import com.example.medicell.controlador.RegisterRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class RegistroMain2Activity extends AppCompatActivity {
    private EditText mTextNombre, mTextApellido, mTextUsuario, mTextPassword, mTextConfPassword;
    private Button mButtonRegistrar, mButtonIniciar;
    private Spinner spinnerSex;
    private CheckBox mRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_main2);

        mTextNombre = (EditText) findViewById(R.id.edittext_nombre);
        mTextApellido = (EditText) findViewById(R.id.edittext_apellido);
        mTextUsuario = (EditText) findViewById(R.id.edittext_usuario);
        mTextPassword = (EditText) findViewById(R.id.edittext_password);
        mTextConfPassword = (EditText) findViewById(R.id.edittext_conf_password);
        mButtonRegistrar = (Button) findViewById(R.id.button_registrar);
        mButtonIniciar = (Button) findViewById(R.id.button_Iniciar);
        mRecord = (CheckBox) findViewById(R.id.record);
        spinnerSex = (Spinner) findViewById(R.id.spinnerSex);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.combosex, android.R.layout.simple_spinner_item);
        spinnerSex.setAdapter(adapter);
        mButtonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mTextNombre.getText().toString().equals("") || mTextApellido.getText().toString().equals("") || mTextPassword.getText().toString().equals("") || mTextConfPassword.getText().toString().equals("")){
                    Toast.makeText(RegistroMain2Activity.this, "Ingrese todos los campos", Toast.LENGTH_SHORT).show();
                }else{
                    if(mTextPassword.getText().toString().equals(mTextConfPassword.getText().toString())){
                        ejecutarServicio("https://pagpreview159.000webhostapp.com/obj/registro.php?");
                        Intent i = new Intent(RegistroMain2Activity.this, LoginMainActivity.class);
                        startActivity(i);
                    }else {
                        Toast.makeText(RegistroMain2Activity.this, "Error. Contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        mButtonIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegistroMain2Activity.this, LoginMainActivity.class);
                startActivity(i);
            }
        });

    }


       private void ejecutarServicio(String URL){
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(RegistroMain2Activity.this, "Registrado con exito", Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(RegistroMain2Activity.this, "Error al registrar" +error, Toast.LENGTH_SHORT).show();
                    Log.e(null, "error: " + error);
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> parametro = new HashMap<String, String>();
                    parametro.put("nombre", mTextNombre.getText().toString());
                    parametro.put("apellido", mTextApellido.getText().toString());
                    parametro.put("usuario", mTextUsuario.getText().toString());
                    parametro.put("contrasenia", mTextPassword.getText().toString());
                    parametro.put("sexo", spinnerSex.getSelectedItem().toString());
                    return parametro;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(RegistroMain2Activity.this);
            requestQueue.add(stringRequest);
        }




        public void loguearCheckbox(View v) {
            String s = "Estado: " + (mRecord.isChecked() ? "Marcado" : "No Marcado");
            Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        }
    }

