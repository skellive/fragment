package com.example.medicell.controlador;



import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

        private static final String REGISTER_REQUEST_URL= "http://192.168.1.5:8080/medicellPDO/registro.php";
        private Map<String, String> params;
    public RegisterRequest(String nombre, String apellido, String usuario, String contrasenia, Response.Listener<String> listener){
            super(Method.POST, REGISTER_REQUEST_URL, listener, null);
            params= new HashMap<>();
            params.put("nombre", nombre);
            params.put("apellido", apellido);
            params.put("usuario", usuario);
        params.put("contrasenia", contrasenia);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
