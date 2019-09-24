package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class GenerateOtp extends AppCompatActivity {
    private EditText otp_1,otp_2,otp_3,otp_4;
    ImageButton ibBack;
    Button reSend,submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate__otp);

        ibBack=findViewById(R.id.textView10);
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back=new Intent(GenerateOtp.this,Login.class);
                startActivity(back);
                finish();
            }
        });

        otp_1=findViewById(R.id.otp_1);
        otp_2=findViewById(R.id.otp_2);
        otp_3=findViewById(R.id.otp_3);
        otp_4=findViewById(R.id.otp_4);
        onclick();
        reSend = findViewById(R.id.reSend);
        submit = findViewById(R.id.submit);
        reSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otp_1.getText().clear();
                otp_2.getText().clear();
                otp_3.getText().clear();
                otp_4.getText().clear();
                otp_1.requestFocus();
                Toast.makeText(GenerateOtp.this, "OTP Sent!!", Toast.LENGTH_SHORT).show();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inpuOtp1=otp_1.getText().toString();
                String inpuOtp2=otp_2.getText().toString();
                String inpuOtp3=otp_3.getText().toString();
                String inpuOtp4=otp_4.getText().toString();
                if(inpuOtp1.isEmpty() || inpuOtp2.isEmpty() || inpuOtp3.isEmpty() || inpuOtp4.isEmpty()){
                    Toast.makeText(GenerateOtp.this, "Enter otp", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(GenerateOtp.this, Login.class);
                    startActivity(intent);
                }
            }
        });
    }
    public void onclick(){

        otp_1.requestFocus();
        otp_1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            otp_2.requestFocus();
            }
        });
//        otp_2.requestFocus();
        otp_2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            otp_3.requestFocus();
            }
        });
        otp_3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            otp_4.requestFocus();
            }
        });


    }
}
