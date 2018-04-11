package com.example.androidl.quizeapp;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Question1Activity extends AppCompatActivity implements AnimalDictionary{

    private List<Integer> animalNumbers;
    private int idx=0;
    private ImageView image;
    private RadioButton option1RadioButton;
    private RadioButton option2RadioButton;
    private RadioButton option3RadioButton;
    private RadioButton option4RadioButton;
    private RadioGroup mQ1RadioGroup;
    private int size;
    private Animal currentAnimal;
    private ImageView nextImage;
    private int finalScore;
    private int score;
    private TextView scoreTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        //my code
        intitUI();
        size=AnimalDictionary.animalList.length;
        finalScore=size*4;
        score=finalScore;
        createAnimalNumbers();
        nextQuestion();
    }
    private void intitUI(){
        image=(ImageView)findViewById(R.id.q1_animal_image);
        option1RadioButton=(RadioButton)findViewById(R.id.q1_answer1);
        option2RadioButton=(RadioButton)findViewById(R.id.q1_answer2);
        option3RadioButton=(RadioButton)findViewById(R.id.q1_answer3);
        option4RadioButton=(RadioButton)findViewById(R.id.q1_answer4);
        mQ1RadioGroup=(RadioGroup)findViewById(R.id.q1_radioGroup);
       nextImage=(ImageView)findViewById(R.id.next_icon);
        scoreTextView=(TextView)findViewById(R.id.score_textView);
    }

    private void createAnimalNumbers(){
        animalNumbers=new ArrayList<>();
        for(int i=0;i<size;i++){
            animalNumbers.add(i);
        }
        Collections.shuffle(animalNumbers);
    }

    public void next(View view){
        if(idx==size-1){
            nextImage.setVisibility(View.INVISIBLE);
            String result="Your Score is "+score+"/"+finalScore;
            scoreTextView.setText(result.toString());
            scoreTextView.setVisibility(View.VISIBLE);
            return;
        }
        nextQuestion();
    }

    private void  nextQuestion(){
        currentAnimal=AnimalDictionary.animalList[animalNumbers.get(idx)];
        image.setImageResource(currentAnimal.getResID());
        changeRadioOPtion();
        changeRadioGroupState(true);
        mQ1RadioGroup.clearCheck();
        option1RadioButton.setBackgroundColor(Color.TRANSPARENT);
        option2RadioButton.setBackgroundColor(Color.TRANSPARENT);
        option3RadioButton.setBackgroundColor(Color.TRANSPARENT);
        option4RadioButton.setBackgroundColor(Color.TRANSPARENT);

        nextImage.setVisibility(View.INVISIBLE);
        idx++;
    }

    private void changeRadioOPtion(){
        List<String> options=new ArrayList<>();
        for(int j=idx;j< idx+4;j++){
        options.add(AnimalDictionary.animalList[animalNumbers.get(j%15)].getAnimalName());
        }
        Collections.shuffle(options);
        option1RadioButton.setText(options.get(0));
        option2RadioButton.setText(options.get(1));
        option3RadioButton.setText(options.get(2));
        option4RadioButton.setText(options.get(3));
    }

    public void checkAnswer(View view){
        RadioButton btn;
        String answer=currentAnimal.getAnimalName();
        btn=(RadioButton) findViewById(view.getId());
        String userAnswer=btn.getText().toString();
        if (answer.equals(userAnswer)){
             btn.setBackgroundResource(R.drawable.correct_border);
            changeRadioGroupState(false);
            nextImage.setVisibility(View.VISIBLE);
        }
        else
            btn.setBackgroundResource(R.drawable.incorrect_border);
            score--;
    }

    private void changeRadioGroupState(boolean isRadioBtnWork){
        for(int i=0;i<mQ1RadioGroup.getChildCount();i++)
            mQ1RadioGroup.getChildAt(i).setEnabled(isRadioBtnWork);
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
