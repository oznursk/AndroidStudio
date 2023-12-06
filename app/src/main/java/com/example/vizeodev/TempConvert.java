package com.example.vizeodev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class TempConvert extends AppCompatActivity {
    TextView TempResult;
    RadioGroup radioGroup;
    RadioButton radioF, radioK;
    EditText InputTemp;
    Button ButtonTemp;
    ImageView temp, megabyte, decimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_convert);
        InputTemp = findViewById(R.id.InputTemp);
        TempResult = findViewById(R.id.TempResult);
        ButtonTemp = findViewById(R.id.ButtonTemp);
        radioK = findViewById(R.id.radioK);
        radioF = findViewById(R.id.radioF);
        temp = findViewById(R.id.temp);
        megabyte = findViewById(R.id.megabyte);
        decimal = findViewById(R.id.decimal);
        radioGroup= findViewById(R.id.radioGroup);
        ButtonTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConvertTemp();
            }
        });
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TempConvert.this, TempConvert.class);
                startActivity(intent);
            }
        });
        megabyte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TempConvert.this, MegaByteConvert.class);
                startActivity(intent);
            }
        });
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TempConvert.this, ConverterActivity.class);
                startActivity(intent);
            }
        });


    }

    public void ConvertTemp() {
        String tempTo = InputTemp.getText().toString();

        if (tempTo == null || tempTo.isEmpty()) {
            TempResult.setText("Please input temperature!!");
            return;
        }

        try {
            double tempValue = Double.parseDouble(tempTo);
            double resultTemp = 0;

            RadioGroup radioGroup = findViewById(R.id.radioGroup);
            RadioButton radioK = findViewById(R.id.radioK);
            RadioButton radioF = findViewById(R.id.radioF);

            int checkedId = radioGroup.getCheckedRadioButtonId();

            if (checkedId == R.id.radioK) {

                resultTemp = tempValue + 273.15;
                TempResult.setText(String.format("%.2f°K", resultTemp));
            } else if (checkedId == R.id.radioF) {

                resultTemp = (tempValue - 32) * 5/9;
                TempResult.setText(String.format("%.2f°F", resultTemp));
            }

        } catch (NumberFormatException e) {

            TempResult.setText("Invalid input! Please enter a valid temperature.");
        }
    }




}