package com.example.androidl.quizeapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class Question3Activity extends AppCompatActivity{

    private ImageView animalImage;
    private ImageView nextImage;
    private ImageView signImage;
    private TextView checkTextView;
    private EditText input;
    private Animal animal;
    private int idx=0;
    private int size;
    private int score;
    private int finalScore;
    private  TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        initUI();
        size=AnimalDictionary.animalList.length;
        finalScore=size;
        handleNextAnimal();
    }

    private void initUI(){
        animalImage=(ImageView)findViewById(R.id.q3_animal_image);
        nextImage=(ImageView)findViewById(R.id.q3_next_icon);
        checkTextView=(TextView)findViewById(R.id.q3_check_textview);
        signImage=(ImageView)findViewById(R.id.answer_sign_img);
        input=(EditText)findViewById(R.id.input);
        scoreTextView=(TextView)findViewById(R.id.q3_score_textview);
    }

    public void q3NextAnimal(View view){
            handleNextAnimal();
    }

    private void handleNextAnimal(){
        animal=AnimalDictionary.animalList[idx];
        animalImage.setImageResource(animal.getResID());
        input.setText("");
        nextImage.setVisibility(View.INVISIBLE);
        signImage.setVisibility(View.INVISIBLE);
        input.setEnabled(true);
        checkTextView.setEnabled(true);
        idx++;
    }

    public void checkQuestion3(View view){
        String userInput=input.getText().toString().trim();
        String correctAnswer=animal.getAnimalName();
        if(userInput.equalsIgnoreCase(correctAnswer)){
            if(idx==size){
                scoreTextView.setVisibility(View.VISIBLE);
                checkTextView.setVisibility(View.INVISIBLE);
            } else {
                nextImage.setVisibility(View.VISIBLE);
            }
            signImage.setImageResource(R.drawable.right_answer);
            score++;
            checkTextView.setEnabled(false);
            input.setEnabled(false);
        }
        else
            signImage.setImageResource(R.drawable.wrong_answer);

        signImage.setVisibility(View.VISIBLE);
    }

    public void showQ3Score(View view){
        Resources res=getResources();
        String result=String.format(res.getString(R.string.question_result),score,finalScore);
        Toasty.Config.getInstance()
                .setSuccessColor(ContextCompat.getColor(this,R.color.colorAccent))
                .apply();
        Toasty.success(this,result,Toast.LENGTH_LONG).show();
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
