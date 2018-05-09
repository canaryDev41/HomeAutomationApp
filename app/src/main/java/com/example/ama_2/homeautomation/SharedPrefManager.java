package com.example.ama_2.homeautomation;

import android.content.Context;
import android.content.SharedPreferences;


class SharedPrefManager {

    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private static final String SHARED_PREF_NAME = "mySharedPref13";

    private static final String KEY_FAN_ON = "KEY_FAN_ON";
    private static final String KEY_FAN_OFF = "KEY_FAN_OFF";

    private static final String KEY_LAMB_ON = "KEY_LAMB_ON";
    private static final String KEY_LAMB_OFF = "KEY_LAMB_OFF";

    private static final String KEY_CONDITIONING_ON = "KEY_CONDITIONING_ON";
    private static final String KEY_CONDITIONING_OFF = "KEY_CONDITIONING_OFF";

    private static final String KEY_PHONE_NO = "KEY_PHONE_NO";

    SharedPrefManager(Context context){
        mCtx = context;
    }

    static  synchronized SharedPrefManager getInstance(Context context){
        if (mInstance == null){
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    boolean setPhoneNoCode(String phone){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(KEY_PHONE_NO, phone);

        editor.apply();
        return true;
    }

    boolean setFanOnCode(String code){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(KEY_FAN_ON, code);

        editor.apply();
        return true;
    }

    boolean setFanOffCode(String code){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(KEY_FAN_OFF, code);

        editor.apply();
        return true;
    }

    boolean setLambOnCode(String code){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(KEY_LAMB_ON, code);

        editor.apply();
        return true;
    }

    boolean setLambOffCode(String code){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(KEY_LAMB_OFF, code);

        editor.apply();
        return true;
    }

    boolean setConditioningOnCode(String code){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(KEY_CONDITIONING_ON, code);

        editor.apply();
        return true;
    }

    boolean setConditioningOffCode(String code){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(KEY_CONDITIONING_OFF, code);

        editor.apply();
        return true;
    }

    String getPhoneNo(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_PHONE_NO, null);
    }

    String getLambOnCode() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_LAMB_ON, null);
    }

    String getLambOffCode() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_LAMB_OFF, null);
    }

    String getFanOnCode() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_FAN_ON, null);
    }

    String getFanOffCode() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_FAN_OFF, null);
    }

    String getConditioningOnCode() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_CONDITIONING_ON, null);
    }

    String getConditioningOffCode() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_CONDITIONING_OFF, null);
    }

}
