package com.example.firstassignmentgreenflag;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.mukesh.countrypicker.CountryPicker;
import com.mukesh.countrypicker.CountryPickerListener;

import java.util.Calendar;
import java.util.LinkedList;

public class PgThree extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, CountryPickerListener {
private final LinkedList<User> mWordList = new LinkedList<> ();
private RecyclerView getmRecylerView;
private WordListAdapter getmAdapter;
    Button btn_user;
    EditText et_username,et_name;
    EditText et_pw;
    Intent intent;
    EditText et_birth_date;
    EditText et_country;
    CountryPicker cp;
    RadioGroup gender;
    String genderValue;
//    Spinner spinner_country;
    ArrayAdapter adapter;

/*    public class CountryDialogFragment extends DialogFragment {
        private EditText mEditText;
        public EditCountryDialogFragment(){

        }
    }*/

    private RecyclerView mRecylerView;
    private WordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_pg_three);
        btn_user = findViewById (R.id.btn_save_user);
        intent = getIntent ();
        et_pw = findViewById (R.id.et_pw);
        et_username = findViewById (R.id.et_username);
        et_username.setText (intent.getStringExtra ("email"));
        et_pw.setText (intent.getStringExtra ("password"));
        et_birth_date = findViewById (R.id.et_birth_date);
        et_country = findViewById (R.id.et_country);
        gender = findViewById (R.id.r_group);
        mRecylerView = findViewById (R.id.recyclerview);
        mAdapter = new WordListAdapter(mWordList);
        mRecylerView.setAdapter (mAdapter);
        et_name = findViewById (R.id.et_name);
        mRecylerView.setLayoutManager (new LinearLayoutManager (this));
        cp = CountryPicker.newInstance ("Select Country");

        gender.setOnCheckedChangeListener (new RadioGroup.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById (checkedId);
                genderValue = radioButton.getText ().toString ();
            }
        });

        et_country.setOnFocusChangeListener (new View.OnFocusChangeListener () {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    showCountryPicker ();
                }
            }
        });
        cp.setListener (this);

        btn_user.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (PgThree.this,RecyclerPage.class);
                User user = new User ();
                user.setName (et_name.getText ().toString ());
                user.setBirthday (et_birth_date.getText ().toString ());
                user.setCountry (et_country.getText ().toString ());
                user.setPassword (et_pw.getText ().toString ());
                user.setGender (genderValue);

                intent.putExtra ("User", user);
                startActivity (intent);

            }
        });

//      spinner_country = findViewById (R.id.spinner_country);




        et_birth_date.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                showDatePicker ();
            }
        });
//        adapter = (ArrayAdapter) ArrayAdapter.createFromResource (this,R.array.spinner_country_array);
//        spinner_country = (Spinner)findViewById (R.id.spinner_country);
//        spinner_country.setAdapter (adapter);
//        spinner_country.setOnItemSelectedListener (this);

    }

    private void showCountryPicker (){
        cp.show (getSupportFragmentManager (),"COUNTRY_PICKER");
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

    @Override
    public void onSelectCountry(String s, String s1, String s2, int i) {
        et_country.setText (s);
        System.out.println ("dialog box should close");
        cp.dismiss ();
    }

//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        TextView sp
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }



}