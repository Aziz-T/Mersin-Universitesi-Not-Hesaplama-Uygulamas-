package com.k.meuhesaplama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class sonucActivity extends AppCompatActivity {
    private String dersAdi[];
    private double dersSayi;
    private double vize[];
    private double finalnotu[];
    private double kredi[];
    private double ortalama[];
    private double gecmeNotu[];
    private TextView gno;

    private RecyclerView recyclerview;
    private List<dersModel> list;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);
        gno=findViewById(R.id.ortalamaLabel);
        recyclerview=findViewById(R.id.rcycle);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);

        list = new ArrayList<>();

        final DersAdapter adaptor= new DersAdapter(list);
        recyclerview.setAdapter(adaptor);

        dersSayi=getIntent().getExtras().getInt("derssayisi");
        dersAdi=getIntent().getExtras().getStringArray("isim");
        vize=getIntent().getExtras().getDoubleArray("vize");
        finalnotu=getIntent().getExtras().getDoubleArray("final");
        kredi=getIntent().getExtras().getDoubleArray("kredi");
        ortalama=getIntent().getExtras().getDoubleArray("ortalama");
        gecmeNotu=getIntent().getExtras().getDoubleArray("gecme");
        gno.setText("Girilen Notların Ortalaması: "+ (float)getIntent().getExtras().getDouble("gno"));


        for(i=0; i< dersSayi; i++){
            list.add(i,new dersModel( dersAdi[i], vize[i],finalnotu[i],kredi[i],ortalama[i],gecmeNotu[i],i+1));
            adaptor.notifyDataSetChanged();
        }
    }
}
