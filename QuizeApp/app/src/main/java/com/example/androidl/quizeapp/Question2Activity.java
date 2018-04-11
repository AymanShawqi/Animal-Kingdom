package com.example.androidl.quizeapp;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Question2Activity extends AppCompatActivity implements AnimalDictionary{
    private ImageView animalImage;
    private ImageView checkboxImage1;
    private ImageView checkboxImage2;
    private ImageView checkboxImage3;
    private ImageView checkboxImage4;
    private ImageView nextImage;
    private CheckBox q1CheckBox;
    private CheckBox q2CheckBox;
    private CheckBox q3CheckBox;
    private CheckBox q4CheckBox;
    private TextView checkTextView;
    private int idx=0;
    private int size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        initUI();
        size=AnimalDictionary.animalList.length;
        handleNextAnimal();
    }

    private void initUI(){
        animalImage=(ImageView)findViewById(R.id.q2_animal);
        q1CheckBox=(CheckBox) findViewById(R.id.checkbox1);;
        q2CheckBox=(CheckBox)findViewById(R.id.checkbox2);;
        q3CheckBox=(CheckBox)findViewById(R.id.checkbox3);;
        q4CheckBox=(CheckBox)findViewById(R.id.checkbox4);;
        checkboxImage1=(ImageView)findViewById(R.id.checkbox1_img);
        checkboxImage2=(ImageView)findViewById(R.id.checkbox2_img);
        checkboxImage3=(ImageView)findViewById(R.id.checkbox3_img);
        checkboxImage4=(ImageView)findViewById(R.id.checkbox4_img);
        nextImage=(ImageView)findViewById(R.id.next_icon);
        checkTextView=(TextView)findViewById(R.id.check_textview);
    }
    public void nextAnimal(View view){
        if(idx==size-1){
            nextImage.setVisibility(View.INVISIBLE);
            checkTextView.setVisibility(View.INVISIBLE);
            Toast.makeText(this,"End of Question 2",Toast.LENGTH_LONG).show();
            return;
        }

        else
            handleNextAnimal();
        q1CheckBox.setChecked(false);
        q2CheckBox.setChecked(false);
        q3CheckBox.setChecked(false);
        q4CheckBox.setChecked(false);
        checkboxImage1.setVisibility(View.INVISIBLE);
        checkboxImage2.setVisibility(View.INVISIBLE);
        checkboxImage3.setVisibility(View.INVISIBLE);
        checkboxImage4.setVisibility(View.INVISIBLE);
        nextImage.setVisibility(View.INVISIBLE);
    }
    private void handleNextAnimal(){
        animalImage.setImageResource(AnimalDictionary.animalList[idx].getResID());
        idx++;
    }

    public void checkQuestion2(View view){
        Animal animal=AnimalDictionary.animalList[idx-1];
        check(q1CheckBox,animal.isCheckboxQ1(),checkboxImage1);
        check(q2CheckBox,animal.isCheckboxQ2(),checkboxImage2);
        check(q3CheckBox,animal.isCheckboxQ3(),checkboxImage3);
        check(q4CheckBox,animal.isCheckboxQ4(),checkboxImage4);

        nextImage.setVisibility(View.VISIBLE);
    }

    private void check(CheckBox checkbox,boolean answer,ImageView image){
        boolean userAnswer=false;
        if(checkbox.isChecked())
            userAnswer=true;

        if(userAnswer==answer){
            image.setImageResource(R.drawable.right_answer);
        }
        else{
            image.setImageResource(R.drawable.wrong_answer);
        }
        image.setVisibility(View.VISIBLE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
