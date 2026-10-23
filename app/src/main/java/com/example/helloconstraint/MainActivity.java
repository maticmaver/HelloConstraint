package com.example.helloconstraint;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;




        });
        if (savedInstanceState != null) {
            // Dobimo nazaj prejšnjo vrednost števila (privzeto je 0, če ni ničesar)
            i = savedInstanceState.getInt("kljuc_stevilke", 0);

            // Posodobimo tudi TextView, da takoj prikaže pravo številko
            TextView counting = findViewById(R.id.textView2);
            counting.setText(String.valueOf(i));
        }
        Button count=findViewById(R.id.button3);
        TextView counting=findViewById(R.id.textView2);
        Button zero=findViewById(R.id.button2);
        Button toast=findViewById(R.id.button);

        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                counting.setText(String.valueOf(i));
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=0;
                counting.setText(String.valueOf(i));
            }
        });
        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(MainActivity.this, "Gumb je bil kliknjen!", Toast.LENGTH_SHORT).show();
            }
        });





    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Shranimo trenutno vrednost števila v "ključ" z imenom "klju_stevilke"
        outState.putInt("kljuc_stevilke", i);
    }
}