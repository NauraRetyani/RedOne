package com.theraza.idn.redone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button next = findViewById(R.id.btn_next);
        next.setOnClickListener(this);


        TextView login = findViewById(R.id.tv_login);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_next:
                Intent intent = new Intent(SignUpActivity.this, PhoneActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_login:
                Intent intent1 = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent1);
                break;


        }
    }
}