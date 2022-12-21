package com.example.midtermexam_rebie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Activity2 extends AppCompatActivity {
    ImageView image1,image2,image3;
    TextView textView1,textView2,textView3, textViewForPlayer1Score,textViewForPlayer2Score, textViewPot1,textViewPot2;
    Button player1Btn, player2Btn,buttonPlayagain;
    int tossCountForPlayer1 = 0;
    int tossCountForPlayer2 = 0;
    int player1Score = 0;
    int player2Score= 0;
    int bet = 20;
    int pot1 = 50;
    int pot2 = 50;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        setTitle("Activity2");

        image1 = (ImageView) findViewById(R.id.diceAtPostion1);
        image2 = (ImageView) findViewById(R.id.diceAtPostion2);
        image3 = (ImageView) findViewById(R.id.diceAtPostion3);
        textView1 = (TextView) findViewById(R.id.textViewAtPostion1);
        textView2 = (TextView) findViewById(R.id.textViewAtPostion2);
        textView3 = (TextView) findViewById(R.id.textViewAtPostion3);
        textViewForPlayer1Score = (TextView)findViewById(R.id.textViewPlayer1Score);
        textViewForPlayer2Score = (TextView)findViewById(R.id.textViewPlayer2Score);
        textViewPot1 = (TextView) findViewById(R.id.textViewP1Pot) ;
        textViewPot2 =(TextView)findViewById(R.id.textViewP2Pot) ;
        TextView textView122 = (TextView) findViewById(R.id.textViewWinner);
        player1Btn = (Button) findViewById(R.id.buttonplayer1);
        player2Btn = (Button) findViewById(R.id.buttonPlayer2);
        buttonPlayagain = (Button)findViewById(R.id.buttonPlayAgain);

        player1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tossCountForPlayer1++;
                if(tossCountForPlayer1==3){
                    player1Btn.setClickable(false);
                    player2Btn.setClickable(true);
                    tossCountForPlayer2 = 0;
                }
                tossDice1();
                tossDice2();
                tossDice3();

                String score = Integer.toString(player1Score);
                textViewForPlayer1Score.setText(score);

            }
        });

            player2Btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tossCountForPlayer2++;
                    if(tossCountForPlayer2==3){
                        player2Btn.setClickable(false);
                        player1Btn.setClickable(true);
                        tossCountForPlayer1 = 0;
                    }
                    tossDice1();
                    tossDice2();
                    tossDice3();
                    String score = Integer.toString(player2Score);
                    textViewForPlayer2Score.setText(score);
                    displayWinner();
                    showWinnerForEveryRound();
                }
            });
        buttonPlayagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tossCountForPlayer1 = 0;
                tossCountForPlayer2 = 0;
                player1Score = 0;
                player2Score = 0;
                pot1 = 50;
                pot2 = 50;
                textViewForPlayer1Score.setText("0");
                textViewForPlayer2Score.setText("0");
                textView122.setText("");
                textViewPot1.setText("$50");
                textViewPot2.setText("$50");
                player1Btn.setClickable(true);
                player2Btn.setClickable(true);
            }
        });

    }

    public void displayWinner(){
        if((player1Score >=100 || player2Score>=100) && (!player2Btn.isClickable())) {
            if (player1Score > player2Score) {
                result = "Player 1 is the winner!!";
                pot1 = pot1 + bet;
                pot2 = pot2 - bet;
                textViewPot1.setText("$"+pot1);
                textViewPot2.setText("$"+pot2);
            } else if (player2Score > player1Score) {
                result = "Player 2 is the winner!!";
                pot1 = pot1 - bet;
                pot2 = pot2 + bet;
                textViewPot1.setText("$"+pot1);
                textViewPot2.setText("$"+pot2);
            } else {
                result = "The Game is Draw!!";
            }
            TextView textView122 = (TextView) findViewById(R.id.textViewWinner);
            textView122.setText(result);
            player1Btn.setClickable(false);
            player2Btn.setClickable(false);
        }

    }
    public void showWinnerForEveryRound(){
        if(!player2Btn.isClickable()) {
            if (player1Score > player2Score) {
                Toast.makeText(getApplicationContext(),"Player 1 is the winner in this round!!",Toast.LENGTH_LONG).show();
            } else if (player2Score > player1Score) {
                Toast.makeText(getApplicationContext(),"Player 2 is the winner in this round!!",Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(),"The Game is Draw in this round!!",Toast.LENGTH_LONG).show();
            }
        }
    }

    public void tossDice1() {
        Random rand = new Random();

        int randomNumber = rand.nextInt(6) + 1;
        if(player1Btn.isPressed()) {
            player1Score = player1Score + randomNumber;
        }if(player2Btn.isPressed()) {
            player2Score = player2Score + randomNumber;
        }
        switch (randomNumber) {
            case 1:
                image1.setImageResource(R.drawable.dice1);
                textView1.setText("1");
                break;
            case 2:
                image1.setImageResource(R.drawable.dice2);
                textView1.setText("2");
                break;
            case 3:
                image1.setImageResource(R.drawable.dice3);
                textView1.setText("3");
                break;
            case 4:
                image1.setImageResource(R.drawable.dice4);
                textView1.setText("4");
                break;
            case 5:
                image1.setImageResource(R.drawable.dice5);
                textView1.setText("5");
                break;
            case 6:
                image1.setImageResource(R.drawable.dice6);
                textView1.setText("6");
                break;
        }
    }

    public void tossDice2() {
        Random rand = new Random();

        int randomNumber = rand.nextInt(6) + 1;
        if(player1Btn.isPressed()) {
            player1Score = player1Score + randomNumber;
        }if(player2Btn.isPressed()) {
            player2Score = player2Score + randomNumber;
        }

        switch (randomNumber) {
            case 1:
                image2.setImageResource(R.drawable.dice1);
                textView2.setText("1");
                break;
            case 2:
                image2.setImageResource(R.drawable.dice2);
                textView2.setText("2");
                break;
            case 3:
                image2.setImageResource(R.drawable.dice3);
                textView2.setText("3");
                break;
            case 4:
                image2.setImageResource(R.drawable.dice4);
                textView2.setText("4");
                break;
            case 5:
                image2.setImageResource(R.drawable.dice5);
                textView2.setText("5");
                break;
            case 6:
                image2.setImageResource(R.drawable.dice6);
                textView2.setText("6");
                break;
        }
    }

    public void tossDice3() {
        Random rand = new Random();

        int randomNumber = rand.nextInt(6) + 1;
        if(player1Btn.isPressed()) {
            player1Score = player1Score + randomNumber;
        }if(player2Btn.isPressed()) {
            player2Score = player2Score + randomNumber;
        }

        switch (randomNumber) {
            case 1:
                image3.setImageResource(R.drawable.dice1);
                textView3.setText("1");
                break;
            case 2:
                image3.setImageResource(R.drawable.dice2);
                textView3.setText("2");
                break;
            case 3:
                image3.setImageResource(R.drawable.dice3);
                textView3.setText("3");
                break;
            case 4:
                image3.setImageResource(R.drawable.dice4);
                textView3.setText("4");
                break;
            case 5:
                image3.setImageResource(R.drawable.dice5);
                textView3.setText("5");
                break;
            case 6:
                image3.setImageResource(R.drawable.dice6);
                textView3.setText("6");
                break;
        }
    }
}