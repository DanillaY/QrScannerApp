package com.example.qrscannerapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;

import org.w3c.dom.Text;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    public String resposeField;
    private TextView login;
    private TextView password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        login = findViewById(R.id.Login);
        password = findViewById(R.id.Password);

    }
    @Override
    public void onClick(View view) {
        ApiRequest.GetResponse("http://192.168.1.152:8000/api/User/Authorization?login="+login+"&password="+password, Request.Method.POST,this);
        Toast.makeText(getBaseContext(), resposeField, Toast.LENGTH_SHORT).show();
        if(resposeField == "true") {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        else {
            //Toast.makeText(getBaseContext(), "Invalid credentials", Toast.LENGTH_SHORT).show();
        }

    }
}
