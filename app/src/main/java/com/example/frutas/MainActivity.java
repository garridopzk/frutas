package com.example.frutas;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowCompat;

public class MainActivity extends AppCompatActivity {
    private ListView listview;
    private TextView totalTextView;
    private double total = 0.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listview);
        totalTextView = findViewById(R.id.total);

        String[] nombres = getResources().getStringArray(R.array.nombres);
        String[] precios = getResources().getStringArray(R.array.precios);
        Integer[] idimage = {
                R.drawable.fresa,
                R.drawable.mango,
                R.drawable.papaya,
                R.drawable.pera,
                R.drawable.platanos
        };

        Adaptador adapter = new Adaptador(this, nombres, precios, idimage);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                double precio = Double.parseDouble(precios[position]);

                total += precio;

                String totalFormatted = String.format("Total: $%,.2f", total);
                totalTextView.setText(totalFormatted);

                Toast.makeText(getApplicationContext(), "Seleccionaste el elemento: " + nombres[position], Toast.LENGTH_LONG).show();
            }
        });

        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                double precio = Double.parseDouble(precios[position]);

                total -= precio;

                String totalFormatted = String.format("Total: $%,.2f", total);
                totalTextView.setText(totalFormatted);

                Toast.makeText(getApplicationContext(), "Eliminaste el elemento: " + nombres[position] + " con precio de: $" + precios[position], Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }
}
