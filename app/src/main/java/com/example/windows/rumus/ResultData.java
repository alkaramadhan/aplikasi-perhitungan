package com.example.windows.rumus;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResultData extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_data);

        Button btnhasil = findViewById(R.id.btnresultdata);
        btnhasil.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        Intent data = new Intent();
        EditText txtnama = findViewById(R.id.nama);

        data.setData(Uri.parse(txtnama.getText().toString()));
        setResult(RESULT_OK, data);

        finish();
    }
}
