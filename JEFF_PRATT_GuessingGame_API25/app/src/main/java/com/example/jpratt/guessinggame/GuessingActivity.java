package com.example.jpratt.guessinggame;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;

public class GuessingActivity extends AppCompatActivity {

    public static String countTag = "countTag";
    EditText inputNumber;
    Button checkButton;
    public int counter = 0;
    public int targetNumber ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing);
        targetNumber = (int)(Math.random() * 20);
        counter = 0;
        locateViews();
        bindCheckButton();
    }

    public void locateViews(){
        checkButton = (Button) findViewById(R.id.checkButton);
        inputNumber = (EditText) findViewById(R.id.inputNumber);
    }

    public void bindCheckButton(){
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCorrectNumber()){
                    goToResults();
                }
                else{

                }
            }
        });
    }

    public boolean isCorrectNumber(){
        if(isInteger(inputNumber) && isValidRange(inputNumber)){
            int numberToCheck = editTextToInt(inputNumber);
            if(numberToCheck > targetNumber){
                //toast for too high
                String displayDiff = "Number too high";
                counter++;
                Toast.makeText(getApplicationContext(), displayDiff.toString(),LENGTH_SHORT).show();
                return false;
            }
            else if(numberToCheck < targetNumber){
                // toast for too low
                String displayDiff = "Number too low";
                counter++;
                Toast.makeText(getApplicationContext(), displayDiff.toString(),LENGTH_SHORT).show();
                return false;
            }
            else{
                Toast.makeText(getApplicationContext(), "Correct!!",LENGTH_SHORT).show();
                counter++;
                return true;
            }
        }
        else{
            String enterNewText = "Please enter a number between 0 and 20";
            Toast.makeText(getApplicationContext(), enterNewText.toString(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public int editTextToInt(EditText text){
        String stringText = text.getText().toString();
        return Integer.parseInt(stringText);
    }

    public static boolean isInteger(EditText text){
        try{
            Integer.parseInt(text.getText().toString());
        }
        catch(NumberFormatException nfe){
            return false;
        }
        return true;
    }

    public boolean isValidRange(EditText text){
        int number = editTextToInt(text);
        if(number >= 0 && number <= 20){
            return true;
        }
        else{
            return false;
        }
    }

    public String getStringFromResources(int num){
        return getApplicationContext().getResources().getString(num);
    }

    public void goToResults(){
        //new intent
        Intent intent = new Intent(getApplicationContext(),ResultsActivity.class);
        intent.putExtra(getStringFromResources(R.string.intentCounterTag),Integer.toString(counter));
        startActivity(intent);
    }




}
