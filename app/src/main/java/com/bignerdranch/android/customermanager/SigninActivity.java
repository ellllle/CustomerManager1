package com.bignerdranch.android.customermanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {

    private static EditText username;
    private static EditText password;
    private static Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signin);
        LoginButton();
    }



    public void LoginButton(){
        username = (EditText)findViewById(R.id.user_name);
        password = (EditText) findViewById(R.id.password);
        login_button =(Button) findViewById(R.id.login_button);

        login_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(username.getText().toString().equals("Jdoe") &&  password.getText().toString().equals("welcome1")){
                            Intent intent = new Intent(SigninActivity.this, CustomerActivity.class);
                            startActivity(intent);

                        }else
                        {
                            Toast.makeText(SigninActivity.this, "Username and Password is not correct.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

    }



}
