package com.k.meuhesaplama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class hesaplaActivity extends AppCompatActivity {

    private int dersSayi;
    private TextView dersLabel;
    private TextView tumDersler;
    private EditText vizeEdit;
    private EditText finalEdit;
    private EditText krediEdit;
    private EditText dersAdi;
    private Button ekleButton;
    private Button hesaplaButton;
    private int i=0;
    private int k;
    private double vize[];
    private double finalnotu[];
    private double kredi[];
    private double ortalama[];
    private double gecmeNotu[];
    private String dersAd[];
    private double gno, kred=0, toplam=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hesapla);
        dersAdi = findViewById(R.id.dersAdiEdit);
        dersLabel = findViewById(R.id.dersLabel);
        vizeEdit = findViewById(R.id.vizeEdit);
        finalEdit = findViewById(R.id.finalEdit);
        krediEdit = findViewById(R.id.krediEdit);
        ekleButton = findViewById(R.id.ekleButton);
        hesaplaButton = findViewById(R.id.hesaplaButton);
        tumDersler = findViewById(R.id.tumdersler);

        dersSayi = getIntent().getExtras().getInt("ders");
        vize = new double[dersSayi];
        finalnotu = new double[dersSayi];
        kredi = new double[dersSayi];
        ortalama = new double[dersSayi];
        gecmeNotu = new double[dersSayi];
        dersAd = new String[dersSayi];



        dersLabel.setText(i + "/" + dersSayi);
        if(dersAdi.getText().toString().trim().equals("") )
        {
            dersAdi.setText(" ");
        }
        if(vizeEdit.getText().toString().trim().equals("") )
        {
            vizeEdit.setText("0");
        }
        if(finalEdit.getText().toString().trim().equals("") )
        {
            finalEdit.setText("0");
        }
        if(krediEdit.getText().toString().trim().equals("") )
        {
            krediEdit.setText("0");
        }

        hesaplaButton.setEnabled(false);
            ekleButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    dersLabel.setText(i+1 + "/" + dersSayi);

                    dersAd[i]=dersAdi.getText().toString();
                    vize[i]= Double.valueOf(vizeEdit.getText().toString());
                    finalnotu[i]=Double.valueOf(finalEdit.getText().toString());
                    kredi[i]=Integer.parseInt(krediEdit.getText().toString());
                    ortalama[i] = ortalamHesap(vize[i],finalnotu[i],kredi[i]);
                    gecmeNotu[i]=gecmeNotu(vize[i]);

                    i++;
                    if(i==dersSayi){
                        ekleButton.setEnabled(false);
                        hesaplaButton.setAlpha(1.0f);
                        hesaplaButton.setEnabled(true);
                        tumDersler.setText("Tüm dersler eklendi.");
                        for(k=0; k<dersSayi;k++){
                            if(ortalama[k]>=50 && finalnotu[k]>=50){
                                toplam=toplam+genelNot(ortalama[k],kredi[k]);
                            }
                            kred=kred+kredi[k];
                        }
                        gno=toplam/kred;

                    }

                      }

            });



        hesaplaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),sonucActivity.class);
                intent.putExtra("isim",dersAd);
                intent.putExtra("derssayisi",dersSayi);
                intent.putExtra("vize",vize);
                intent.putExtra("final",finalnotu);
                intent.putExtra("kredi",kredi);
                intent.putExtra("ortalama",ortalama);
                intent.putExtra("gecme",gecmeNotu);
                intent.putExtra("gno",gno);

                startActivity(intent);
                finish();


            }
        });





    }

    double ortalamHesap(double vize, double finalnotu, double kredi){
        double sonuc;
        sonuc= ((vize*0.4)+(finalnotu*0.6));
        return sonuc;
    }

    double gecmeNotu(double vize){
        double sonuc;
        sonuc=(60-(vize*0.4))/0.6;
        return sonuc;
    }
    double genelNot(double ortalama, double kredi){

        double carpim;
        carpim=ortalama*kredi;
        return carpim;
    }


}
