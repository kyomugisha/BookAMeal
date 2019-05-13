package com.example.bookameal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class MyAdapter extends ArrayAdapter<String> {
    Context context;
    String rTitle[];
    String rDescription[];


    public MyAdapter(Context c,String title[],String description[]) {
        super(c, R.layout.rows,R.id.textview1, title);
        this.context = c;
        this.rTitle = title;
        this.rDescription = description;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=layoutInflater.inflate(R.layout.rows,parent,false);

        TextView mTitle=row.findViewById(R.id.textview1);
        TextView mDescription=row.findViewById(R.id.textview2);


        mTitle.setText(rTitle[position]);
        mDescription.setText(rDescription[position]);
        return row;
    }
}