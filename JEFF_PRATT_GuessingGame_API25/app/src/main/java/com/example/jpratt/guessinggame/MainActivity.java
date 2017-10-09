package com.example.jpratt.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static String intentTag = "tag";
    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locateViews();
        bindStartListener();
    }

    //assign views that need to be interacted with
    public void locateViews(){
        startButton = (Button) findViewById(R.id.startButton);
    }

    //
    public void bindStartListener(){
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),GuessingActivity.class);
                startActivity(intent);
            }
        });
    }

}
