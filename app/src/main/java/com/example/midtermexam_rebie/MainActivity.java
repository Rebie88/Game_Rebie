package com.example.midtermexam_rebie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button1, button2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Main Activity");
        button1 = findViewById(R.id.buttonActivity2);
        button2 = findViewById(R.id.buttonToOpenActivity3);
        textView = (TextView) findViewById(R.id.textViewToDisplayAccountBalance);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,Activity2.class);
                startActivity(intent);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Account account = new Account("12345","UsBank",1000);
                Intent intent = new Intent(MainActivity.this,Activity3.class);
                intent.putExtra("account",account);
                startActivity(intent);
            }
        });


        Account myaAccount = (Account) getIntent().getParcelableExtra("keyword");
        if(myaAccount != null) {
            String accountNumber = String.valueOf(myaAccount.getAccountNumber());
            String bankName = String.valueOf(myaAccount.getBankName());
            String balance = String.valueOf(myaAccount.getBalance());
            textView.setText("Account Number= " + accountNumber + "\n" +
                    "Bank Name= " + bankName + "\n" +
                    "Balance= " + balance);
        }else {
            textView.setText("");
        }

    }
}