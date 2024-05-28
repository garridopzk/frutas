package com.example.frutas;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ListView listview;
    TextView totalTextView;
    double total = 0.00;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

            listview=(ListView)findViewById(R.id.listview);
            totalTextView = findViewById(R.id.total);


        String[] nombres={"Fresa","Mango","Papaya","Pera","Platanos"};
            String[] precios ={"40","50","30","70","90"};
            Integer[]  idimage= {R.drawable.fresa,R.drawable.mango,R.drawable.papaya,R.drawable.pera,R.drawable.platanos};
            Adaptador adapter = new Adaptador(this,nombres,precios,idimage);
            listview.setAdapter(adapter);

            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    double precio = Double.parseDouble(precios[position]);
                    int imagenResId = idimage[position];


                    String precioString = precios[position];
                    double precio = Double.parseDouble(precioString.replace("$", "").replace(",", ""));

                    total += precio;

                    String totalFormatted = String.format("Total: $%,.2f", total);
                    totalTextView.setText(totalFormatted);

                    Toast.makeText(getApplicationContext(),"Seleccionaste el elemento: "+nombres[position], Toast.LENGTH_LONG).show();
                }
            });
            listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    String precioString = precios[position];
                    double precio = Double.parseDouble(precioString.replace("$", "").replace(",", ""));

                    total -= precio;

                    String totalFormatted = String.format("Total: $%,.2f", total);
                    totalTextView.setText(totalFormatted);
                    Toast.makeText(getApplicationContext(),": "+nombres[position]+"con precio de :$"+precios[position], Toast.LENGTH_LONG).show();
                    return true;
                }

            });
        }
    }