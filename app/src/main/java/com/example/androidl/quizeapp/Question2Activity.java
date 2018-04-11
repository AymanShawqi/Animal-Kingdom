package com.example.androidl.quizeapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class Question2Activity extends AppCompatActivity {

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
    private TextView scoreTextView;
    private Animal animal;
    private int idx=0;
    private int size;
    private int score;
    private int finalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        initUI();
        size=AnimalDictionary.animalList.length;
        finalScore=4*size;
        handleNextAnimal();
    }

    private void initUI(){
        animalImage=(ImageView)findViewById(R.id.q2_animal);
        q1CheckBox=(CheckBox) findViewById(R.id.checkbox1);
        q2CheckBox=(CheckBox)findViewById(R.id.checkbox2);
        q3CheckBox=(CheckBox)findViewById(R.id.checkbox3);
        q4CheckBox=(CheckBox)findViewById(R.id.checkbox4);
        checkboxImage1=(ImageView)findViewById(R.id.checkbox1_img);
        checkboxImage2=(ImageView)findViewById(R.id.checkbox2_img);
        checkboxImage3=(ImageView)findViewById(R.id.checkbox3_img);
        checkboxImage4=(ImageView)findViewById(R.id.checkbox4_img);
        nextImage=(ImageView)findViewById(R.id.next_icon);
        checkTextView=(TextView)findViewById(R.id.check_textview);
        scoreTextView=(TextView)findViewById(R.id.q2_score_textview);
    }

    public void nextAnimal(View view){
            handleNextAnimal();
    }

    private void handleNextAnimal(){
        animal=AnimalDictionary.animalList[idx];
        animalImage.setImageResource(animal.getResID());
        clearCheckBox(true);
        enableCheckboxes(true);
        setSignVisibility(View.INVISIBLE);
        nextImage.setVisibility(View.INVISIBLE);
        idx++;
    }

    public void checkQuestion2(View view){
        check(q1CheckBox,animal.isCheckboxQ1(),checkboxImage1);
        check(q2CheckBox,animal.isCheckboxQ2(),checkboxImage2);
        check(q3CheckBox,animal.isCheckboxQ3(),checkboxImage3);
        check(q4CheckBox,animal.isCheckboxQ4(),checkboxImage4);
        if(idx==size-1){
            nextImage.setVisibility(View.INVISIBLE);
            checkTextView.setVisibility(View.INVISIBLE);
            scoreTextView.setVisibility(View.VISIBLE);
        } else {
            nextImage.setVisibility(View.VISIBLE);
        }

        enableCheckboxes(false);
    }

    private void check(CheckBox checkbox,boolean answer,ImageView image){
        boolean userAnswer=false;
        if(checkbox.isChecked())
            userAnswer=true;

        if(userAnswer==answer){
            image.setImageResource(R.drawable.right_answer);
            image.setContentDescription(getResources().getText(R.string.correct_answer));
            score++;
        } else {
            image.setImageResource(R.drawable.wrong_answer);
            image.setContentDescription(getResources().getText(R.string.wrong_answer));
        }
        image.setVisibility(View.VISIBLE);
    }

    private  void setSignVisibility(int flag){
        if(flag==View.INVISIBLE || flag==View.VISIBLE){
            checkboxImage1.setVisibility(flag);
            checkboxImage2.setVisibility(flag);
            checkboxImage3.setVisibility(flag);
            checkboxImage4.setVisibility(flag);
        }
    }

    private  void clearCheckBox(boolean flag){
        flag = !flag;
        q1CheckBox.setChecked(flag);
        q2CheckBox.setChecked(flag);
        q3CheckBox.setChecked(flag);
        q4CheckBox.setChecked(flag);
    }

    private  void enableCheckboxes(boolean flag){
        q1CheckBox.setEnabled(flag);
        q2CheckBox.setEnabled(flag);
        q3CheckBox.setEnabled(flag);
        q4CheckBox.setEnabled(flag);
    }

    public void showQ2Score(View view){
        Resources res=getResources();
        String result=String.format(res.getString(R.string.question_result),score,finalScore);
        Toasty.Config.getInstance()
                .setSuccessColor(ContextCompat.getColor(this,R.color.colorAccent))
                .setErrorColor(ContextCompat.getColor(this, R.color.red))
                .apply();
        if(score>=finalScore / 2)
            Toasty.success(this,result,Toast.LENGTH_LONG).show();
        else
            Toasty.error(this,result,Toast.LENGTH_LONG).show();
    }

    //menu
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
