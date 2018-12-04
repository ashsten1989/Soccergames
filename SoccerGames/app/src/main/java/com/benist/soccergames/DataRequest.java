package com.benist.soccergames;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class DataRequest extends StringRequest {


    private static final String DATA_REQUEST_URL = "https://cc112233.000webhostapp.com/Data.php";
    private Map<String,String> params;

    public DataRequest(String field, Response.Listener<String> listener){
        super(Method.POST, DATA_REQUEST_URL, listener, null );
        params = new HashMap<>();
        params.put("field", field);
       // Log.i("params",params.toString());
    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
