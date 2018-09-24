package com.example.elvisoe.mp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WinnerActivity extends AppCompatActivity {

    private TextView textViewWinner;// To display the winner name
    private TextView textViewDiference;//To display the difference for which the team won

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        //set our TextViews containers
        textViewWinner = findViewById(R.id.textViewWinnerName);
        textViewDiference = findViewById(R.id.textViewWonBy);

        Intent won = getIntent();//Get the parameters from the parent activity

        //Set the name, color and difference of points od the winning team with the data from the MainActivity
        String strWinnerName = won.getExtras().get(MainActivity.KEY_WIN_NAME).toString();
        String strWinnerDiff = won.getExtras().get(MainActivity.KEY_WON_BY).toString();
        int colorCode = Integer.parseInt(won.getExtras().get(MainActivity.KEY_TEAM_COLOR).toString());

        if (colorCode == 1)
            textViewWinner.setTextColor(getResources().getColor(R.color.TeamA));
        else
            textViewWinner.setTextColor(getResources().getColor(R.color.TeamB));
        textViewWinner.setText(strWinnerName);
        textViewDiference.setText("Won by: "+ strWinnerDiff+" points");
    }
}
