package com.example.user.travelhelper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by User on 3/25/2017.
 */

public class TravelAdapter extends ArrayAdapter {

    public TravelAdapter (Context context, Object[] objects) {
        super(context, R.layout.countries_item, objects);
    }
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.countries_item, parent, false);
        }
        Country country = (Country) getItem(position);
        TextView titleTextView = (TextView) view.findViewById(R.id.title_text_view);
        titleTextView.setText(country.title);

        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
        Picasso.with(getContext()).load(country.photo).fit().centerCrop().into(imageView);


        return view;
    }
}
