package com.example.android.androidquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

/*
Method called when the Submit button is clicked
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


/*
Method checks answers for questions 2-5
*/

    private int checkAnswers(int points) {

        // Question 2

        EditText releaseYearEditText = (EditText) findViewById(R.id.release_year_edit_text);
        String releaseYear = releaseYearEditText.getText().toString();

        if (releaseYear.equals("2008")) {

            points = points + 25;

        }

        // Question 3

        CheckBox andyCheckbox = (CheckBox) findViewById(R.id.founder_andy_checkbox);
        boolean andyCheckboxState = andyCheckbox.isChecked();

        CheckBox nickCheckbox = (CheckBox) findViewById(R.id.founder_nick_checkbox);
        boolean nickCheckboxState = nickCheckbox.isChecked();

        CheckBox richCheckbox = (CheckBox) findViewById(R.id.founder_rich_checkbox);
        boolean richCheckboxState = richCheckbox.isChecked();

        CheckBox chrisCheckbox = (CheckBox) findViewById(R.id.founder_chris_checkbox);
        boolean chrisCheckboxState = chrisCheckbox.isChecked();

        if (andyCheckboxState && nickCheckboxState && richCheckboxState && chrisCheckboxState) {

            points = points + 25;

        }

        // Question 4

        RadioButton nugatRadioButton = (RadioButton) findViewById(R.id.codename_radio_nougat);
        boolean nugatCheckboxState = nugatRadioButton.isChecked();

        if (nugatCheckboxState) {

            points = points + 25;

        }

        // Question 5

        RadioButton googleRadioButton = (RadioButton) findViewById(R.id.company_radio_google);
        boolean googleCheckboxState = googleRadioButton.isChecked();

        if (googleCheckboxState) {

            points = points + 25;

        }

        return points;
    }



/*
Method shows the result of the quiz
*/

    public void showPoints(int points, String name) {

        if (points == 0) {

            Toast.makeText(this, "Sorry, but no points for you " + name + " :(", Toast.LENGTH_SHORT).show();

        } else if (points == 100) {

            Toast.makeText(this, "WOW! Congratulations " + name + "! Everything is correct! You have won all " + points + " points!", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(this, "Congratulations " + name + "! You have won " + points + " points!", Toast.LENGTH_SHORT).show();

        }

    }


}
