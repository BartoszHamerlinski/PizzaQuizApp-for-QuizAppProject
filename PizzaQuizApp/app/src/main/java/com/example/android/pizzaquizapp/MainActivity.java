package com.example.android.pizzaquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the show score button is clicked and it checks if the
     * the right answer was checked.
     */

    public void showScore (View view) {


        RadioButton greeceRadioButton = findViewById(R.id.answer_fourth_question_1);
        boolean itISGreece = greeceRadioButton.isChecked();

        RadioButton ananasRadioButton = findViewById(R.id.answer_third_question_2);
        boolean itItsAnanas = ananasRadioButton.isChecked();

        CheckBox tomatoSouceCheckBox = findViewById(R.id.answer_first_question_3);
        boolean  hasTomatoSouce = tomatoSouceCheckBox.isChecked();

        CheckBox tunaCheckBox = findViewById(R.id.answer_second_question_3);
        boolean  hasTuna = tunaCheckBox.isChecked();

        CheckBox cheeseCheckBox = findViewById(R.id.answer_third_question_3);
        boolean  hasCheese = cheeseCheckBox.isChecked();

        CheckBox oreganoCheckBox = findViewById(R.id.answer_fourth_question_3);
        boolean  hasOregano = oreganoCheckBox.isChecked();

        EditText flourEditText = findViewById(R.id.answer_first_question_4);
        String userAnswer = flourEditText.getText().toString();

        EditText waterEditText = findViewById(R.id.answer_second_question_4);
        String userSecondAnswer = waterEditText.getText().toString();

        EditText saltEditText = findViewById(R.id.answer_third_question_4);
        String userThirdAnswer = saltEditText.getText().toString();

        RadioButton threeIngeredientRadio = findViewById(R.id.answer_third_question_5);
        boolean  itIsThreeIngeredient = threeIngeredientRadio.isChecked();

        int score = calculateScore(itISGreece, itItsAnanas, hasTomatoSouce, hasTuna, hasCheese, hasOregano,
                userAnswer, userSecondAnswer, userThirdAnswer, itIsThreeIngeredient);
        displayScore(score);
    }

    /**
     * This method is calculating final score for quiz
     */

    private int calculateScore(boolean addOnePointForQ1, boolean addOnePointForQ2,
                               boolean firstCorrectCheckForQ3, boolean doNothingIfCheckForQ3,
                               boolean secondCorrectCheckForQ3,
                               boolean thirdCorrectCheckForQ3, String playerAnswer,
                               String playerSecondAnswer, String playerThirdAnswer,
                               boolean addOnePointForQ5  ) {
        int initialResult = 0;

        if (addOnePointForQ1){
            initialResult = initialResult +1;
        }

        if (addOnePointForQ2) {
            initialResult = initialResult + 1;
        }

        if (firstCorrectCheckForQ3 && secondCorrectCheckForQ3 && thirdCorrectCheckForQ3 && !doNothingIfCheckForQ3) {
                        initialResult = initialResult + 1;}


        if (playerAnswer.equalsIgnoreCase("Flour")) {
            if (playerSecondAnswer.equalsIgnoreCase("Water")){
                if (playerThirdAnswer.equalsIgnoreCase("Salt")){
                    initialResult = initialResult + 1;
                }
            }
        }
        if (addOnePointForQ5){
            initialResult = initialResult +1;
        }
            return initialResult;
    }

    /**
         * This method will display final result
         */

     private void displayScore(int scoreForPlayer){
         TextView scoreAfterQuiz = findViewById(R.id.final_score);
         if (scoreForPlayer == 5){
             Toast.makeText(getApplicationContext(),
                     "You are true Pizza Lover!", Toast.LENGTH_LONG).show();
         }else{
             Toast.makeText(getApplicationContext(),
                     "Thank you! Your score is: " + scoreForPlayer , Toast.LENGTH_LONG).show();
         }
         scoreAfterQuiz.setText("" + scoreForPlayer);
    }

}
