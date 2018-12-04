package com.benist.soccergames;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class teamsrequest extends StringRequest {

    private static final String LOGIN_REQUEST_URL = "https://cc112233.000webhostapp.com/Datatogetteams.php";
    private static final String TEAM_URL = "https://cc112233.000webhostapp.com/Teams.php";

    private Map<String,String> params;

    public  teamsrequest(Response.Listener<String> listener){
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();

    }

    public  teamsrequest(String teamA,String teamB, int goalsA ,int goalsB,String Winner ,Response.Listener<String> listener){
        super(Method.POST, TEAM_URL, listener, null);
        params = new HashMap<>();
        params.put("teamA", teamA);
        params.put("teamB", teamB);
        params.put("goalsA", goalsA + "");
        params.put("goalsB", goalsB + "");
        params.put("Winner", Winner);
    }





    @Override
    public Map<String, String> getParams() {

        return params;
    }


}
