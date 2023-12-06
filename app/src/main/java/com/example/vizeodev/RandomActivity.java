package com.example.vizeodev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.view.Gravity;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.Random;

public class RandomActivity extends AppCompatActivity {
    private EditText amount, min, max;
    private LinearLayout linearLayout;
    private ScrollView scrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        linearLayout = findViewById(R.id.IDlinear);
        scrollView = findViewById(R.id.scrollView);


        amount= findViewById(R.id.numberAmount);
        min=findViewById(R.id.numberMin);
        max=findViewById(R.id.numberMax);
    }

    public void Create(View view) {
        try {

            int amountValue = Integer.parseInt(amount.getText().toString());
            int minValue = Integer.parseInt(min.getText().toString());
            int maxValue = Integer.parseInt(max.getText().toString());

            linearLayout.removeAllViews();
            for (int i = 0; i < amountValue; i++) {
                int randomValue = getRandomValue(minValue, maxValue);
                ProgressBar progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
                progressBar.setMax(maxValue - minValue);
                progressBar.setProgress(randomValue - minValue);

                linearLayout.addView(progressBar);
                TextView textView = new TextView(this);
                TextView textLeft =new TextView(this);
                textLeft.setGravity(Gravity.START);
                textLeft.setText(String.format(String.valueOf(minValue)));
                TextView textRight =new TextView(this);
                textRight.setText(String.format(String.valueOf(maxValue)));
                textRight.setGravity(Gravity.END);
                textView.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                textView.setGravity(Gravity.CENTER);
                textView.setText(String.format("Değer:%d, Yüzde:%d%%", randomValue,
                        calculatePercentage(minValue, maxValue, randomValue)));


                linearLayout.addView(textView);
                linearLayout.addView(textRight);
                linearLayout.addView(textLeft);


            }

            scrollView.fullScroll(ScrollView.FOCUS_DOWN);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getRandomValue(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    private int calculatePercentage(int min, int max, int value) {
        return (int) (((float) (value - min) / (max - min)) * 100);
    }
}

