package com.example.firstassignmentgreenflag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_create_account;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    btn_create_account = findViewById(R.id.btn_create_account);

    btn_create_account.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            moveToCreateAccount();
        }
    });
        }

    private void moveToCreateAccount() {
        Intent intent = new Intent (this,Create_Account.class);
        startActivity(intent);

    }
}
