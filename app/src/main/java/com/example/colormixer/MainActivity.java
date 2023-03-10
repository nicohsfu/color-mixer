package com.example.colormixer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnTouchListener {

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

        rTV.setOnTouchListener(this);
        gTV.setOnTouchListener(this);
        bTV.setOnTouchListener(this);

        resultTV = findViewById(R.id.resultTextView);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if (seekBar.getId() == R.id.rSeekBar) {
            valR = seekBar.getProgress();
            rTV.setBackgroundColor(Color.rgb(valR, 0, 0));
            rTV.setText("R = " + valR);
        }
        if (seekBar.getId() == R.id.gSeekBar) {
            valG = seekBar.getProgress();
            gTV.setBackgroundColor(Color.rgb(0, valG, 0));
            gTV.setText("G = " + valG);
        }
        if (seekBar.getId() == R.id.bSeekBar) {
            valB = seekBar.getProgress();
            bTV.setBackgroundColor(Color.rgb(0, 0, valB));
            bTV.setText("B = " + valB);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data, dragShadowBuilder, view, 0);
            return true;
        } else {
            return false;
        }
    }
}