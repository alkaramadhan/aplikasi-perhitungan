package com.example.windows.rumus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int req_code = 1;
    Button Keliling, Tegangangan ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Keliling = findViewById(R.id.pindah1);
        Tegangangan = findViewById(R.id.pindah2);


        Keliling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivityForResult(intent, req_code);
            }
        });
        Tegangangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent);
            }
        });

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == req_code){
            if (resultCode == RESULT_OK){
                TextView hasilnama = findViewById(R.id.view1);
                hasilnama.setText(data.getData().toString());
            }
        }
    }
}
