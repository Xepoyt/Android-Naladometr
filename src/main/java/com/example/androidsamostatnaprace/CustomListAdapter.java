package com.example.androidsamostatnaprace;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter {
    private final Activity context;
    private final String[] titulky;
    private final String[] podtitulky;
    private final String[] datumy;

    public CustomListAdapter(Activity context, String[] titulky, String[] podtitulky, String[] datumy){
        super(context, R.layout.radka, titulky);

        this.context = context;
        this.titulky = titulky;
        this.podtitulky = podtitulky;
        this.datumy = datumy;
    }

    public View getView(int position, View view, ViewGroup parent){{
        LayoutInflater inflater = context.getLayoutInflater();
        View radka = inflater.inflate(R.layout.radka, null, true);
        TextView titulek = radka.findViewById(R.id.titulek);
        TextView podtitulek = radka.findViewById(R.id.podtitulek);
        TextView datum = radka.findViewById(R.id.listDatum);
        datum.setText(datumy[position]);
        titulek.setText("Nálada: " + titulky[position] + "/10");
        podtitulek.setText(podtitulky[position]);
        return radka;
    }}
}
