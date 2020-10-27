package com.example.medicell.vista;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.medicell.R;
import com.example.medicell.controlador.AdapterLocal;
import com.example.medicell.controlador.AdapterServidor;
import com.example.medicell.controlador.AdminSQLiteOpenHelper;
import com.example.medicell.modelo.Diagnostico;
import com.example.medicell.modelo.diagnostico_user;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagnosticoMainActivity extends AppCompatActivity {


    Button btnSync, btnAgregar, btnSiguiente;
    EditText edtsintoma1, edtsintoma2, edtsintoma3, edtsintoma4, edtsintoma5;
    EditText sint1, sint2, sint3, sint4, sint5;

    RecyclerView rvServidor, rvLocal;

    List<Diagnostico> listaServidor = new ArrayList<>();
    List<Diagnostico> listaLocal = new ArrayList<>();

    AdapterServidor adapterServidor;
    AdapterLocal adapterLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostico_main);
        getSupportActionBar().hide();

        edtsintoma1 = findViewById(R.id.edtsintoma1);
        edtsintoma2 = findViewById(R.id.edtSintoma2);
        edtsintoma3 = findViewById(R.id.edtSintoma3);
        edtsintoma4 = findViewById(R.id.edtSintoma4);
        edtsintoma5 = findViewById(R.id.edtSintoma5);
        rvLocal = findViewById(R.id.rv_diagnostico);
        rvLocal.setLayoutManager(new GridLayoutManager(this, 1));
        btnSync = findViewById(R.id.id_syncViEnf);
        btnAgregar = findViewById(R.id.guardar_datos);
        btnSiguiente = findViewById(R.id.btnenfermedades);

        Bundle bundle = this.getIntent().getExtras();

        String sintoma1 = bundle.getString("sintoma1");
        String sintoma2 = bundle.getString("sintoma2");
        String sintoma3 = bundle.getString("sintoma3");
        String sintoma4 = bundle.getString("sintoma4");
        String sintoma5 = bundle.getString("sintoma5");

        edtsintoma1.setText(sintoma1);
        edtsintoma2.setText(sintoma2);
        edtsintoma3.setText(sintoma3);
        edtsintoma4.setText(sintoma4);
        edtsintoma5.setText(sintoma5);





        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EnfermedadesMainActivity.class);
                startActivity(intent);
            }
        });

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarSintomas(edtsintoma1.getText().toString(), edtsintoma2.getText().toString(), edtsintoma3.getText().toString(), edtsintoma4.getText().toString(), edtsintoma5.getText().toString());
            }
        });




    }


    public void sincronizar() {
        JSONArray jsonArrayProducto = new JSONArray();
        for(int i = 0 ; i < listaLocal.size() ; i++) {
            JSONObject jsonObjectProducto = new JSONObject();
            try {
                jsonObjectProducto.put("sintomas_presentados", listaLocal.get(i).getSintomas_presentados());


            } catch (JSONException e) {
                e.printStackTrace();
            }
            jsonArrayProducto.put(jsonObjectProducto);
        }
        JSONObject json = new JSONObject();
        try {
            json.put("sintomas_presentados", jsonArrayProducto);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String jsonStr = json.toString();
        registrarServidor(jsonStr);
    }

    public void registrarServidor(final String json) {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://pagpreview159.000webhostapp.com/obj/RegistrarDiagnostico.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("OK")) {
                    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), "medicell", null, 1);
                    SQLiteDatabase db = admin.getWritableDatabase();
                    admin.onCreate(db);


                    obtencionSintomas();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("json", json);

                return params;
            }
        };

        requestQueue.add(stringRequest);
    }

    private void obtencionSintomas() {
        listaLocal.clear();

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), "medicell", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Cursor fila = db.rawQuery("select * from sintomas", null);
        if (fila != null && fila.getCount() != 0) {
            fila.moveToFirst();
            do {
                listaLocal.add(
                        new Diagnostico(
                                fila.getString(0),
                                fila.getString(1),
                                fila.getString(2),
                                fila.getString(3),
                                fila.getString(4)

                        )
                );
            } while (fila.moveToNext());

            adapterLocal = new AdapterLocal(getApplicationContext(), listaLocal);
            rvLocal.setAdapter(adapterLocal);
        } else {
            adapterLocal = new AdapterLocal(getApplicationContext(), listaLocal);
            rvLocal.setAdapter(adapterLocal);
            Toast.makeText(this, "No hay registros", Toast.LENGTH_SHORT).show();
        }

        db.close();

    }

    public void agregarSintomas(String s1, String s2, String s3, String s4, String s5){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), "medicell", null, 1);

        SQLiteDatabase db = admin.getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put("sintomas_presentados", s1);
        registro.put("sintomas_presentados", s2);
        registro.put("sintomas_presentados", s3);
        registro.put("sintomas_presentados", s4);
        registro.put("sintomas_presentados", s5);


        db.insert("sintomas", null, registro);


        db.close();

        obtencionSintomas();

    }


}

