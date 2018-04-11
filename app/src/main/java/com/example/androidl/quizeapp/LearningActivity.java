package com.example.androidl.quizeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LearningActivity extends AppCompatActivity implements AnimalDictionary{

    private Animal[] animalArray=AnimalDictionary.animalList;
    private int idx;
    private int animalNumber;
    private ImageView animalImage;
    private TextView animalName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);
        //my code
        animalNumber=animalArray.length;
        animalImage=(ImageView) findViewById(R.id.animal_image);
        animalName=(TextView) findViewById(R.id.animal_name);
    }

    private void display(){
        animalName.setText(animalArray[idx].getAnimalName());
        animalImage.setImageResource(animalArray[idx].getResID());
    }

    public void next(View view){
        if(idx==animalNumber-1){
            Toast.makeText(this,"This is the last animal",Toast.LENGTH_SHORT).show();
        } else {
            idx++;
            display();
        }
    }

    public void previous(View view){
        if(idx==0){
            Toast.makeText(this,"This is the first animal",Toast.LENGTH_SHORT).show();
        } else {
            idx--;
            display();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                finish();
                default:
                    return super.onOptionsItemSelected(item);
        }

    }
}
