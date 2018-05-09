package com.example.ama_2.homeautomation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Settings extends AppCompatActivity implements View.OnClickListener{
    EditText etPhoneNo, etLambOff, etLambOn, etFanOff, etFanOn, etConditioningOff, etConditioningOn;

    Button btnSave, btnBack;

    String lambOnCode;
    String lambOffCode;
    String fanOnCode;
    String fanOffCode;
    String conditioningOnCode;
    String conditioningOffCode;
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

            phoneNo = etPhoneNo.getText().toString();

            if (phoneNo.equals("") || lambOnCode.equals("") || lambOffCode.equals("") || fanOffCode.equals("") || fanOnCode.equals("") || conditioningOffCode.equals("") || conditioningOnCode.equals("")){

                Toast.makeText(getApplicationContext(), "you must fill out all the fields", Toast.LENGTH_LONG).show();

            }else{
                SharedPrefManager.getInstance(getApplicationContext()).setLambOnCode(lambOnCode);
                SharedPrefManager.getInstance(getApplicationContext()).setLambOffCode(lambOffCode);

                SharedPrefManager.getInstance(getApplicationContext()).setFanOffCode(fanOffCode);
                SharedPrefManager.getInstance(getApplicationContext()).setFanOnCode(fanOnCode);

                SharedPrefManager.getInstance(getApplicationContext()).setConditioningOffCode(conditioningOffCode);
                SharedPrefManager.getInstance(getApplicationContext()).setConditioningOnCode(conditioningOnCode);

                SharedPrefManager.getInstance(getApplicationContext()).setPhoneNoCode(phoneNo);
            }

        }else if(v == btnBack){
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}