package com.example.qrscannerapp;

import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class ApiRequest extends AppCompatActivity {
    public static void GetResponse(String url,int requestFormat,LoginActivity context)
    {
        JsonObjectRequest js = new JsonObjectRequest(requestFormat, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                context.resposeField = response.toString();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //responseField = "error";
            }
        });
        RequestQueue rq = Volley.newRequestQueue(context);
        rq.add(js);
    }
}
