package com.bignerdranch.android.customermanager;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewCustomerActivity extends AppCompatActivity {

    private static Button submit;
    private static Button pay;
    EditText firstname, lastname, sessions;
    Context context = this;
    CustomerDbHandler customerDbHandler;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_customer);
        firstname = (EditText) findViewById(R.id.firstNameEdit);
        lastname = (EditText) findViewById(R.id.lastNameEdit);
        sessions = (EditText) findViewById(R.id.sessionEdit);
        PayButton();
        SubmitButton();

    }
     //METHOD WILL INSERT A ROW TO DATABASE WITH THE ADD NEW CUSTOMER BUTTON.
    public void AddCustomers(View view){
        String fname = firstname.getText().toString();
        String lname = lastname.getText().toString();
        String sess = sessions.getText().toString();
        customerDbHandler = new CustomerDbHandler(context);
        sqLiteDatabase = customerDbHandler.getWritableDatabase();
        customerDbHandler.addCustomer(fname, lname, sess,sqLiteDatabase);
        Toast.makeText(getBaseContext(), "Data Saved", Toast.LENGTH_LONG).show();
        customerDbHandler.close();
    }

    public void viewInfo(View view){
        Intent intent = new Intent(this, CustomerActivity.class);
        startActivity(intent);
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
