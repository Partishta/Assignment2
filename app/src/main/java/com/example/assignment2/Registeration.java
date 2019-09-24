package com.example.assignment2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Registeration extends AppCompatActivity {
EditText fullName,eMail,password,confirmPassword,etGender,userType,occupation;
ImageButton ibBack;
TextView datePicker;
 Button register,cont;/*,male,female,others;*/
    RadioGroup rgGender;
 DatePickerDialog.OnDateSetListener onDateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);

        ibBack=findViewById(R.id.textView2);
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back=new Intent(Registeration.this,Login.class);
                startActivity(back);
                finish();
            }
        });

      datePicker=  findViewById(R.id.datePicker);
      rgGender=  findViewById(R.id.rg_register_gender);
      etGender=  findViewById(R.id.et_register_gender);
      fullName=findViewById(R.id.fullName);
      eMail=findViewById(R.id.eMail);
      password=findViewById(R.id.password);
      confirmPassword=findViewById(R.id.confirmPassword);
      userType=findViewById(R.id.userType);
      occupation=findViewById(R.id.occupation);
       cont=findViewById(R.id.cont);
       cont.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String fullname=fullName.getText().toString();
               String regexFullName = ("^[a-zA-Z\\s]*$");
               String email= eMail.getText().toString();
               String regexEmail = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$";
               String pass=password.getText().toString();
               String regexPassword = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
               String confirmpass=confirmPassword.getText().toString();
               String usertype=userType.getText().toString();
               String occu=occupation.getText().toString();
               String contin=cont.getText().toString();
                if(fullname.isEmpty()){
                    Toast.makeText(Registeration.this, "please enter full name", Toast.LENGTH_SHORT).show();
                }
                else if(!fullname.matches(regexFullName)){
                    Toast.makeText(Registeration.this, "please enter a valid full name", Toast.LENGTH_SHORT).show();
                }
                else if( email.isEmpty()){
                    Toast.makeText(Registeration.this, "please enter  email", Toast.LENGTH_SHORT).show();
                }
                else if(!email.matches(regexEmail)){
                    Toast.makeText(Registeration.this, "please enter a valid email", Toast.LENGTH_SHORT).show();
                }
                else if( pass.isEmpty()){
                    Toast.makeText(Registeration.this, "please enter  pass", Toast.LENGTH_SHORT).show();
                }
                else if(!pass.matches(regexPassword)){
                    Toast.makeText(Registeration.this, "please enter a valid password", Toast.LENGTH_SHORT).show();
                }
                else if( confirmpass.isEmpty()){
                    Toast.makeText(Registeration.this, "please enter  confirmpass", Toast.LENGTH_SHORT).show();
                }
                else if(!pass.equals(confirmpass)){
                    Toast.makeText(Registeration.this, "passwords do not match", Toast.LENGTH_SHORT).show();
                }
                else if( usertype.isEmpty()){
                    Toast.makeText(Registeration.this, "please enter  usertype", Toast.LENGTH_SHORT).show();
                }
                else if( occu.isEmpty()){
                    Toast.makeText(Registeration.this, "please enter  occupation", Toast.LENGTH_SHORT).show();
                }
                else{
                    Login.userList.add(new User(email,pass));
                    Toast.makeText(Registeration.this, "Successsfully registered", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Registeration.this,Login.class));

                }



//               startActivity(new Intent(Registeration.this,GenerateOtp.class));
           }
       });
      rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(RadioGroup group, int checkedId) {
              if(checkedId==R.id.rb_register_male){
                  etGender.setText("Male");
              }else if(checkedId==R.id.rb_register_female){
                  etGender.setText("Female");
              }else{
                  etGender.setText("Others");
              }
          }
      });
      datePicker.setOnClickListener(new View.OnClickListener() {
//          public void onGenderButtonClicked(View view){
//
//          }
         @Override
          public void onClick(View v) {
              Calendar cal=Calendar.getInstance();
              int year=cal.get(Calendar.YEAR);
              int month=cal.get(Calendar.MONTH);
              int day=cal.get(Calendar.DAY_OF_MONTH);
              DatePickerDialog dialog=new DatePickerDialog(
                      Registeration.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,onDateSetListener,year,month,day);
              dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
              dialog.show();
          }
      });



     onDateSetListener =new DatePickerDialog.OnDateSetListener(){
          @Override
          public void onDateSet(DatePicker view, int year, int month, int day) {
              month=month +1;
              Log.d("Date","onDateSet:mm/dd/yyy:" + month +"/" + day + "/" + year);
              String date=month +"/" + day + "/" + year;
              datePicker.setText(date);
          }
      };
    }
}
