package com.example.assignment2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
EditText eMail,password;
TextView register;
Button submit;
    public static  ArrayList <User> userList =new ArrayList<User>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        onclick();
        userList.add(new User("sp123@gmail.com","Abcd@1234"));
    }
public  void onclick() {
        eMail=findViewById(R.id.eMail);
        password=findViewById(R.id.password);
        submit=findViewById(R.id.submit);
     register = findViewById(R.id.register);

     String text = "Don't Have an Account. Register";



// initialize a new ClickableSpan
    ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(View view) {
//            Toast.makeText(Login.this, "Register", Toast.LENGTH_SHORT).show();
            Intent i=new Intent( Login.this,Registeration.class);
            startActivity(i);
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            int color = ContextCompat.getColor(Login.this, R.color.colorAccent);
            ds.setColor(color);
            ds.setUnderlineText(false);
        }
    };

// initialize a new SpannableStringBuilder instance
    SpannableStringBuilder ssBuilder = new SpannableStringBuilder(text);

// apply the clickable text to the span
    ssBuilder.setSpan(
            clickableSpan, // span to add
            text.indexOf("Register"), // start of the span (inclusive)
            text.indexOf("Register") + String.valueOf("Register").length(), // end of the span (exclusive)
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE // do not extend the span when text add later
    );


// bold
    ssBuilder.setSpan(
            new StyleSpan(Typeface.BOLD),
            text.indexOf("Register"),
            text.indexOf("Register") + String.valueOf("Register").length(),
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    );

    register.setText(ssBuilder);

// this step is mandated for the url and clickable styles
    register.setMovementMethod(LinkMovementMethod.getInstance());
    register.setHighlightColor(Color.TRANSPARENT);


    submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final String emails=eMail.getText().toString().trim();
            final String inpass=password.getText().toString().trim();
            if(emails.isEmpty()){
                Toast.makeText(Login.this, "Enter email", Toast.LENGTH_SHORT).show();
            }
            else if(inpass.isEmpty()){
                Toast.makeText(Login.this, "Enter Pass", Toast.LENGTH_SHORT).show();
            }
            else if(!emails.isEmpty()){
                for(int j=0;j<userList.size();j++){
                    if(userList.get(j).getEmail().equals( emails) && userList.get(j).getPassword().equals(inpass)){
                        startActivity(new Intent(Login.this, GenerateOtp.class));
                        Toast.makeText(Login.this, "Welcome", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Login.this, "user not registered", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    });
}
}
