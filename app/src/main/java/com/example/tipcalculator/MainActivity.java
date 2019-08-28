package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner stars = (Spinner) findViewById(R.id.spinner);
        final RatingBar mRatingBar = (RatingBar) findViewById(R.id.rating);
        stars.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.equals("1 Star")) {
                    mRatingBar.setRating(1);
                } else if (selectedItem.equals("2 Stars")) {
                    mRatingBar.setRating(2);
                } else if (selectedItem.equals("3 Stars")) {
                    mRatingBar.setRating(3);
                } else if (selectedItem.equals("4 Stars")) {
                    mRatingBar.setRating(4);
                } else if (selectedItem.equals("5 Stars")) {
                    mRatingBar.setRating(5);
                }
            } // to close the onItemSelected

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        int starRating = mRatingBar.getNumStars();

    }

    public void calculate (View v){

        try {


            DecimalFormat df = new DecimalFormat("###.00");

            EditText baseCost = (EditText) findViewById(R.id.baseCost);
            TextView tipAmount = (TextView) findViewById(R.id.tipAmount);
            TextView totalCost = (TextView) findViewById(R.id.totalCost);

            final RatingBar mRatingBar = (RatingBar) findViewById(R.id.rating);
            float starRating = mRatingBar.getRating();
            double baseCostDouble = Integer.parseInt(baseCost.getText().toString());
            double tipAmountDouble = 0;
            double totalCostDouble = 0;
            double tip = 0;

            if (starRating == 1) {
                tip = 0.125;
            } else if (starRating == 2) {
                tip = 0.15;
            } else if (starRating == 3) {
                tip = 0.175;
            } else if (starRating == 4) {
                tip = 0.2;
            } else {
                tip = 0.225;
            }

            tipAmountDouble = baseCostDouble * tip;
            tipAmount.setText("Tip Amount: $" + df.format(tipAmountDouble));

            totalCostDouble = baseCostDouble + tipAmountDouble;
            totalCost.setText("Total: $" + df.format(totalCostDouble));

        }

        catch(Exception e)
        {
            TextView tipAmount = (TextView) findViewById(R.id.tipAmount);
            TextView totalCost = (TextView) findViewById(R.id.totalCost);

            tipAmount.setText("Tip Amount: $0.00");
            totalCost.setText("Total: $0.00");
        }

    }

}




