package com.example.medicell.vista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.medicell.R;
import com.example.medicell.modelo.Diagnostico;
import com.example.medicell.modelo.sintomas;
import com.loopj.android.http.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import cz.msebera.android.httpclient.Header;

import static com.android.volley.Response.*;

public class SintomasMainActivity extends AppCompatActivity {
    Spinner msintomas, msintomas1, msintomas2, msintomas3, msintomas4;
    List<String> listaSistomas;
    private AsyncHttpClient cliente;
    Button btnConsultar;
    private ArrayList<String> listarSintomas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView( R.layout.activity_sintomas_main);
        List<String> listarSintomas = null;
        List<String> listaSintomas = null;
        cliente = new AsyncHttpClient( );
        msintomas = (Spinner) findViewById(R.id.spinner);
        msintomas1 = (Spinner) findViewById(R.id.spinner1);
        msintomas2 = (Spinner) findViewById(R.id.spinner2);
        msintomas3 = (Spinner) findViewById(R.id.spinner3);
        msintomas4 = (Spinner) findViewById(R.id.spinner4);
        btnConsultar = (Button) findViewById(R.id.button_registrar);

        
        cargarSintomas();

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), DiagnosticoMainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("sintoma1", msintomas.getSelectedItem().toString());
                Bundle bundle1 = new Bundle();
                bundle1.putString("sintoma2", msintomas1.getSelectedItem().toString());
                Bundle bundle2 = new Bundle();
                bundle2.putString("sintoma3", msintomas2.getSelectedItem().toString());
                Bundle bundle3 = new Bundle();
                bundle3.putString("sintoma4", msintomas3.getSelectedItem().toString());
                Bundle bundle4 = new Bundle();
                bundle4.putString("sintoma5", msintomas4.getSelectedItem().toString());
                intent.putExtras(bundle);
                intent.putExtras(bundle1);
                intent.putExtras(bundle2);
                intent.putExtras(bundle3);
                intent.putExtras(bundle4);
                startActivity(intent);

            }
        });

    };

    public void cargarSintomas(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://pagpreview159.000webhostapp.com/obj/MetodosSintomas.php?funcion=obtenerSintomas";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.length() > 0){
                    try{
                        JSONArray jsonArray = new JSONArray(response);
                        obtenerSintomas(jsonArray);
                    }catch(JSONException jsnex1){
                        Toast.makeText(getApplicationContext(),jsnex1.toString()
                                ,Toast.LENGTH_LONG).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
            }
        });

        queue.add(stringRequest);
    }

    public void obtenerSintomas(JSONArray jsonArray){
        listaSistomas = new ArrayList<String>();
        listarSintomas = new ArrayList<String>();
        for(int i=0; i<jsonArray.length(); i++){
            try {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id_sintomas");
                String sintomas = jsonObject.getString("sintomas");
                listarSintomas.add(id);
                listaSistomas.add(sintomas);
            }catch (JSONException e) {
                e.printStackTrace();
            }

        }
        ArrayAdapter<String> adapterSintomas = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, listaSistomas);
        msintomas.setAdapter(adapterSintomas);
        msintomas1.setAdapter(adapterSintomas);
        msintomas2.setAdapter(adapterSintomas);
        msintomas3.setAdapter(adapterSintomas);
        msintomas4.setAdapter(adapterSintomas);

    }






}

