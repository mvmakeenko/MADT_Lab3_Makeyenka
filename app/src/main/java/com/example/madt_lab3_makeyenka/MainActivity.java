package com.example.madt_lab3_makeyenka;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends Activity implements View.OnClickListener {
    float cache = 0;
    float res = 0;
    float temp = 0;
    boolean isNum = true;
    int num = 0;
    String sign = "+";
    String cache_sign = "+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1= (Button) findViewById(R.id.n1);
        Button b2= (Button) findViewById(R.id.n2);
        Button b3= (Button) findViewById(R.id.n3);
        Button b4= (Button) findViewById(R.id.n4);
        Button b5= (Button) findViewById(R.id.n5);
        Button b6= (Button) findViewById(R.id.n6);
        Button b7= (Button) findViewById(R.id.n7);
        Button b8= (Button) findViewById(R.id.n8);
        Button b9= (Button) findViewById(R.id.n9);
        Button bPlus = (Button) findViewById(R.id.plus);
        Button bMinus = (Button) findViewById(R.id.minus);
        Button bMult = (Button) findViewById(R.id.mult);
        Button bDiv = (Button) findViewById(R.id.div);
        Button bSqrt = (Button) findViewById(R.id.sqrt);
        Button bSign = (Button) findViewById(R.id.sign);
        Button bClear = (Button) findViewById(R.id.clear);
        Button bBack = (Button) findViewById(R.id.back);
        Button bEqu = (Button) findViewById(R.id.eq);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        bPlus.setOnClickListener(this);
        bMinus.setOnClickListener(this);
        bMult.setOnClickListener(this);
        bDiv.setOnClickListener(this);
        bSqrt.setOnClickListener(this);
        bSign.setOnClickListener(this);
        bClear.setOnClickListener(this);
        bBack.setOnClickListener(this);
        bEqu.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        TextView screen = findViewById(R.id.tempScreen);
        int id = v.getId();


        Button b = (Button) findViewById(id);
        if (id == R.id.plus || id == R.id.minus || id == R.id.mult || id == R.id.div) {
            cache = res;
            if (!isNum) sign = cache_sign;
            res = calculator(res, sign, temp);
            temp = 0;
            screen.setText(Float.toString(res));
            isNum = false;
            sign = (String) b.getText();
        }
        else if (id == R.id.sqrt || id == R.id.sign) {
            //if (!isNum) sign = cache_sign;
            //res = calculator(res, sign, temp);
            cache = res;
            res = calculator(res, (String) b.getText(), 0);
            screen.setText(Float.toString(res));
            isNum = true;
            temp = 0;
            sign = "";
        }
        else if (id == R.id.eq) {
            if (!isNum) sign = cache_sign;
            cache = res;
            res = calculator(res, sign, temp);
            screen.setText(Float.toString(res));
            isNum = false;
            temp = 0;
            sign = "";
        }
        else if (id == R.id.clear) {
            cache = res;
            res = 0;
            screen.setText(Float.toString(res));
            isNum = true;
            temp = 0;
            sign = "+";
            cache_sign = "";
        }
        else if (id == R.id.back) {
            res = cache;
            screen.setText(Float.toString(res));
            isNum = true;
            temp = 0;
            sign = cache_sign;
        }
        else {
            num = Integer.parseInt(b.getText().toString());
            if (!isNum) cache_sign = sign;
            temp = temp * 10 + num;
            isNum = true;
            screen.setText(Float.toString(temp));
        }
    }

    public float calculator (float num1, String sign, float num2) {
        switch (sign) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "-X":
                return (num1 * (-1));
            case "*":
                return num1 * num2;
            case "/":
                return num1/num2;
            case "√":
                return (float) Math.sqrt(num1);
            default:
                return num1;

        }
    }

}