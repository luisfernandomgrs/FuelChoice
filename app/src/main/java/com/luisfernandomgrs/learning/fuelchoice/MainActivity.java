package com.luisfernandomgrs.learning.fuelchoice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText txtInputFuel1;
    private TextInputEditText txtInputFuel2;
    private TextView txtMessageResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(getString(R.string.app_title));

        txtInputFuel1 = findViewById(R.id.txtInputFuel1);
        txtInputFuel2 = findViewById(R.id.txtInputFuel2);
        txtMessageResult = findViewById(R.id.txtMessageResult);
    }

    public void fnCalcular(View view) {
        String sInputFuel1, sInputFuel2;

        sInputFuel1 = txtInputFuel1.getText().toString();
        sInputFuel2 = txtInputFuel2.getText().toString();

        if (isValidFillFields(sInputFuel1, sInputFuel2)) {
            double dInputFuel1, dInputFuel2, dCompareValues;
            boolean bCompareValues;

            dInputFuel1 = Double.parseDouble(sInputFuel1);
            dInputFuel2 = Double.parseDouble(sInputFuel2);
            dCompareValues = dInputFuel1 / dInputFuel2;
            bCompareValues = (dCompareValues >= 0.7) ? true : false;

            if (bCompareValues)
                txtMessageResult.setText("Prefira usar Gasolina");
            else
                txtMessageResult.setText("Prefira usar Álcool");
        }
        else
            txtMessageResult.setText("Por favor, Preencha todos os valores!");
    }

    private  boolean isValidFillFields(String sInputFuel1, String sInputFuel2) {
        boolean bReturn = true;

        if ((sInputFuel1 == null) || sInputFuel1.trim().equals(""))
            bReturn = false;

        else if ((sInputFuel2 == null) || sInputFuel2.trim().equals(""))
            bReturn = false;

        return bReturn;
    }
}