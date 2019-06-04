package com.example.firstassignmentgreenflag;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class pg_three extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    EditText et_username;
    EditText et_pw;
    Intent intent;
    EditText et_birth_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_pg_three);

        intent = getIntent ();
        et_pw = findViewById (R.id.et_pw);
        et_username = findViewById (R.id.et_username);
        et_username.setText (intent.getStringExtra ("email"));
        et_pw.setText (intent.getStringExtra ("password"));
        et_birth_date = findViewById (R.id.et_birth_date);

        et_birth_date.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                showDatePicker ();
            }
        });

    }

    private void showDatePicker (){
        DatePickerDialog myCalandar = new DatePickerDialog (
                this,
                this,
                Calendar.getInstance ().get (Calendar.YEAR),
                Calendar.getInstance ().get (Calendar.MONTH),
                Calendar.getInstance ().get (Calendar.DAY_OF_MONTH)
        );
        myCalandar.show ();
    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        et_birth_date.setText (month+1+"/"+dayOfMonth+"/"+year);
    }
}