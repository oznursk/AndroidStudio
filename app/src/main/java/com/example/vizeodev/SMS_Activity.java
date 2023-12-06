package com.example.vizeodev;

import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.telephony.SmsManager;
import android.widget.Toast;
import android.Manifest;

public class SMS_Activity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_SMS = 1;
    private EditText textPhone, textMesagge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsactivity);

        Button buttonSMS = findViewById(R.id.buttonSMS);
        textMesagge = findViewById(R.id.textMesagge);
        textPhone = findViewById(R.id.textPhone);

        buttonSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(SMS_Activity.this, Manifest.permission.SEND_SMS)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(SMS_Activity.this,
                            new String[]{Manifest.permission.SEND_SMS}, PERMISSION_REQUEST_SMS);
                } else {
                    sendSMS();
                }
            }
        });
    }

    private void sendSMS() {
        String phoneNum = textPhone.getText().toString();
        String mesagge = textMesagge.getText().toString();

        if (TextUtils.isEmpty(phoneNum) ) {
            showToast("Please write phone number.");
            return;
        }
        if (TextUtils.isEmpty(mesagge) ) {
            showToast("Please write message.");
            return;
        }

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNum, null, mesagge, null, null);
            showToast("Sms send");
        } catch (Exception e) {
            e.printStackTrace();
            showToast("Sms error");
        }
    }

    private void showToast(String mesagge) {
        Toast.makeText(this, mesagge, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_REQUEST_SMS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                sendSMS();
            } else {
                showToast("SMS gönderme izni reddedildi.");
            }
        }
    }
}