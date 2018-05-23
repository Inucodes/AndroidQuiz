package com.example.android.androidquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Method called when the Submit button is clicked
     *
     * @param view
     */

    public void submitQuiz(View view) {

        int points = 0; // initial number of points

        EditText nameEditText = (EditText) findViewById(R.id.name_edit_text);
        String name = nameEditText.getText().toString();

        // checks if there is text in the name field

        if (name.equals(""))

        // shows an error when you try to submit without the name

        {
            Toast.makeText(this, "Please input your name", Toast.LENGTH_SHORT).show();

        } else {

            points = checkAnswers(points);
            showPoints(points, name);

        }

    }

    /**
     * This method "unselects" the right side radio group for question 4
     *
     * @param view
     */

    public void unselectRadioBtnRight(View view) {

        RadioGroup radioGroupRight = (RadioGroup) findViewById(R.id.codename_radio_group_right);

        radioGroupRight.clearCheck();

    }

    /**
     * This method "unselects" the left side radio group for question 4
     *
     * @param view
     */

    public void unselectRadioBtnLeft(View view) {

        RadioGroup radioGroupLeft = (RadioGroup) findViewById(R.id.codename_radio_group_left);

        radioGroupLeft.clearCheck();

    }

    /**
     * Method checks answers for questions 2-5 and adds points accordingly
     *
     * @param points
     * @return
     */

    private int checkAnswers(int points) {

        // Checking answers for question 2

        EditText releaseYearEditText = (EditText) findViewById(R.id.release_year_edit_text);
        String releaseYear = releaseYearEditText.getText().toString();

        if (releaseYear.equals("2008")) {

            // Input must be 2008 for correct answer, if true +25 points

            points = points + 25;

        }

        // Checking answers for question 3

        CheckBox andyCheckbox = (CheckBox) findViewById(R.id.founder_andy_checkbox);
        boolean andyCheckboxState = andyCheckbox.isChecked();

        CheckBox nickCheckbox = (CheckBox) findViewById(R.id.founder_nick_checkbox);
        boolean nickCheckboxState = nickCheckbox.isChecked();

        CheckBox richCheckbox = (CheckBox) findViewById(R.id.founder_rich_checkbox);
        boolean richCheckboxState = richCheckbox.isChecked();

        CheckBox chrisCheckbox = (CheckBox) findViewById(R.id.founder_chris_checkbox);
        boolean chrisCheckboxState = chrisCheckbox.isChecked();

        if (andyCheckboxState && nickCheckboxState && richCheckboxState && chrisCheckboxState) {

            // All checkboxes must be checked for correct answer, if true +25 points

            points = points + 25;

        }

        // Checking answers for question 4

        RadioButton nugatRadioButton = (RadioButton) findViewById(R.id.codename_radio_nougat);
        boolean nugatCheckboxState = nugatRadioButton.isChecked();

        if (nugatCheckboxState) {

            // Only Nugat is the correct answer, if true +25 points

            points = points + 25;

        }

        // Checking answers for question 5

        RadioButton googleRadioButton = (RadioButton) findViewById(R.id.company_radio_google);
        boolean googleCheckboxState = googleRadioButton.isChecked();

        if (googleCheckboxState) {

            // Only Google is the correct answer, if true +25 points

            points = points + 25;

        }

        return points; // returning the final points value
    }

    /**
     * Method shows the result of the quiz
     *
     * @param points
     * @param name
     */

    public void showPoints(int points, String name) {

        if (points == 0) {

            // Sad toast for 0 points :(

            Toast.makeText(this, "Sorry, but no points for you " + name + " :(", Toast.LENGTH_SHORT).show();

        } else if (points == 100) {

            // Supper excited toast for max 100 points!

            Toast.makeText(this, "WOW! Congratulations " + name + "! Everything is correct! You have won all " + points + " points!", Toast.LENGTH_SHORT).show();

        } else {

            // Happy toast for any points above 0

            Toast.makeText(this, "Congratulations " + name + "! You have won " + points + " points!", Toast.LENGTH_SHORT).show();

        }

    }


}
