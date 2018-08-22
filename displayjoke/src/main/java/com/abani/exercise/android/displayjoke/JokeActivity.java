package com.abani.exercise.android.displayjoke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView textView = findViewById(R.id.text_joke);

        Intent intent = getIntent();
        if (intent != null){
            textView.setText(intent.getStringExtra("my_joke"));
        }
    }
}