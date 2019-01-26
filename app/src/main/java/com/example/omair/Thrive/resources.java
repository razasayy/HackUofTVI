package com.example.omair.Thrive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class resources extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resources_homepage);

        ImageView local = findViewById(R.id.local_button);
        local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( resources.this, resources_local.class);
                startActivity(intent);
            }
        });

        ImageView national= findViewById(R.id.national_button);
        local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( resources.this, resources_homepage.class);
                startActivity(intent);
            }
        });
    }

}
