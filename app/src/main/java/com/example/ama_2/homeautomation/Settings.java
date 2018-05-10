package com.example.ama_2.homeautomation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Settings extends AppCompatActivity implements View.OnClickListener{
    EditText etPhoneNo, etLambOff, etLambOn, etFanOff, etFanOn, etConditioningOff, etConditioningOn, etGarageDoorOff, etGarageDoorOn;

    Button btnSave, btnBack;

    String lambOnCode;
    String lambOffCode;
    String fanOnCode;
    String fanOffCode;
    String conditioningOnCode;
    String conditioningOffCode;
    String garageDoorOnCode;
    String garageDoorOffCode;
    String phoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        etPhoneNo = (EditText)findViewById(R.id.etPhoneNo);
        etLambOff = (EditText)findViewById(R.id.etLambOff);
        etLambOn = (EditText)findViewById(R.id.etLambOn);
        etFanOff = (EditText)findViewById(R.id.etFanOff);
        etFanOn = (EditText)findViewById(R.id.etFanOn);
        etConditioningOff = (EditText)findViewById(R.id.etConditioningOff);
        etConditioningOn = (EditText)findViewById(R.id.etConditioningOn);
        etGarageDoorOff = (EditText)findViewById(R.id.etGarageDoorOff);
        etGarageDoorOn = (EditText)findViewById(R.id.etGarageDoorOn);

        fillCodes();

        btnBack = (Button)findViewById(R.id.btnBack);
        btnSave = (Button)findViewById(R.id.btnSave);

        btnBack.setOnClickListener(this);
        btnSave.setOnClickListener(this);

    }

    private void fillCodes() {
        SharedPrefManager shared = SharedPrefManager.getInstance(getApplicationContext());

        etPhoneNo.setText(shared.getPhoneNo());
        etLambOff.setText(shared.getLambOffCode());
        etLambOn.setText(shared.getLambOnCode());
        etFanOff.setText(shared.getFanOffCode());
        etFanOn.setText(shared.getFanOnCode());
        etConditioningOff.setText(shared.getConditioningOffCode());
        etConditioningOn.setText(shared.getConditioningOnCode());
        etGarageDoorOff.setText(shared.getGarageDoorOffCode());
        etGarageDoorOn.setText(shared.getGarageDoorOnCode());
    }

    private boolean validate(){
        return !(phoneNo.equals("") || lambOnCode.equals("") || lambOffCode.equals("") || fanOffCode.equals("") || fanOnCode.equals("") || conditioningOffCode.equals("") || conditioningOnCode.equals("") || garageDoorOffCode.equals("") || garageDoorOnCode.equals(""));
    }

    @Override
    public void onClick(View v) {
        if (v == btnSave){

            lambOnCode = etLambOn.getText().toString();
            lambOffCode = etLambOff.getText().toString();
            fanOnCode = etFanOn.getText().toString();
            fanOffCode = etFanOff.getText().toString();
            conditioningOnCode = etConditioningOn.getText().toString();
            conditioningOffCode = etConditioningOff.getText().toString();
            garageDoorOnCode = etGarageDoorOn.getText().toString();
            garageDoorOffCode = etGarageDoorOff.getText().toString();

            phoneNo = etPhoneNo.getText().toString();

            if (!validate()){

                Toast.makeText(getApplicationContext(), "you must fill out all the fields", Toast.LENGTH_LONG).show();

            }else{
                SharedPrefManager.getInstance(getApplicationContext()).setLambOnCode(lambOnCode);
                SharedPrefManager.getInstance(getApplicationContext()).setLambOffCode(lambOffCode);

                SharedPrefManager.getInstance(getApplicationContext()).setFanOffCode(fanOffCode);
                SharedPrefManager.getInstance(getApplicationContext()).setFanOnCode(fanOnCode);

                SharedPrefManager.getInstance(getApplicationContext()).setConditioningOffCode(conditioningOffCode);
                SharedPrefManager.getInstance(getApplicationContext()).setConditioningOnCode(conditioningOnCode);

                SharedPrefManager.getInstance(getApplicationContext()).setGarageDoorOffCode(garageDoorOffCode);
                SharedPrefManager.getInstance(getApplicationContext()).setGarageDoorOnCode(garageDoorOnCode);

                SharedPrefManager.getInstance(getApplicationContext()).setPhoneNoCode(phoneNo);

                Toast.makeText(this, "Data Saved Successfully!", Toast.LENGTH_LONG).show();
            }

        }else if(v == btnBack){
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}