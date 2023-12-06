package com.example.vizeodev;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GirisActivity extends AppCompatActivity {
    Button convert_button,random_button,sms_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

        convert_button=findViewById(R.id.convert_button);
        random_button=findViewById(R.id.random_button);
        sms_button=findViewById(R.id.sms_button);

        convert_button.animate().translationY(-1100).setDuration(2700).setStartDelay(0);
        random_button.animate().translationY(-860).setDuration(2700).setStartDelay(0);
        sms_button.animate().translationY(-650).setDuration(2700).setStartDelay(0);


        convert_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GirisActivity.this,ConverterActivity.class);
                startActivity(intent);
            }
        });
        sms_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GirisActivity.this,SMS_Activity.class);
                startActivity(intent);
            }
        });
        random_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GirisActivity.this,RandomActivity.class);
                startActivity(intent);
            }
        });
    }
}