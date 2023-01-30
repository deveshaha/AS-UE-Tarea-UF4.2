package com.dam.as_ue_tarea_uf42;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnChangeTxtSize;
    int tam = 24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChangeTxtSize = findViewById(R.id.btnChangeSize);

        btnChangeTxtSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SizeDialog sd = new SizeDialog();
                sd.setCancelable(false);
                sd.show(getSupportFragmentManager(), "SizeDialog");
            }
        });
    }

    public void onAceptarDatosListener(int txtSize) {
        TextView tvText = findViewById(R.id.tvText);
        tvText.setTextSize(txtSize);
    }
}