package com.baiju.techanicaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Phone,FullName,Gender,Address_1,Address_2,PinCode;
    private Button Register,Check;
    private TextView District,State;
    boolean isAllFieldsChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Phone = findViewById(R.id.phone);
        FullName = findViewById(R.id.FullName);
        Address_1 = findViewById(R.id.Address_1);
        Address_2 = findViewById(R.id.Address_2);
        PinCode = findViewById(R.id.Pincode);

        Register = findViewById(R.id.Register);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isAllFieldsChecked = checkAllField();
                if (isAllFieldsChecked) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }
            }
        });

    }

    private boolean checkAllField(){

        final RadioGroup radioGroup = findViewById(R.id.radioGroup);
        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    String text = "You selected: ";
                    text += (R.id.radioMale == checkedId) ? "male" : "female";
                    Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                }
            });
        }


        if (Phone.length()==0)
        {
            Phone.setError("This Field is Mandatory");
            return false;
        }
        else if (Phone.length()<10)
        {
            Phone.setError("Phone Number must be 10 Digit");
            return false;
        }
        if (FullName.length()==0)
        {
            FullName.setError("This Field is Mandatory");
            return false;
        }
        else if (FullName.length()<4)
        {
            FullName.setError("Name must be 4 character");
            return false;
        }

        if (Address_1.length()==0){
            Address_1.setError("This Field is Mandatory");
            return false;
        } else if (Address_1.length()<10){

            Address_1.setError("Addres Must be 10 character");
            return false;
        }
        if (Address_2.length()==0){
            Address_2.setError("This Field is Mandatory");
            return false;
        } else if (Address_2.length()<10){

            Address_2.setError("Addres Must be 10 character");
            return false;
        }

        if (PinCode.length()==0)
        {
            PinCode.setError("This Field is Mandatory");
            return false;
        }
        else if (PinCode.length()<6)
        {
            PinCode.setError("Pin Code Number must be 6 Digit");
            return false;
        }

        return true;
    }
}















