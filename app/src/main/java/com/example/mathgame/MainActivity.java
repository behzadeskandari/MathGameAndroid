package com.example.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button addtion;
    Button subtraction;
    Button multi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addtion = findViewById(R.id.buttonAdd);
        subtraction = findViewById(R.id.buttonSub);
        multi = findViewById(R.id.butttonMulti);

        addtion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,game.class);
                startActivity(intent);

            }
        });

    }
}