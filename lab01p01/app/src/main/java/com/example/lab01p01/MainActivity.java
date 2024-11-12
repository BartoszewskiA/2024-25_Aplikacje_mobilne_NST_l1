package com.example.lab01p01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    EditText editText01, editText02;
    Button button01, button02;
    TextView textView03;

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
        editText01 = findViewById(R.id.editText01);
        editText02 = findViewById(R.id.editText02);
        button01 = findViewById(R.id.button01);
        button02 = findViewById(R.id.button02);
        textView03 = findViewById(R.id.textView03);

        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText01.setText("");
                editText02.setText("");
                textView03.setText("");
            }
        });

    }

    public void licz(View view) {
//        double a = Double.parseDouble(editText01.getText().toString());
//        double b = Double.parseDouble(editText02.getText().toString());
//        double c = a + b;
//        textView03.setText(String.valueOf(c));

        double a=0,b=0;
        try {
            a = Double.parseDouble(editText01.getText().toString());
            b = Double.parseDouble(editText02.getText().toString());
        }catch (Exception e) {
            Toast.makeText(this, e.getMessage().toString()+ "Pola a, b nie mogą być puste", Toast.LENGTH_SHORT).show();
            return;
        }
        double c = a + b;
        textView03.setText(String.valueOf(c));
    }
}