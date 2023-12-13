package com.example.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    TimePicker timePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        timePicker.setVisibility(TimePicker.GONE);


        button = findViewById(R.id.buttonTimePicker);
        button.setOnClickListener(v -> openTimePicker());

        timePicker.setOnTimeChangedListener((view, hourOfDay, minute) -> {
            String selectedTime = hourOfDay + ":" + minute;
            Toast.makeText(MainActivity.this, "Hora selecionada: "+ selectedTime,Toast.LENGTH_SHORT).show();
        });
    }
    private void openTimePicker() {
        timePicker.setVisibility(timePicker.getVisibility() == TimePicker.VISIBLE ? TimePicker.GONE : TimePicker.VISIBLE);
    }
}