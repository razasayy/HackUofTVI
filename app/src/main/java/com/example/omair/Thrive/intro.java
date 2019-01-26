package com.example.omair.Thrive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class intro extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private TextView randomfact;
    private TextView randomtrans;
    private TextView userName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        randomfact = findViewById(R.id.textView2);
        randomtrans = findViewById(R.id.textView3);
        userName = findViewById(R.id.textView4);




    }
}
