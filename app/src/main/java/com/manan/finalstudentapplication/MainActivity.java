package com.manan.finalstudentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public String Gender;
    Button btn,btn1;
    EditText Name,Enrollment,Age;
    RadioGroup Sex;
    private DbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.Insertdata);
        btn1 = findViewById(R.id.display);
        Name =findViewById(R.id.Name);
        Enrollment = findViewById(R.id.Enrollment);
        Age = findViewById(R.id.Age);
        Sex = findViewById(R.id.Gender);
        dbHandler = new DbHandler(MainActivity.this);
//        dbHandler.addalldata("Manan","2022007109010155","22","Male");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= Name.getText().toString();
                String enrollment = Enrollment.getText().toString();
                String age = Age.getText().toString();
                if(name.isEmpty())
                {
                    Name.setError("Please enter the name");
                }
                else if(enrollment.isEmpty())
                {
                    Enrollment.setError("Please enter the enrollment");
                }
                else  if(age.isEmpty())
                {
                    Age.setError("Please enter the age");
                }
                else if(Sex.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(MainActivity.this, "Please select gender", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    dbHandler.addalldata(name,enrollment,age,Gender);
                    Toast.makeText(MainActivity.this, "Data add successfully", Toast.LENGTH_SHORT).show();
                }


            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(MainActivity.this,showall.class);
                startActivity(i);
            }
        });


    }
    public void gendercheck(View view)
    {
        Boolean c = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.Male:
                Gender="Male";
                Toast.makeText(this, "Male", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Female:
                Gender="Female";
                Toast.makeText(this, "Female", Toast.LENGTH_SHORT).show();
        }

    }

}