package com.example.jpratt.guessinggame;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    TextView guessCounter;
    Button playAgainButton;
    ImageView imageViewDerp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        locateViews();
        bindPlayAgain();
        populateGuessCount();
        bindImage();
    }

    public void locateViews(){
        guessCounter = (TextView) findViewById(R.id.guessCounter);
        playAgainButton = (Button) findViewById(R.id.playAgainButton);
        imageViewDerp = (ImageView) findViewById(R.id.imageViewDerp);

    }

   public void bindImage(){
       String numGuesses = getIntent().getStringExtra(getStringFromResources(R.string.intentCounterTag));
       if(Integer.parseInt(numGuesses) <= 5){
           Drawable drawable = getResources().getDrawable(R.drawable.derp,getTheme());
           imageViewDerp.setImageDrawable(drawable);
       }
       else{
           Drawable drawable = getResources().getDrawable(R.drawable.notcool,getTheme());
           imageViewDerp.setImageDrawable(drawable);
       }

    }

    public void bindPlayAgain(){
        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GuessingActivity.class);
                startActivity(intent);
            }
        });
    }

    public void populateGuessCount(){
        String numGuesses = getIntent().getStringExtra(getStringFromResources(R.string.intentCounterTag));
        if(Integer.parseInt(numGuesses) <= 5){
            guessCounter.setTextColor(Color.GREEN);
        }
        else{
            guessCounter.setTextColor(Color.RED);
        }
        guessCounter.setText(numGuesses);
    }

    public String getStringFromResources(int num){
        return getApplicationContext().getResources().getString(num);
    }


}
