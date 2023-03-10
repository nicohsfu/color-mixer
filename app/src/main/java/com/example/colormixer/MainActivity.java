package com.example.colormixer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private int valR, valG, valB;

    private SeekBar rSB, gSB, bSB;

    private TextView rTV, gTV, bTV, resultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rSB = findViewById(R.id.rSeekBar);
        gSB = findViewById(R.id.gSeekBar);
        bSB = findViewById(R.id.bSeekBar);

        rSB.setOnSeekBarChangeListener(this);
        gSB.setOnSeekBarChangeListener(this);
        bSB.setOnSeekBarChangeListener(this);

        rTV = findViewById(R.id.rTextView);
        gTV = findViewById(R.id.gTextView);
        bTV = findViewById(R.id.bTextView);

        resultTV = findViewById(R.id.resultTextView);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if (seekBar.getId() == R.id.rSeekBar) {
            valR = seekBar.getProgress();
            rTV.setBackgroundColor(Color.rgb(valR, 0, 0));
            rTV.setText("R = " + valR);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}