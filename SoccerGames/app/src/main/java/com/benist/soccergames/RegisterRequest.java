package com.benist.soccergames;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "https://cc112233.000webhostapp.com/Register.php";
    private Map<String,String> params;

    public  RegisterRequest(String field, String team,String rule , int hours, int age, String username, String password, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("field", field);
        params.put("team", team);
        params.put("rule", rule);
        params.put("hours", hours + "");
        params.put("age", age + "");
        params.put("username", username);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }



}
