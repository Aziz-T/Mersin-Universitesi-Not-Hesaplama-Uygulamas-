package com.k.meuhesaplama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private NumberPicker numberPicker;
    private int dersSayi=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.baslabutton);
        numberPicker=findViewById(R.id.nmber_picker);

        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(50);
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
            dersSayi=i1;
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),hesaplaActivity.class);
                intent.putExtra("ders",dersSayi);
                startActivity(intent);
            }
        });
    }
}
