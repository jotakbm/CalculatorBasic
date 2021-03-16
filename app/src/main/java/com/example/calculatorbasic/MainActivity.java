package com.example.calculatorbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bttPlus;
    private Button bttMinus;
    private Button bttMultiply;
    private Button bttDivision;

    private TextView value01txt;
    private TextView value02txt;
    private TextView result;

    private double value01;
    private double value02;

    enum Operation {Addition, Subtraction, Mutiplication, Division}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();
    }

    private void setupUIViews() {

        bttPlus = (Button) findViewById(R.id.button_Plus);
        bttMinus = (Button) findViewById(R.id.button_Minus);
        bttMultiply = (Button) findViewById(R.id.button_Multiply);
        bttDivision = (Button) findViewById(R.id.button_Division);
        value01txt = (TextView) findViewById(R.id.editTextNumber_Val01);
        value02txt = (TextView) findViewById(R.id.editTextNumber_Val02);
        result = (TextView) findViewById(R.id.textView_Result);
    }

    public void ButtonPlusClicked(View view) {
        result.setText(GetResult(Operation.Addition));
    }

    public void ButtonMinusClicked(View view) {
        result.setText(GetResult(Operation.Subtraction));
    }

    public void ButtonMultiplyClicked(View view) {
        result.setText(GetResult(Operation.Mutiplication));
    }

    public void ButtonDivisionClicked(View view) {
        result.setText(GetResult(Operation.Division));
    }

    private String GetResult(Operation op) {
        if (value01txt.getText().toString().isEmpty() || value02txt.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Insira ambos os valores a serem calculados.", Toast.LENGTH_SHORT).show();
        } else {
            value01 = Double.parseDouble(value01txt.getText().toString());
            value02 = Double.parseDouble(value02txt.getText().toString());

            switch (op) {
                case Addition:
                    return String.valueOf(value01 + value02);
                case Subtraction:
                    return String.valueOf(value01 - value02);
                case Mutiplication:
                    return String.valueOf(value01 * value02);
                case Division:
                    if (value02 == 0)
                        Toast.makeText(getApplicationContext(), "É impossivel realizar uma divisão por zero.", Toast.LENGTH_SHORT).show();
                    else
                        return String.valueOf(value01 / value02);
            }
        }
        return "ERROR";
    }
}