package com.example.testapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleActivity extends AppCompatActivity {

    private TextView calcTextView;
    private Button eqlbutton;
    private Button clrbutton;
    private Button bkspbutton;

    List<Integer> buttonIds = Arrays.asList(
            R.id.button0, R.id.button1, R.id.button2, R.id.button3,
            R.id.button4, R.id.button5, R.id.button6, R.id.button7,
            R.id.button8, R.id.button9, R.id.addbutton, R.id.subbutton,
            R.id.mulbutton, R.id.divbutton, R.id.dotbutton
    );

    List<String> expression = new ArrayList<>();

    private void initButtonHandler(int buttonId) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(click -> {
            expression.add(button.getText().toString());
            updateCalcText();
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        /*Log.i("xD", "onCreate");*/
        for (int id : buttonIds) {
            initButtonHandler(id);
        }
        calcTextView = findViewById(R.id.calcTextView);
        eqlbutton = findViewById(R.id.eqlbutton);
        clrbutton = findViewById(R.id.clrbutton);
        bkspbutton = findViewById(R.id.bkspbutton);


        if(savedInstanceState != null) {
            expression = savedInstanceState.getStringArrayList("expression");
            updateCalcText();
        }
        else {
            calcTextView.setText("0");
        }

        eqlbutton.setOnClickListener(v -> {
            String string = new String();
            for (int i = 0; i < expression.size(); i++) {
                string += expression.get(i);
            }
            Expression ex = new Expression(string);
            if(!ex.checkSyntax()) {
                //calcTextView.setText("Syntax Error");
                Toast.makeText(getApplicationContext(), "Syntax Error", Toast.LENGTH_SHORT).show();
            }
            else {
                if(Double.toString(ex.calculate()).equalsIgnoreCase("nan")) {
                    Toast.makeText(getApplicationContext(), "Error: not a number!", Toast.LENGTH_SHORT).show();
                }
                else {
                    expression.clear();
                    expression.add(Double.toString(ex.calculate()));

                    updateCalcText();
                }
            }
        });

        clrbutton.setOnClickListener(v -> {
            expression.clear();
            calcTextView.setText("0");
        });

        bkspbutton.setOnClickListener(v -> {
            if(expression.size() > 1) {
                expression.remove(expression.size() - 1);
                updateCalcText();
            }
            else if(expression.size() == 1) {
                expression.clear();
                calcTextView.setText("0");
            }

        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putStringArrayList("expression", (ArrayList<String>) expression);
        super.onSaveInstanceState(outState);
    }

    private void updateCalcText() {
        String string = "";
        for (int i = 0; i < expression.size(); i++) {
            string += expression.get(i);
        }
        calcTextView.setText(string);
    }
}
