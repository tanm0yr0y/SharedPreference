package com.example.royta.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPref {
    private static MySharedPref mySharedPref;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private MySharedPref(Context context) {
        sharedPreferences = context.getSharedPreferences(Config.Shared_Preference_Name, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();
    }

    public static MySharedPref getMySharedPref(Context context) {
        if(mySharedPref == null) {
            mySharedPref = new MySharedPref(context);
        }
        return mySharedPref;
    }

    public void setUserName(String userName) {
        editor.putString(Config.USER_NAME, userName);
        editor.apply();
    }
    public String getUserName() {
        return sharedPreferences.getString(Config.USER_NAME, "No_Name_Found");
    }
    public void setAge(int age) {
        editor.putInt(Config.USER_AGE, age);
        editor.apply();
    }
    public int getAge() {
        return sharedPreferences.getInt(Config.USER_AGE, -1);
    }
    public void setStudentFlag() {
        editor.putBoolean(Config.IS_STUDENT, true);
        editor.apply();
    }
    public void unsetStudentFlag() {
        editor.putBoolean(Config.IS_STUDENT, false);
        editor.apply();
    }
    public boolean getStudentFlag() {
        return sharedPreferences.getBoolean(Config.IS_STUDENT, false);
    }

    public void setJobFlag() {
        editor.putBoolean(Config.IS_JOB_HOLDER, true);
        editor.apply();
    }
    public void unsetJobFlag() {
        editor.putBoolean(Config.IS_JOB_HOLDER, false);
        editor.apply();
    }
    public boolean getJobFlag() {
        return sharedPreferences.getBoolean(Config.IS_JOB_HOLDER, false);
    }

}
