package com.example.saveinstancetest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    private static final String SP_USER_NAME = "Key_User";
    EditText et_name;
    Button mybutton;
    Button mybuttonRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        et_name = findViewById (R.id.et_name);
        mybutton = findViewById (R.id.btn_save_to_sp);
        mybuttonRead = findViewById (R.id.btn_read_to_sp);


        sharedPreferences =
                getSharedPreferences ("UserName", MODE_PRIVATE);


        mybutton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                sharedPreferences.edit ().putString(SP_USER_NAME,
                        et_name.getText ().toString ()).commit();
            }
        });

        mybuttonRead.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String name =
                        sharedPreferences.getString (SP_USER_NAME, "");
                et_name.setText (name);
            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState (outState);
        outState.putString ("Text",
                et_name.getText ().toString ());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState (savedInstanceState);

        et_name.setText (savedInstanceState.getString ("Text"));
    }


}
