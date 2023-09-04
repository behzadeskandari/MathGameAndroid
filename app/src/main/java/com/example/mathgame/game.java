package com.example.mathgame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class game extends AppCompatActivity {

    TextView score;
    TextView life;
    TextView time;

    TextView question;

    EditText answer;
    Button ok;
    Button nextQuestion;

    Random random = new Random();

    int number1;
    int number2;

    int userAnswer;
    int realAnswer;
    int userScore = 0;

    int userLife = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        score = findViewById(R.id.textViewScore);
        life = findViewById(R.id.textViewLife);
        time = findViewById(R.id.textViewSecond);

        question = findViewById(R.id.textViewQuestions);
        answer = findViewById(R.id.editTextAnswer);
        nextQuestion = findViewById(R.id.buttonNext);
        ok = findViewById(R.id.buttonOk);
        gameCountinue();

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    userAnswer = Integer.parseInt(answer.getText().toString());
                    if (userAnswer == realAnswer){
                        userScore = userScore + 10;
                        question.setText("Congrats your Answer Is True");
                        score.setText("" + userScore);
                    }else{
                        userLife = userLife - 1;
                        question.setText("Your Answer Is Wrong");
                        life.setText("" + userLife);
                    }
            }
        });

        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    public void gameCountinue(){
            number1 = random.nextInt(100);
            number2 = random.nextInt(100);
            realAnswer = number1 + number2;
            question.setText(number1 +" + "+ number2);
    }


}