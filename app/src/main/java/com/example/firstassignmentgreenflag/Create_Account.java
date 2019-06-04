package com.example.firstassignmentgreenflag;

import android.content.Intent;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Create_Account extends AppCompatActivity{

    EditText et_email;
    EditText et_password;
    EditText et_repeat_password;
    Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_create__account);

        et_email = findViewById (R.id.et_email);
        et_password = findViewById (R.id.et_password);
        et_repeat_password = findViewById (R.id.et_repeat_password);
        btn_next = findViewById (R.id.btn_next);

        btn_next.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                /*if (isValid (et_email.getTransitionName ().toString ()))
                   Toast.makeText (Create_Account.this, "Is Valid", Toast.LENGTH_SHORT).show ();
                    else
                Toast.makeText (Create_Account.this, "Is Not Valid", Toast.LENGTH_SHORT).show ();*/
               Intent intent = new Intent();
               intent.setClass (getApplicationContext (),pg_three.class);
               intent.putExtra ("email",et_email.getText ().toString ());
               intent.putExtra ("password",et_password.getText ().toString ());
               startActivity (intent);
            }


        });


    }
   /* public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }*/


}