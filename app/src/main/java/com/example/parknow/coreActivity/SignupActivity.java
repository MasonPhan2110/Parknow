package com.example.parknow.coreActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.parknow.R;
import com.example.parknow.controller.auth;
import com.example.parknow.extend.BaseActivity;

public class SignupActivity extends BaseActivity {
    EditText email,phone,pass,vehicles,vehicles_plates, username;
    TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Window window = SignupActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(SignupActivity.this.getResources().getColor(R.color.green));
        window.setNavigationBarColor(SignupActivity.this.getResources().getColor(R.color.green));

        //Edit text
        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        phone = findViewById(R.id.phone);
        pass = findViewById(R.id.pass);
        vehicles = findViewById(R.id.vehicles);
        vehicles_plates = findViewById(R.id.vehicles_plates);
        //Text view
        signup = findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth fauth = new auth(email.getText().toString(),pass.getText().toString(),SignupActivity.this);
                fauth.signup(username.getText().toString(),phone.getText().toString(),vehicles.getText().toString(),vehicles_plates.getText().toString());
            }
        });
    }

//    @Override
//    protected void onShowKeyboard(int keyboardHeight) {
//        super.onShowKeyboard(keyboardHeight);
//        signup.setVisibility(View.VISIBLE);
//    }
//
//    @Override
//    protected void onHideKeyboard() {
//        super.onHideKeyboard();
//    }
}