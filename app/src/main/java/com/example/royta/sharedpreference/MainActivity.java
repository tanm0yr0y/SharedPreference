package com.example.royta.sharedpreference;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    Button saveBtn;
    RadioGroup radioGroup;
    RadioButton radioButton;
    MySharedPref mySharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editText1.getText().toString();
                String age = editText2.getText().toString();
                int userAge = 0;

                if(userName.isEmpty()) {
                    editText1.setError("Name is required");
                    editText1.requestFocus();
                    return;
                }
                if(age.isEmpty()) {
                    editText2.setError("Age is required");
                    editText2.requestFocus();
                    return;
                }

                userAge = Integer.parseInt(age);
                int setId = radioGroup.getCheckedRadioButtonId();  //getCheckedRadioButtonId() returns the id of the RadioButton(or -1 if no RadioButtons are checked) that is checked in the Radiogroup

                if(setId == -1){
                    Toast.makeText(MainActivity.this, "Status is required", Toast.LENGTH_SHORT).show();
                    return;
                }

                saveName(userName);
                saveAge(userAge);

                radioButton = findViewById(setId);
                if(radioButton.getText().toString().equals("Student")) {
                    //saveStudentFlag();
                    saveStudentFlag();
                    falseJobFlag();

                }
                else if(radioButton.getText().toString().equals("Job Holder")) {
                    //saveJobFlag();
                    saveJobFlag();
                    falseStudentFlag();
                }

                showToast();
            }
        });

    }
    public void showToast() {
        Toast.makeText(this, "Your Name: " + mySharedPref.getUserName(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Your Age: " + mySharedPref.getAge(), Toast.LENGTH_SHORT).show();
        if(mySharedPref.getJobFlag()) {
            Toast.makeText(this, "You are a job holder.", Toast.LENGTH_SHORT).show();
        }
        else if(mySharedPref.getStudentFlag()) {
            Toast.makeText(this, "You are a student.", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "You are nothing!!", Toast.LENGTH_SHORT).show();
        }
    }
    public void init() {
        editText1 = findViewById(R.id.name);
        editText2 = findViewById(R.id.age);
        saveBtn = findViewById(R.id.save);
        radioGroup = findViewById(R.id.flag);
        mySharedPref = MySharedPref.getMySharedPref(this);

    }

    public void saveName(String name) {
        mySharedPref.setUserName(name);
    }
    public void saveAge(int age) {
        mySharedPref.setAge(age);
    }
    public void saveJobFlag() {
        mySharedPref.setJobFlag();
    }
    public void falseJobFlag() {
        mySharedPref.unsetJobFlag();
    }
    public void saveStudentFlag() {
        mySharedPref.setStudentFlag();
    }
    public void falseStudentFlag() {
        mySharedPref.unsetStudentFlag();
    }
}
