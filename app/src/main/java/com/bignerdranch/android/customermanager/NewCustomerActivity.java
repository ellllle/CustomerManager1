package com.bignerdranch.android.customermanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class NewCustomerActivity extends AppCompatActivity {

    private static ImageButton submit;
    private static Button pay;
    CustomerBaseHelper myDb;
    SQLiteDatabase sqLiteDatabase;
    EditText editFirst, editLast, editSessions;
    Context context;
    Button addNew ;
    private File imageFile;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_customer);

        Toolbar navToolBar = (Toolbar)findViewById(R.id.nav_toolbar);
        setSupportActionBar(navToolBar);

        myDb = new CustomerBaseHelper(this);

        editFirst = (EditText) findViewById(R.id.firstName);
        editLast = (EditText) findViewById(R.id.lastName);
        editSessions = (EditText) findViewById(R.id.session);
        addNew = (Button) findViewById(R.id.AddNew);
        mImageView = (ImageView) findViewById(R.id.imageView2);
        submitPictureButton();


        PayButton();
        //SubmitButton();
        addNewClient();

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.log_off_menu, menu);
        //menu.findItem(R.menu.log_off_menu).setIntent(new Intent(CustomerActivity.this, SigninActivity.class));
        //Toast.makeText(CustomerActivity.this, "Logging You Off", Toast.LENGTH_SHORT).show();
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.logOff_menu_item:
                Toast.makeText(NewCustomerActivity.this, "Logging You Off", Toast.LENGTH_SHORT).show();
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


     public void addNewClient(){

         addNew.setOnClickListener(
                 new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                          myDb.insertData(editFirst.getText().toString(),
                                 editLast.getText().toString(),
                                 editSessions.getText().toString() );

                           Toast.makeText(getBaseContext(), "Data Saved", Toast.LENGTH_LONG).show();
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



    public void submitPictureButton()
    {
        submit = (ImageButton) findViewById(R.id.submit_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                imageFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "test.jpg" );
                Uri uri = Uri.fromFile(imageFile);

                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
                startActivityForResult(intent, 1);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 0){
            switch (resultCode){
                case Activity.RESULT_OK:
                    if(imageFile.exists()){
                        Toast.makeText(this, "the picture was saved at " + imageFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(this, "the picture was not saved at ", Toast.LENGTH_LONG).show();
                    }
                    break;
                case Activity.RESULT_CANCELED:
                    break;
                default:
                    break;

            }
        }

    }
   /*public void submitPictureButton() {


       submit = (Button) findViewById(R.id.submit_button);
       submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               startActivityForResult(intent, 1);
           }
       });
      // Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
      // startActivityForResult(intent, 1);

   }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

         if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
             mImageView.setImageBitmap(imageBitmap);
             }
    }*/
}
