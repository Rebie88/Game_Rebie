package com.example.midtermexam_rebie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {
Button buttonToDeposit, buttonToWithdraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        setTitle("Activity3");

        buttonToDeposit = (Button) findViewById(R.id.buttonDeposit);
        buttonToWithdraw = (Button) findViewById(R.id.buttonWithdraw);
        TextView textView1234 = (TextView) findViewById(R.id.textViewDisplayAccount3);
        Button button12 = (Button) findViewById(R.id.buttonGoToMain);

        Account account = (Account) getIntent().getParcelableExtra("account");
        textView1234.setText(""+ account);

        buttonToDeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                account.deposit(100);
                textView1234.setText(""+ account);
            }
        });

        buttonToWithdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                account.withdraw(100);
                textView1234.setText(""+ account);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity3.this, MainActivity.class);
                intent.putExtra("keyword",account);
                startActivity(intent);
            }
        });

    }
}