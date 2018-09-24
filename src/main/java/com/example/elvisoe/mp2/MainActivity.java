package com.example.elvisoe.mp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    private int countA = 0;//Counter for Team A points
    private int countB = 0;//Counter for Team B points
    private int difference = 0;// Difference between the winner and the opponent team
    private int colorCode =0; //Color code of the Winner Team
    private String winName;// Name of the Winner Team
    public TextView mcountA;//To visualize the count of the team A
    public TextView mcountB;//To visualize the count of the team B
    public Button buttonTA;//To enable or disable button
    public Button buttonTB;//To enable or disable button
    public TextView texViewWinnerName;//To extract the name of the winner team
    protected static final int SCORE_TO_WIN = 5;//Set the points needed to win the game
    protected static final String KEY_WIN_NAME = "winnerName"; //To passe the team winner name to the WinnignActivity
    protected static final String KEY_TEAM_COLOR = "Team_Color";// To pass the team color
    protected static final String KEY_WON_BY = "Points_Difference";// Number of points the team won by

    @Override
    //Passsing the default parameters
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mcountA = (TextView) findViewById(R.id.textViewTeamAScoreA);
        mcountB = (TextView) findViewById(R.id.textViewTeamAScoreB);
        buttonTA = (Button) findViewById(R.id.butonPointA);
        buttonTB = (Button) findViewById(R.id.butonPointB);
        mcountA.setText(""+countA);
        mcountB.setText(""+countB);
    }

    //Function to add points to the Team in increments of 1
    public void addPointA(View view){
        countA++;
        mcountA.setText(""+countA);

        //If the team win, set the values of color, name and difference in points.
        if (countA>=SCORE_TO_WIN)
        {
            colorCode =1;
            texViewWinnerName = (TextView) findViewById(R.id.textViewTeamA);
            winName = texViewWinnerName.getText().toString();
            difference=countA-countB;
            WinActivity(view);
        }
    }

    //Function to add points to the Team in increments of 1
    public void addPointB(View view) {
        countB++;
        mcountB.setText(""+countB);
        //If the team win, set the values of color, name and difference in points.
        if (countB>=SCORE_TO_WIN) {
            colorCode = 2;
            texViewWinnerName = (TextView) findViewById(R.id.textViewTeamB);
            winName = texViewWinnerName.getText().toString();
            difference=countB-countA;
            WinActivity(view);
        }

    }

    //function to reset the program to default.
    public void Reset(View view) {
        countA = 0;
        countB = 0;
        colorCode=0;
        mcountA.setText(""+countA);
        mcountB.setText(""+countB);
        buttonTA.setEnabled(true);
        buttonTB.setEnabled(true);
    }

    // Call to the Second Activity to display the winner name and points by which the team won
    public void WinActivity(View view) {
        //disable the button to avoid mistakenly press it after a Team win the game
        buttonTA.setEnabled(false);
        buttonTB.setEnabled(false);
        //Create the intent of the second activity(WinnerActivity) and pass three variables
        //of the winner team and start the WinnerActivity.
        Intent winner = new Intent(this, WinnerActivity.class);
        winner.putExtra(KEY_WIN_NAME, winName);
        winner.putExtra(KEY_WON_BY, difference);
        winner.putExtra(KEY_TEAM_COLOR, colorCode);
        startActivity(winner);
    }
}
