package com.bignerdranch.android.customermanager;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewCustomerActivity extends AppCompatActivity {

    private static Button submit;
    private static Button pay;
    CustomerBaseHelper myDb;
    SQLiteDatabase sqLiteDatabase;
    EditText editFirst, editLast, editSessions;
    Context context;
    Button addNew ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_customer);
        myDb = new CustomerBaseHelper(this);

        editFirst = (EditText) findViewById(R.id.firstName);
        editLast = (EditText) findViewById(R.id.lastName);
        editSessions = (EditText) findViewById(R.id.session);
        addNew = (Button) findViewById(R.id.AddNew);


        PayButton();
        SubmitButton();
        addNewClient();

    }


     public void addNewClient(){

         addNew.setOnClickListener(
                 new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                          myDb.insertData(editFirst.getText().toString(),
                                 editLast.getText().toString(),
                                 editSessions.getText().toString() );

                           Toast.makeText(getBaseContext(), "Data Saved", Toast.LENGTH_LONG).show();


                     }
                 }
         );

     }

    public void displayData(){

        addNew = (Button) findViewById(R.id.AddNew);
        addNew.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(NewCustomerActivity.this, CustomerActivity.class);
                        startActivity(intent);
                    }
                }
        );

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
