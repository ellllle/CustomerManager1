package com.bignerdranch.android.customermanager;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    private static Button add_session;
    SQLiteDatabase sqLiteDatabase;
    CustomerBaseHelper customerBaseHelper;
    Cursor cursor;
    TextView TotalSession;
    TextView completedSessions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar navToolBar = (Toolbar)findViewById(R.id.nav_toolbar);
        setSupportActionBar(navToolBar);

        AddSession();

        TotalSession = (TextView) findViewById(R.id.totalSessions);
        completedSessions = (TextView) findViewById(R.id.completedSessions);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.log_off_menu, menu);
        //menu.findItem(R.menu.log_off_menu).setIntent(new Intent(CustomerActivity.this, SigninActivity.class));
        //Toast.makeText(CustomerActivity.this, "Logging You Off", Toast.LENGTH_SHORT).show();
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.logOff_menu_item:
                Toast.makeText(ProfileActivity.this, "Logging You Off", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, SigninActivity.class);
                startActivity(intent);
                return true;
            case R.id.Home_menu_item:

                Intent homeIntent = new Intent(this, CustomerActivity.class);
                startActivity(homeIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    public void AddSession(){
        add_session = (Button)findViewById(R.id.addSessionButton);
        add_session.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ProfileActivity.this, NewCustomerActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }

}
