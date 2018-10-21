package com.example.hp.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[] game={2,2,2,2,2,2,2,2,2};

    int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};
    int activePlayer=0;//0=yellow,1=red,2:Empty

    public void dropIn(View view){



        ImageView counter=(ImageView) view;

        Log.i("Tag",counter.getTag().toString());

        int tappedCounter=Integer.parseInt(counter.getTag().toString());
        game[tappedCounter]=activePlayer;
        counter.setTranslationY(-1500);
        if(activePlayer==0) {
            counter.setImageResource(R.drawable.yellow);
            activePlayer=1;

        }else{
            counter.setImageResource(R.drawable.red);
            activePlayer=0;
        }
        counter.animate().translationYBy(1500).rotation(3600).setDuration(500);

        for(int[] winningpos:winningPositions){
            if(game[winningpos[0]]==game[winningpos[1]] && game[winningpos[1]]==game[winningpos[2]] && game[winningpos[0]]!=2){
                Toast.makeText(this, "Someone has won!!", Toast.LENGTH_LONG).show();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
