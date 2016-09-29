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
import android.widget.ListView;
import android.widget.Toast;

public class CustomerActivity extends AppCompatActivity {

    private static Button show_profile;
    private static Button new_customer;
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    CustomerBaseHelper customerBaseHelper;
    Cursor cursor;
    ListDataAdappter listDataAdappter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        Toolbar navToolBar = (Toolbar)findViewById(R.id.nav_toolbar);
        setSupportActionBar(navToolBar);

        listView = (ListView) findViewById(R.id.listView);
        listDataAdappter = new ListDataAdappter(getApplicationContext(), R.layout.rowinfo);
        listView.setAdapter(listDataAdappter);
        customerBaseHelper = new CustomerBaseHelper(getApplicationContext());
        sqLiteDatabase = customerBaseHelper.getReadableDatabase();
        cursor = customerBaseHelper.getCustomerInfo(sqLiteDatabase);
        if(cursor.moveToFirst() )
        {
            do{
                String fname, lname,sessions;
                fname = cursor.getString(0);
                lname = cursor.getString(1);
                sessions = cursor.getString(2);
                DataProvider dataProvider = new DataProvider(fname, lname,sessions);
                listDataAdappter.add(dataProvider);

            }while(cursor.moveToNext());


        }


        setUpNewCustomerBtn();
        setUpProfileBtn();

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
                Toast.makeText(CustomerActivity.this, "Logging You Off", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, SigninActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    public void setUpProfileBtn(){
        show_profile = (Button)findViewById(R.id.profile_button);

        show_profile.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(CustomerActivity.this, ProfileActivity.class );
                        startActivity(intent);
                    }
                }
        );
    }

    public void setUpNewCustomerBtn(){
               new_customer = (Button) findViewById(R.id.newCustomerButton);

        new_customer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(CustomerActivity.this, NewCustomerActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
