package com.example.pbo.jagasehat;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class KontakPetugas extends Fragment {


   public KontakPetugas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_kontak_petugas, container, false);
        LinearLayout rafid = (LinearLayout)view.findViewById(R.id.rafid);
        rafid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),detail_kontak_petugas2.class));
            }
        });
        LinearLayout vega = (LinearLayout)view.findViewById(R.id.vega);
        vega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),detail_kontak_petugas3.class));
            }
        });
        LinearLayout santo = (LinearLayout)view.findViewById(R.id.santo);
        santo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),detail_kontak_petugas.class));
            }
        });
        LinearLayout rey = (LinearLayout)view.findViewById(R.id.reynaldi);
        rey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),DetailKontakPetugas4.class));
            }
        });
        return view;
    }


}
