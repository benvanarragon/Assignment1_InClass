package com.example.assignment1_inclass;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //define our variables
    private NumberPicker numberPickerDonation;
    private TextView textViewAmount;

    //we use this variable to calculate the total amount of all our donations
    int donationTotal = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //instantiate our variables
        numberPickerDonation = findViewById(R.id.numberPickerDonation);
        textViewAmount = findViewById(R.id.textViewTotalAmount);

        //set min and max values of our number picker
        numberPickerDonation.setMinValue(0);
        numberPickerDonation.setMaxValue(1000);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when Floating Action Button is clicked, call the method below
                addDonation();
            }
        });
    }

    //this method will add up the number picker selections and set the text of the textview to the
    //total all the donations
    private void addDonation(){
        // code for adding a donation
        int donation = numberPickerDonation.getValue();

        if(donation != 0){
            //if donation is not 0$ run this code
            donationTotal += donation;


            String donationTotalString = "$" + donationTotal;
            textViewAmount.setText(donationTotalString);

        }else{
            //if the donation is $0 run this code
            //add a toast message to the user asking for a donation of greater then 0
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }
}
