package com.example.logica;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private TextView mA1;
    private TextView mA2;
    private TextView mA3;
    private TextView mA4;
    private TextView mB1;
    private TextView mB2;
    private TextView mB3;
    private TextView mB4;
    private TextInputEditText mInput1;
    private TextInputEditText mInput2;
    private TextInputEditText mInput3;
    private TextInputEditText mInput4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mA1 = findViewById(R.id.textA1);
        mA2 = findViewById(R.id.textA2);
        mA3 = findViewById(R.id.textA3);
        mA4 = findViewById(R.id.textA4);
        mB1 = findViewById(R.id.textB1);
        mB2 = findViewById(R.id.textB2);
        mB3 = findViewById(R.id.textB3);
        mB4 = findViewById(R.id.textB4);
        mInput1 = findViewById(R.id.inputAnswer1);
        mInput2 = findViewById(R.id.inputAnswer2);
        mInput3 = findViewById(R.id.inputAnswer3);
        mInput4 = findViewById(R.id.inputAnswer4);
        mButton = findViewById(R.id.button);
        randomizeQuiz();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean[] answer = new boolean[4];
                if (mInput1.getText().toString() == "T"){
                    answer[0] = true;
                }
                else if (mInput1.getText().toString() == "F"){
                    answer[0] = false;
                }
                if (mInput2.getText().toString() == "T"){
                    answer[1] = true;
                }
                else if (mInput1.getText().toString() == "F"){
                    answer[1] = false;
                }
                if (mInput3.getText().toString() == "T"){
                    answer[2] = true;
                }
                else if (mInput1.getText().toString() == "F"){
                    answer[2] = false;
                }
                if (mInput4.getText().toString() == "T"){
                    answer[3] = true;
                }
                else if (mInput1.getText().toString() == "F"){
                    answer[3] = false;
                }
                checkAnswers(answer);
            }
        });
    }

    private String randomQuestion(){
        boolean question = new Random().nextBoolean();
        if (question) {
            return ("T");
        }
        else {
            return ("F");
        }
    }

    private void randomizeQuiz() {
        mA1.setText(randomQuestion());
        mA2.setText(randomQuestion());
        mA3.setText(randomQuestion());
        mA4.setText(randomQuestion());
        mB1.setText(randomQuestion());
        mB2.setText(randomQuestion());
        mB3.setText(randomQuestion());
        mB4.setText(randomQuestion());
    }

    private void checkAnswers(boolean[] answer) {
        String message;
        boolean[] actualAnswer = new boolean[4];
            if (mA1.getText() == "T" && mB1.getText() == "F") {
                actualAnswer[0] = true;
            }
            else{
                actualAnswer[0] = false;
            }
        if (mA2.getText() == "T" && mB2.getText() == "F") {
            actualAnswer[1] = true;
        }
        else{
            actualAnswer[1] = false;
        }
        if (mA3.getText() == "T" && mB3.getText() == "F") {
            actualAnswer[2] = true;
        }
        else{
            actualAnswer[2] = false;
        }
        if (mA4.getText() == "T" && mB4.getText() == "F") {
            actualAnswer[3] = true;
        }
        else{
            actualAnswer[3] = false;
        }
        boolean allAnswersCorrect = true;
        for (int i = 0; i < answer.length; i++){
            if ((!answer[i] && actualAnswer[i]) || (answer[i] && !actualAnswer[i])){
                allAnswersCorrect = false;
            }
        }
        if (allAnswersCorrect) {
            message = getString(R.string.correct);
        }
        else {
            message = getString(R.string.incorrect);
        }
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        randomizeQuiz();
    }
}