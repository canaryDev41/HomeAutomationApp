package com.example.ama_2.homeautomation;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    Button btnAbout, btnExit, btnSettings;
    Switch switchLamb, switchVan, switchConditioning, SwitchGarageDoor;

    CompoundButton currentSwitch;
    boolean isChecked;

    SharedPrefManager shared;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAbout = (Button)findViewById(R.id.btnAbout);
        btnExit = (Button)findViewById(R.id.btnExit);
        btnSettings = (Button)findViewById(R.id.btnSettings);

        switchLamb = (Switch)findViewById(R.id.switchLamb);
        switchVan = (Switch)findViewById(R.id.switchFan);
        switchConditioning = (Switch)findViewById(R.id.switchConditioning);
        SwitchGarageDoor = (Switch)findViewById(R.id.SwitchGarageDoor);

        btnAbout.setOnClickListener(this);
        btnExit.setOnClickListener(this);
        btnSettings.setOnClickListener(this);

        switchLamb.setOnCheckedChangeListener(this);
        switchVan.setOnCheckedChangeListener(this);
        switchConditioning.setOnCheckedChangeListener(this);
        SwitchGarageDoor.setOnCheckedChangeListener(this);

        shared = new SharedPrefManager(getApplicationContext());

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnAbout:
                startActivity(new Intent(this, About.class));
                break;
            case R.id.btnExit:
                finish();
                break;
            case R.id.btnSettings:
                startActivity(new Intent(this, com.example.ama_2.homeautomation.Settings.class));
        }

    }

    private void sendSms(String phone, String message){
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phone, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS Sent!", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),"SMS failed!",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    private void performMessage(CompoundButton buttonView,final boolean isChecked){
        if  (shared.getPhoneNo() == null){
            Toast.makeText(this, "Sorry there is no phone number\n! Check your application settings first!", Toast.LENGTH_LONG).show();
            return;
        }

        switch (buttonView.getId()){
            case R.id.switchLamb:
                if (!isChecked)
                    sendSms(shared.getPhoneNo(),shared.getLambOffCode());
                else
                    sendSms(shared.getPhoneNo(),shared.getLambOnCode());
            break;
            case R.id.switchFan:
                if (!isChecked)
                    sendSms(shared.getPhoneNo(),shared.getFanOffCode());
                else
                    sendSms(shared.getPhoneNo(),shared.getFanOnCode());
            break;
            case R.id.switchConditioning:
                if (!isChecked)
                    sendSms(shared.getPhoneNo(),shared.getConditioningOffCode());
                else
                    sendSms(shared.getPhoneNo(),shared.getConditioningOnCode());
            break;
            case R.id.SwitchGarageDoor:
                if (!isChecked)
                    sendSms(shared.getPhoneNo(),shared.getGarageDoorOffCode());
                else
                    sendSms(shared.getPhoneNo(),shared.getGarageDoorOnCode());
            break;
        }

    }


    private boolean isPermissionGranted(){
        return ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {

        currentSwitch = buttonView;
        this.isChecked = isChecked;

        if(isPermissionGranted()){
            // Send SMS permission granted
            performMessage(currentSwitch, isChecked);

        }else{
            // Send SMS permission not granted
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS},1);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == 0) {
            //permission granted successfully
            performMessage(currentSwitch, isChecked);
        }else{
            Toast.makeText(this, "Please Allow App to Send SMS First, Then Try Again!", Toast.LENGTH_LONG).show();
        }
    }

}
