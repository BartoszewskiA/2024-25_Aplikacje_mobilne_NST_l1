package com.example.lab02p02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText etCena;
    TextView tvWynik;
    SeekBar sbRaty;
    RadioGroup rgGwarancja;
    RadioButton rb01, rb02, rb03;
    CheckBox checkBox;
    Button btnWylicz;

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
        etCena = findViewById(R.id.et_cena);
        tvWynik = findViewById(R.id.tv_wynik);
        sbRaty = findViewById(R.id.sb_raty);
        rgGwarancja = findViewById(R.id.rg_gwarancja);
        rb01 = findViewById(R.id.rb_01);
        rb02 = findViewById(R.id.rb_02);
        rb03 = findViewById(R.id.rb_03);
        checkBox = findViewById(R.id.checkBox);
        btnWylicz = findViewById(R.id.btn_wylicz);

        btnWylicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wylicz();
            }
        });
        sbRaty.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                wylicz();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        rgGwarancja.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                wylicz();
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                wylicz();
            }
        });
    }

    private void wylicz() {
        double cena;
        try {
           cena = Double.parseDouble(etCena.getText().toString());
        } catch (Exception e) {
            Toast.makeText(this, "Wprowadz cenę", Toast.LENGTH_SHORT).show();
            return;
        }
        int raty = sbRaty.getProgress();
        double wynik;
        if (rb01.isChecked()) {
            wynik = (cena) / raty;
        } else if (rb02.isChecked()) {
            wynik = (cena * 1.15) / raty;
        } else if(rb03.isChecked()) {
            wynik = (cena * 1.3) / raty;
        } else {
            Toast.makeText(this, "Wybierz opcje", Toast.LENGTH_SHORT).show();
            return;
        };
        if (checkBox.isChecked()) {
            wynik +=10;
        }
        String tekst = "";
        tekst += String.valueOf(raty);
        tekst += " rat\n";
        tekst += String.format("%.2f", wynik);
        tekst += " zł";
        tvWynik.setText(tekst);
    }


}