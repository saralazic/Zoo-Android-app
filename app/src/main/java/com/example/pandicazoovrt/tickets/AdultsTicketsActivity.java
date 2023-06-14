package com.example.pandicazoovrt.tickets;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pandicazoovrt.R;

public class AdultsTicketsActivity extends AppCompatActivity {

    private NumberPicker picker1, picker2, picker3, picker4;
    private int cnt1, cnt2, cnt3, cnt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets_adults);


        picker1 = findViewById(R.id.numberpicker_1);
        picker1.setMaxValue(100);
        picker1.setMinValue(0);

        picker1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                cnt1 = picker1.getValue();
            }
        });

        picker2 = findViewById(R.id.numberpicker_2);
        picker2.setMaxValue(100);
        picker2.setMinValue(0);

        picker2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                int cnt2 = picker2.getValue();
            }
        });

        picker3 = findViewById(R.id.numberpicker_3);
        picker3.setMaxValue(100);
        picker3.setMinValue(0);

        picker3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                int cnt3 = picker3.getValue();
            }
        });

        picker4 = findViewById(R.id.numberpicker_4);
        picker4.setMaxValue(100);
        picker4.setMinValue(0);

        picker4.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                int cnt4 = picker4.getValue();
            }
        });

    }
}