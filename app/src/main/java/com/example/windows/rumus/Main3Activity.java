package com.example.windows.rumus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {
private EditText eArus;
private EditText eTegangan;
private Button bHitung;
private TextView tHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        eArus = findViewById(R.id.arus);
        eTegangan = findViewById(R.id.tegangan);
        bHitung = findViewById(R.id.bhitung);
        tHasil = findViewById(R.id.thasil);
        bHitung.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bhitung) {
            String inputArus = eArus.getText().toString().trim();
            String inputTegangan = eTegangan.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputArus)) {
                isEmptyFields = true;
                eArus.setError("Jangan Kosong Dong");
            }
            if (TextUtils.isEmpty(inputTegangan)) {
                isEmptyFields = true;
                eTegangan.setError("Jangan Kosong Dong");
            }


            Double arus = toDouble(inputArus);
            Double tegangan = toDouble(inputTegangan);

            if (arus == null) {
                isInvalidDouble = true;
                eArus.setError("Nomor Harus Sesuai");
            }
            if (tegangan == null) {
                isInvalidDouble = true;
                eTegangan.setError("Nomor Harus Sesuai");
            }

            if (!isEmptyFields && !isInvalidDouble) {
                double volume = arus * tegangan;
                tHasil.setText(String.valueOf(volume));
            }
        }
    }

    private Double toDouble(String string) {
        try{
            return Double.valueOf(string);
        }catch (NumberFormatException e){
            return null;
        }
    }

    private static final String STATE_RESULT = "state_result";
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tHasil.getText().toString());
    }
}
