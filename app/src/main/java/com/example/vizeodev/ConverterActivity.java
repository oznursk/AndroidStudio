package com.example.vizeodev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class ConverterActivity extends AppCompatActivity {
    EditText InputNumber;
    Spinner Unitspinner;
    TextView DecimalResult;
    Button buttonDecimal;
    ImageView temp, megabyte, decimal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        InputNumber = findViewById(R.id.InputNumber);
        Unitspinner = findViewById(R.id.Unitspinner);
        DecimalResult = findViewById(R.id.DecimalResult);
        buttonDecimal = findViewById(R.id.buttonDecimal);
        temp = findViewById(R.id.temp);
        megabyte = findViewById(R.id.megabyte);
        decimal = findViewById(R.id.decimal);


        String[] NumberBase = {"Binary", "Octal", "Hexadecimal"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, NumberBase);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Unitspinner.setAdapter(adapter);

        buttonDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConvertResult();
            }
        });

        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConverterActivity.this, TempConvert.class);
                startActivity(intent);
            }
        });
        megabyte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConverterActivity.this, MegaByteConvert.class);
                startActivity(intent);
            }
        });
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConverterActivity.this, ConverterActivity.class);
                startActivity(intent);
            }
        });

    }
    private void ConvertResult () {
            String decimalTo = InputNumber.getText().toString();

            if (decimalTo.isEmpty()&& decimalTo !=null) {
                DecimalResult.setText("Please input number!!");
                return;
            }
            if(decimalTo.equals(".")){
                DecimalResult.setText("invalid Operation!!");
                return;
            }
            int decimalInt = Integer.parseInt(decimalTo);
            String selected = Unitspinner.getSelectedItem().toString();
            String result = "";

            switch (selected){
                case "Binary":
                    result=Integer.toBinaryString(decimalInt);
                    break;
                case "Octal":
                    result=Integer.toOctalString(decimalInt);
                    break;
                case "Hexadecimal":
                    result=Integer.toHexString(decimalInt);
                    break;

            }
            DecimalResult.setText(result);
        }

    }
