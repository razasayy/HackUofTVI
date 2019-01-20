package com.example.omair.migrateto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class profile_info extends AppCompatActivity {
    private Button existing;
    private Button done;
    private EditText language;
    private EditText email;
    private EditText pWord;
    private EditText pWord2;
    private EditText Name;
    private EditText City;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_info);
        existing = findViewById(R.id.existing_user_button);
        done = findViewById(R.id.done_button);
        language = findViewById(R.id.language_input);
        email = findViewById(R.id.username_input);
        pWord = findViewById(R.id.password_input);
        pWord2 = findViewById(R.id.re_enter_password_input);
        Name = findViewById(R.id.full_name_input);
        City = findViewById(R.id.new_city_input);
        mAuth = FirebaseAuth.getInstance();


        existing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateForm()) {
                    return;
                }


            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent( profile_info.this, intro.class);
            startActivity(intent);

        }
    }

    private boolean validateForm() {
        boolean valid = true;

        String emailt = email.getText().toString();
        if (TextUtils.isEmpty(emailt)) {
            email.setError("Required.");
            valid = false;
        } else {
            email.setError(null);
        }

        String password = pWord.getText().toString();
        String password2 = pWord2.getText().toString();
        if (TextUtils.isEmpty(password)) {
            pWord.setError("Required.");
            valid = false;
        }
        else if(!password.equals(password2)){
            pWord2.setError("Passwords Different");
            valid = false;
        } else {
            pWord.setError(null);
        }

        return valid;
    }

}
