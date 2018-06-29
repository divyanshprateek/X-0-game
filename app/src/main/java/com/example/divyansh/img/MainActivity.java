package com.example.divyansh.img;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int activestate = 0;
    int gamestate[] = {2,2,2,2,2,2,2,2,2};
    int[][] winnerstates ={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean isactive = true;
    public void dropIn(View view)
    {
        ImageView counter = (ImageView) view;
        LinearLayout ll = (LinearLayout) findViewById(R.id.play);
        int tappedcounter = Integer.parseInt(counter.getTag().toString());
        if(gamestate[tappedcounter-1] == 2 && isactive) {
            if (activestate == 0) {
                gamestate[tappedcounter-1] = activestate;
                counter.setTranslationY(-1000f);
                counter.setImageResource(R.drawable.yellow);
                counter.animate().translationYBy(1000f).setDuration(500);
                activestate = 1;
            } else {
                gamestate[tappedcounter-1] = activestate;
                counter.setTranslationY(-1000f);
                counter.setImageResource(R.drawable.red);
                counter.animate().translationYBy(1000f).setDuration(500);
                activestate = 0;
            }
            for (int[] winnerstate : winnerstates)
            {
                if((gamestate[winnerstate[0]] == gamestate[winnerstate[1]]) && (gamestate[winnerstate[1]] == gamestate[winnerstate[2]])
                        && (gamestate[winnerstate[0]]!=2))
                {
                    //someone has won
                    isactive = false;
                    String winner = "red";
                    if(gamestate[winnerstate[0]] == 0)
                    {
                        winner = "yellow";
                    }
                    TextView t = (TextView) findViewById(R.id.playAgain) ;
                    t.setText(winner+" has won");
                    ll.setVisibility(view.VISIBLE);

                }
            }
        }
    }
    public void playOn(View view)
    {
         activestate = 0;
         isactive = true;
        for (int i = 0;i < gamestate.length;i++)
        {
            gamestate[i] = 2;
        }

        LinearLayout ll = (LinearLayout) findViewById(R.id.play);
        ll.setVisibility(view.INVISIBLE);
        ImageView img1 =(ImageView) findViewById(R.id.img1);
        img1.setImageResource(0);
        ImageView img2 =(ImageView) findViewById(R.id.img2);
        img2.setImageResource(0);
        ImageView img3 =(ImageView) findViewById(R.id.img3);
        img3.setImageResource(0);
        ImageView img4 =(ImageView) findViewById(R.id.img4);
        img4.setImageResource(0);
        ImageView img5 =(ImageView) findViewById(R.id.img5);
        img5.setImageResource(0);
        ImageView img6 =(ImageView) findViewById(R.id.img6);
        img6.setImageResource(0);
        ImageView img7 =(ImageView) findViewById(R.id.img7);
        img7.setImageResource(0);
        ImageView img8 =(ImageView) findViewById(R.id.img8);
        img8.setImageResource(0);
        ImageView img9 =(ImageView) findViewById(R.id.img9);
        img9.setImageResource(0);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
