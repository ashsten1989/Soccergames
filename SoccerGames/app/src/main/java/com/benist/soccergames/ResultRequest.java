package com.benist.soccergames;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

public class ResultRequest extends StringRequest {

    private static final String RESULT_REQUEST_URL = "https://cc112233.000webhostapp.com/ResultsData.php";
    private Map<String,String> params;

    public  ResultRequest(Response.Listener<String> listener){
        super(Method.POST, RESULT_REQUEST_URL, listener, null);
        params = new HashMap<>();

        }
    @Override
    public Map<String, String> getParams() {  return params;   }
}
