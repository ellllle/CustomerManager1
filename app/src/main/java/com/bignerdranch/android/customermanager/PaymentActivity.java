package com.bignerdranch.android.customermanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class PaymentActivity extends AppCompatActivity {
    private Button pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Pay();

    }
    public void Pay(){
        pay = (Button) findViewById(R.id.cancel_button);

        pay.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(PaymentActivity.this, CustomerActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }

}
