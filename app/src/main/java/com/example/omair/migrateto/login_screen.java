package com.example.omair.migrateto;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login_screen extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText userName;
    private EditText pWord;
    private TextView status;
    private Button signup;

    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        mAuth = FirebaseAuth.getInstance();
        userName = findViewById(R.id.login_username);
        pWord = findViewById(R.id.login_password);
        status = findViewById(R.id.login_fail_box);
        signup = findViewById(R.id.button);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( login_screen.this, profile_info.class);
                startActivity(intent);
            }
        });

        final Button login_button = findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateForm()) {
                    return;
                }

                mAuth.signInWithEmailAndPassword(userName.getText().toString(), pWord.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent intent = new Intent( login_screen.this, intro.class);
                                    startActivity(intent);
                                }
                                if (!task.isSuccessful()) {
                                    status.setText("Login Failed");
                                }
                            }
                        });
                // [END sign_in_with_email]


            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent( login_screen.this, intro.class);
            startActivity(intent);

        }
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = userName.getText().toString();
        if (TextUtils.isEmpty(email)) {
            userName.setError("Required.");
            valid = false;
        } else {
            userName.setError(null);
        }

        String password = pWord.getText().toString();
        if (TextUtils.isEmpty(password)) {
            pWord.setError("Required.");
            valid = false;
        } else {
            pWord.setError(null);
        }

        return valid;
    }
}
