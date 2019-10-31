package com.theraza.idn.redone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

        Button btnGoogle = findViewById(R.id.btn_loggoogle);
        btnGoogle.setOnClickListener(this);

        TextView signup = findViewById(R.id.tv_signup);
        signup.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                Intent intent = new Intent(MainActivity.this, ToFragmentActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_signup:
                Intent intent1 = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_loggoogle:
                Intent intent2 = new Intent(MainActivity.this, GoogleActivity.class);
                startActivity(intent2);
        }

    }
}