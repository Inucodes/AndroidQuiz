package com.example.android.androidquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
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
        ScrollView mainScrollView = (ScrollView) findViewById(R.id.main_scroll_view);
        // calling the main scroll view to scroll it back to 0, 0 if needed

        EditText nameEditText = (EditText) findViewById(R.id.name_edit_text);
        // calling edit text to check if there is a name

        String pleaseInputName = getString(R.string.please_input_name);
        // string for input name toast

        String name = nameEditText.getText().toString();



        if (name.equals(""))  // checks if there is text in the name field

        {

            Toast.makeText(this, pleaseInputName, Toast.LENGTH_SHORT).show();
            // shows an error when you try to submit without the name

            mainScrollView.scrollTo(0, 0);
            nameEditText.requestFocus();
            // scrolls back to the name field


        } else {

            points = checkAnswers(points); // checks points
            showPoints(points, name); // shows result message

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
     * @param points number of points from the quiz questions
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

            String sadToast = getString(R.string.no_points) + name + getString(R.string.sad_face);
            // Sad toast for 0 points :(

            Toast.makeText(this, sadToast , Toast.LENGTH_SHORT).show();

        } else if (points == 100) {

           String supeExcitedToast = getString(R.string.congratulations) + name + getString(R.string.won_all) + points + getString(R.string.points);
           // Supper excited toast for max 100 points!

            Toast.makeText(this, supeExcitedToast, Toast.LENGTH_SHORT).show();

        } else {

           String happyToast = getString(R.string.simple_congratulations) + name + getString(R.string.you_won) + points + getString(R.string.points);
           // Happy toast for any points above 0

            Toast.makeText(this,happyToast , Toast.LENGTH_SHORT).show();

        }

    }


}
