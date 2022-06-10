package com.example.gpa_jariwalas1_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ed1, ed2, ed3, ed4, ed5, ed6;
    int flag= 0;
    Button  btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.gcourse1);
        ed2 = findViewById(R.id.gcourse2);
        ed3 = findViewById(R.id.gcourse3);
        ed4 = findViewById(R.id.gcourse4);
        ed5 = findViewById(R.id.gcourse5);
        ed6 = findViewById(R.id.gpacount);

        {
            if (ed1.length() == 0) {
                ed1.requestFocus();
                ed1.setError("Field cannot be empty!");
            }
        }
        if (ed2.length() == 0) {
            ed2.requestFocus();
            ed2.setError("Field cannot be empty!");
        }
        if (ed3.length() == 0) {
            ed3.requestFocus();
            ed3.setError("Field cannot be empty!");
        }
        if (ed4.length() == 0) {
            ed4.requestFocus();
            ed4.setError("Field cannot be empty!");

        }
        if (ed5.length() == 0) {
            ed5.requestFocus();
            ed5.setError("Field cannot be empty!");
        }

        btn1 =findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CNT();
                CLEAR();

            }
        });

    }

    public  void CNT()
    {
        int m1, m2, m3, m4, m5;
        int tot;
        int avg;

        if (flag % 2 == 0) {
            if (ed1.getText().toString().equals("") || ed2.getText().toString().equals("") || ed3.getText().toString().equals("") || ed4.getText().toString().equals("") || ed5.getText().toString().equals(""))
            {
                ed6.setText("ENTER ALL GRADES IN THE FIELD");
            }
            else {
                m1 = Integer.parseInt(ed1.getText().toString());
                m2 = Integer.parseInt(ed2.getText().toString());
                m3 = Integer.parseInt(ed3.getText().toString());
                m4 = Integer.parseInt(ed4.getText().toString());
                m5 = Integer.parseInt(ed5.getText().toString());

                tot = m1 + m2 + m3 + m4 + m5;
                avg = tot / 5;

                if (avg < 60) {
                    ed6.setBackgroundColor(Color.RED);
                    ed6.setText(String.valueOf(avg));
                } else if (avg > 60 && avg < 80) {
                    ed6.setBackgroundColor(Color.YELLOW);
                    ed6.setText(String.valueOf(avg));
                } else if (avg >= 80 && avg <= 100) {
                    ed6.setBackgroundColor(Color.GREEN);
                    ed6.setText(String.valueOf(avg));
                } else {
                    ed6.setBackgroundColor(Color.BLUE);
                }
                flag++;
            }}
                else
                {
                    ed1.setText("");
                    ed2.setText("");
                    ed3.setText("");
                    ed4.setText("");
                    ed5.setText("");
                    ed6.setText("");
                    btn1.setText("Compute GPA");
                }
    }
    public void CLEAR()
    {
        btn1.setText("Clear");
       // ed6.getText().clear();
    }
}