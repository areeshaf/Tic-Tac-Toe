package com.example.hp.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.GridLayout;

import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int[] game={2,2,2,2,2,2,2,2,2};

    int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};
    int activePlayer=0;//0=yellow,1=red,2:Empty

    boolean gameActive=true;

    public void dropIn(View view){



        ImageView counter=(ImageView) view;

        //Log.i("Tag",counter.getTag().toString());

        int tappedCounter=Integer.parseInt(counter.getTag().toString());
        if(game[tappedCounter]==2 && gameActive) {
            game[tappedCounter] = activePlayer;
            counter.setTranslationY(-1500);
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;

            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
            counter.animate().translationYBy(1500).rotation(3600).setDuration(500);

            for (int[] winningpos : winningPositions) {
                if (game[winningpos[0]] == game[winningpos[1]] && game[winningpos[1]] == game[winningpos[2]] && game[winningpos[0]] != 2) {

                    gameActive=false;
                    String winner = "";
                    if (activePlayer == 1) {
                        winner = "YELLOW";
                    } else {
                        winner = "RED";
                    }
                    //Toast.makeText(this, winner + " has won!!", Toast.LENGTH_SHORT).show();
                    Button playAgainButton=(Button)findViewById(R.id.button);
                    TextView winnerTextView=(TextView)findViewById(R.id.textView2);
                    winnerTextView.setText(winner+ " has Won!!");
                    winnerTextView.setVisibility(View.VISIBLE);
                    playAgainButton.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void playAgain(View view){

        Button playAgainButton=(Button)findViewById(R.id.button);
        TextView winnerTextView=(TextView)findViewById(R.id.textView2);

        winnerTextView.setVisibility(View.INVISIBLE);
        playAgainButton.setVisibility(View.INVISIBLE);

        GridLayout gridLayout=(GridLayout)findViewById(R.id.mygridLayout);

        for(int i=0;i<gridLayout.getChildCount();i++){
            ImageView counter=(ImageView)gridLayout.getChildAt(i);

            counter.setImageDrawable(null);
        }

        for (int i=0;i<game.length;i++){
            game[i]=2;
        }

        activePlayer=0;
        gameActive=true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
