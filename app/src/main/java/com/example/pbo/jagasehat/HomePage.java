package com.example.pbo.jagasehat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomePage extends Fragment {
    Button bacaBuku,isiCerita,isiHarapan,isiKelebihan,isiAku;
    public HomePage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        isiCerita = (Button) view.findViewById(R.id.isiCerita);
        isiCerita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),AkuDanCeritaku.class));
            }
        });
        bacaBuku = (Button) view.findViewById(R.id.bacaBuku);
        bacaBuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),CobaBaca.class));
            }
        });
        isiHarapan = (Button) view.findViewById(R.id.isiHarapan);
        isiHarapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),HarapanDanCita.class));
            }
        });
        isiKelebihan = (Button) view.findViewById(R.id.isiKelebihan);
        isiKelebihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),Kelebihan.class));
            }
        });
        isiAku = (Button) view.findViewById(R.id.isiAku);
        isiAku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),Aku.class));
            }
        });
        return view;
    }

}
