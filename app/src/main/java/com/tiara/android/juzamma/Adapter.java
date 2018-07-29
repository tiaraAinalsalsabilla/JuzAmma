package com.tiara.android.juzamma;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tiara.android.juzamma.R;

/**
 * Created by smp_i on 5/13/2017.
 */

public class Adapter extends ArrayAdapter {
    private final Activity context;
    private final String [] nama;
    private final String [] isi;
    private final int [] suara;

    public Adapter(Activity context, String[] nama, String[] isi,int[]suara) {
        super(context, R.layout.list_item,nama);
        this.context = context;
        this.nama = nama;
        this.isi = isi;
        this.suara = suara;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.list_item,null,true);
        TextView txt = (TextView) view.findViewById(R.id.txtlistitem);

        txt.setText(nama[position]);
        return view;
    }
}
