package com.example.androidl.quizeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openLearning(View view){
        Intent intent=new Intent(this,LearningActivity.class);
        startActivity(intent);
    }

    public void openQ1(View view){
        Intent intent=new Intent(this,Question1Activity.class);
        startActivity(intent);
    }

    public void openQ2(View view){
        Intent intent=new Intent(this,Question2Activity.class);
        startActivity(intent);
    }

    public void openQ3(View view){
        Intent intent=new Intent(this,Question3Activity.class);
        startActivity(intent);
    }
}
