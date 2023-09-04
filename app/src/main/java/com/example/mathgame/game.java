package com.example.mathgame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;
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
    int answerTrue;
    int userScore = 0;

    int userLife = 3;

    CountDownTimer timer ;
    private static  final long START_TIMER_IN_MILES = 10000;
    Boolean timer_running;
    long time_left_in_miles = START_TIMER_IN_MILES;
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
                    pauseTimer();
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
                answer.setText("");
                gameCountinue();
                resetTimer();

            }
        });

    }

    public void gameCountinue(){
            number1 = random.nextInt(100);
            number2 = random.nextInt(100);
            realAnswer = number1 + number2;
            question.setText(number1 +" + "+ number2);
            ///answerTrue = number1 + number2;
            ///startTimer();
            ///ok.setClickable(true);

            startTimer();
    }

    private void startTimer(){
        timer = new CountDownTimer(time_left_in_miles,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                time_left_in_miles = millisUntilFinished;
                updateText();
            }

            @Override
            public void onFinish() {
                timer_running = false;
                pauseTimer();
                resetTimer();
                updateText();
                userLife = userLife - 1;
                question.setText("Sorry! Time is Up!");
            }
        }.start();

        timer_running = true;
    }


    public void updateText(){
        int second = (int)(time_left_in_miles / 1000)%60;
        String time_left = String.format(Locale.getDefault(),"%02d",second);
        time.setText(time_left);
    }

    public void pauseTimer(){
        timer.cancel();
        timer_running = false;
    }

    public  void  resetTimer()
    {
        time_left_in_miles = START_TIMER_IN_MILES;
        updateText();
    }
}