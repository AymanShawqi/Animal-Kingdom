package com.example.androidl.quizeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Question3Activity extends AppCompatActivity implements AnimalDictionary{

    private ImageView animalImage;
    private ImageView nextImage;
    private ImageView signImage;
    private TextView checkTextView;
    private EditText input;
    private Animal animal;
    private int idx=0;
    private int size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        initUI();
        size=AnimalDictionary.animalList.length;
        handleNextAnimal();
    }

    private void initUI(){
        animalImage=(ImageView)findViewById(R.id.q3_animal_image);
        nextImage=(ImageView)findViewById(R.id.q3_next_icon);
        checkTextView=(TextView)findViewById(R.id.q3_check_textview);
        signImage=(ImageView)findViewById(R.id.answer_sign_img);
        input=(EditText)findViewById(R.id.input);
    }
    public void q3NextAnimal(View view){
        if(idx==size-1){
            nextImage.setVisibility(View.INVISIBLE);
            checkTextView.setVisibility(View.INVISIBLE);
            Toast.makeText(this,"End of Question 3",Toast.LENGTH_LONG).show();
        }
        else
            handleNextAnimal();
    }
    private void handleNextAnimal(){
        animal=AnimalDictionary.animalList[idx];
        animalImage.setImageResource(animal.getResID());
        nextImage.setVisibility(View.INVISIBLE);
        signImage.setVisibility(View.INVISIBLE);
        idx++;
    }

    public void checkQuestion3(View view){
        animal=AnimalDictionary.animalList[idx-1];
        String userInput=input.getText().toString().trim();
        String correctAnswer=animal.getAnimalName();
        if(userInput.equalsIgnoreCase(correctAnswer))
            signImage.setImageResource(R.drawable.right_answer);
        else
            signImage.setImageResource(R.drawable.wrong_answer);

        signImage.setVisibility(view.VISIBLE);
        nextImage.setVisibility(View.VISIBLE);
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
