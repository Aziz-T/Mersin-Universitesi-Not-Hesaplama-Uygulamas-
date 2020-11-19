package com.k.meuhesaplama;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DersAdapter extends RecyclerView.Adapter<DersAdapter.ViewHolder> {


    private List<dersModel> dersModelList;

    public DersAdapter(List<dersModel> dersModelList) {
        this.dersModelList = dersModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ders_item,parent,false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(dersModelList.get(position).getAdi(),dersModelList.get(position).getVize(),dersModelList.get(position).getFinalnotu(),dersModelList.get(position).getKredi(),dersModelList.get(position).getOrtalama(),dersModelList.get(position).getGecmeNotu(),dersModelList.get(position).getSayi());
    }

    @Override
    public int getItemCount() {
        return dersModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView vizeText;
        private TextView finalText;
        private TextView krediText;
        private TextView ortText;
        private TextView dersLabel;
        private TextView gecmeLabel;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            vizeText=itemView.findViewById(R.id.vizeText);
            finalText=itemView.findViewById(R.id.finalText);
            krediText=itemView.findViewById(R.id.krediText);
            ortText=itemView.findViewById(R.id.ortalamaText);
            dersLabel=itemView.findViewById(R.id.dersLabel);
            gecmeLabel=itemView.findViewById(R.id.gecmeText);


        }
        private void setData(String dersadi, double vize,double finalnotu,double kredi,double ortalama, double gecmeNotu,int sayi){
            vizeText.setText("Vize Notu(%40): " + String.valueOf(vize));
            finalText.setText( "Final/Büt(%60): " + String.valueOf(finalnotu));
            krediText.setText("Dersin Kredisi: " + (int)kredi);
            ortText.setText("Ortalama: " + String.valueOf(ortalama));
            gecmeLabel.setText("Geçmek İçin Gereken En Düşük Final Notu: "+(int)gecmeNotu);
            dersLabel.setText(dersadi);

        }
    }
}
