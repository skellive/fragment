package com.example.medicell.vista;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.medicell.R;
import com.example.medicell.modelo.usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LoginMainActivity extends AppCompatActivity implements View.OnClickListener /*Response.Listener<JSONObject>, Response.ErrorListener*/{

   // RequestQueue rq;
    //JsonRequest jrq;

     EditText mTextUsuario, mTextPassword;
     Button mButtonIniciar, mButtonRegistro;
     CheckBox mRecord;
     String usuario, password;
     Context context = LoginMainActivity.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_login_main);
        mTextUsuario = (EditText) findViewById(R.id.edittext_usuario);
        mTextPassword = (EditText) findViewById(R.id.edittext_password);
        mButtonIniciar = (Button) findViewById(R.id.button_Iniciar);
        usuario = mTextUsuario.getText().toString();
        password = mTextPassword.getText().toString();
        //View vista = inflater.inflate(R.layout.activity_login_main, container, false);

        //rq = Volley.newRequestQueue(context);

        mButtonRegistro = (Button) findViewById(R.id.button_registrar);
        mButtonIniciar.setOnClickListener(this);
        mRecord= (CheckBox) findViewById(R.id.record);
        recuperarPreferencias();
        mButtonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginMainActivity.this, RegistroMain2Activity.class);
                startActivity(intent);
            }
        });

    }



    @Override
    public void onClick(View v) {
            Thread tr = new Thread(){
                @Override
                public void run() {
                    final String resultado = enviarDatosGET();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            int r = obDatosJSON(resultado);
                            if(r>0){
                                guardarPreferencias();
                                Intent i = new Intent(getApplicationContext(), InicioMainActivity.class);
                                i.putExtra("cod", mTextUsuario.getText().toString());

                                startActivity(i);
                                Toast.makeText(getApplicationContext(),"Bienvenido " + mTextUsuario.getText().toString(),Toast.LENGTH_LONG).show();
                                finish();
                            }else{


                                Toast.makeText(getApplicationContext(),"Usuario y/o contraseña incorrecta" + usuario,Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            };
            tr.start();
    }


    public String enviarDatosGET(){
        URL url = null;
        String linea="";
        int respuesta =0;
        StringBuilder resul=null;

        try {
            url = new URL("https://pagpreview159.000webhostapp.com/obj/Database.php?usuario="+mTextUsuario.getText().toString()+"&contrasenia="+mTextPassword.getText().toString());
            HttpURLConnection conection = (HttpURLConnection) url.openConnection();
            respuesta = conection.getResponseCode();

            resul = new StringBuilder();

            if(respuesta==HttpURLConnection.HTTP_OK){
                InputStream in = new BufferedInputStream(conection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                while((linea = reader.readLine())!= null){
                    resul.append(linea);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  resul.toString();
    }


    public int obDatosJSON(String response){
        int res = 0;
            try {
                JSONArray json=new JSONArray(response);
                if(json.length()>0){
                    res=1;
                }
            }catch (Exception e){

            }

        return res;
    }


    public void loguearCheckbox(View v) {
        String s = "Estado: " + (mRecord.isChecked() ? "Marcado" : "No Marcado");
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }




    private void guardarPreferencias(){
        SharedPreferences preferences = getSharedPreferences("preferenciasLogin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("usuario", mTextUsuario.getText().toString());
        editor.putString("password", mTextPassword.getText().toString());
        editor.putBoolean("session", true);
        editor.commit();

    }

    private void recuperarPreferencias(){
        SharedPreferences preferences = getSharedPreferences("preferenciasLogin", Context.MODE_PRIVATE);
        mTextUsuario.setText(preferences.getString("usuario", "desanchez"));
        mTextPassword.setText(preferences.getString("password", "hola"));
    }
}