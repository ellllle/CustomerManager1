package com.bignerdranch.android.customermanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class NewCustomerActivity extends AppCompatActivity {

    private static Button submit;
    private static Button pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_customer);
        PayButton();
        SubmitButton();
    }


    public void PayButton(){

        pay = (Button) findViewById(R.id.pay_button);
        pay.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(NewCustomerActivity.this, PaymentActivity.class);
                        startActivity(intent);
                    }
                }
        );

    }

    public void SubmitButton(){
        submit = (Button) findViewById(R.id.submit_button);

        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(NewCustomerActivity.this, ProfileActivity.class );
                        startActivity(intent);
                    }
                }
        );
    }



}
