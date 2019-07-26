package com.example.windows.rumus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
private EditText eSisi;
private Button bHitung;
private TextView tHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        eSisi = findViewById(R.id.sisi);
        bHitung = findViewById(R.id.bhitung);
        tHasil = findViewById(R.id.thasil);
        bHitung.setOnClickListener(this);
    }






    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bhitung) {
            String inputSisi = eSisi.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputSisi)) {
                isEmptyFields = true;
                eSisi.setError("Jangan Kosong Dong");
            }


            Double sisi = toDouble(inputSisi);

            if (sisi == null) {
                isInvalidDouble = true;
                eSisi.setError("Nomor Harus Sesuai");
            }

            if (!isEmptyFields && !isInvalidDouble) {
                double volume = sisi * 4;
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
