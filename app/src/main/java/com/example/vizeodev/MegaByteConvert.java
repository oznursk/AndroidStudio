package com.example.vizeodev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MegaByteConvert extends AppCompatActivity {
    TextView ByteResult;
    EditText InputByte;
    Spinner Bytespinner;
    Button ButtonByte;
    ImageView temp,megabyte,decimal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mega_byte_convert);
        InputByte=findViewById(R.id.InputByte);
        ByteResult=findViewById(R.id.ByteResult);
        Bytespinner=findViewById(R.id.Bytespinner);
        ButtonByte=findViewById(R.id.ButtonByte);
        temp=findViewById(R.id.temp);
        megabyte=findViewById(R.id.megabyte);
        decimal=findViewById(R.id.decimal);

        String[] NumberByte = {"kilo Byte", "Byte", "Kibi Byte","Bit"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, NumberByte);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Bytespinner.setAdapter(adapter);

        ButtonByte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ConvertByte();
            }
        });

        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MegaByteConvert.this, TempConvert.class);
                startActivity(intent);
            }
        });
        megabyte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MegaByteConvert.this,MegaByteConvert.class);
                startActivity(intent);
            }
        });
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MegaByteConvert.this,ConverterActivity.class);
                startActivity(intent);
            }
        });



    }
    public void ConvertByte() {
        String byteTo = InputByte.getText().toString();

        if (byteTo == null || byteTo.isEmpty()) {
            ByteResult.setText("Please input number!!");
            return;
        }

        try {
            double byteDouble = Double.parseDouble(byteTo);
            String selectedByte = Bytespinner.getSelectedItem().toString();
            double resultByte = 0;

            switch (selectedByte) {
                case "kilo Byte":
                    resultByte = byteDouble * 1000;
                    break;
                case "Byte":
                    resultByte = byteDouble * 1E6;
                    break;
                case "Kibi Byte":
                    resultByte = byteDouble * 7812.5;
                    break;
                case "Bit":
                    resultByte = byteDouble * 8000000;
                    break;
            }

            ByteResult.setText(String.valueOf(resultByte));

        } catch (NumberFormatException e) {
            // Kullanıcı doğru bir sayı girmemişse bu hatayı ele al
            ByteResult.setText("Invalid input! Please enter a valid number.");
        }
    }

}

