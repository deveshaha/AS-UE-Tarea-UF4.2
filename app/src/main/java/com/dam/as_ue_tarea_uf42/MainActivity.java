package com.dam.as_ue_tarea_uf42;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Size;
import android.view.Menu;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lang, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuJava){
            loadFragment(new JavaFragment());
        } else if (item.getItemId() == R.id.menuPython){
            loadFragment(new PythonFragment());
        } else if (item.getItemId() == R.id.menuExit){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, fragment).addToBackStack(null).commit();
    }

    public void onAceptarDatosListener(int txtSize) {
        TextView tvText = findViewById(R.id.tvHelloWorld);
        tvText.setTextSize(txtSize);
    }
}