package com.example.antoine.application_photo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nicolas on 10/06/2017.
 */

public class contact_adaptor extends BaseAdapter {

    ArrayList<Photo> myList = new ArrayList<Photo>();
    Context context;

    // on passe le context afin d'obtenir un LayoutInflater pour utiliser row_layout.xml
    // on passe les valeurs de notre à l'adapter
    public contact_adaptor(Context context, ArrayList<Photo> myList) {
        this.myList = myList;
        this.context = context;
    }

    // retourne le nombre d'objet présent dans notre liste
    @Override
    public int getCount() {
        return myList.size();
    }

    // retourne un elem de notre liste en fonction de sa position
    @Override
    public Photo getItem(int position) {
        return myList.get(position);
    }

    // retourne l'id d'un élément de notre liste en fonction de sa position
    @Override
    public long getItemId(int position) {
        return myList.indexOf(getItem(position));
    }

    // retourne la vue d'un élément de la liste
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder mViewHolder = null;

        // premier coup ConvertView est null, on inflate notre layout
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = mInflater.inflate(R.layout.photo_layout, parent, false);

            // on place dans MyViewHolder les vues de notre layout
            mViewHolder = new MyViewHolder();
            mViewHolder.textViewName = (TextView) convertView.findViewById(R.id.textViewName);
            mViewHolder.textViewSize = (TextView) convertView.findViewById(R.id.textViewSize);
            mViewHolder.textViewLocation = (TextView) convertView.findViewById(R.id.textViewLocation);
            mViewHolder.textViewDate = (TextView) convertView.findViewById(R.id.textViewDate);
            mViewHolder.imageView = (ImageView) convertView.findViewById(R.id.imgView);

            // on donne le tag MyViewHolder à convertView
            convertView.setTag(mViewHolder);
        } else {
            // non null, on recupere notre objet MyViewHolder
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        // on recupere l'item de la liste demandé par getView
        Photo listItem = (Photo) getItem(position);

        // on attribu les valeurs de l'élément de la liste
        mViewHolder.textViewName.setText(listItem.getName());
        mViewHolder.textViewSize.setText(listItem.getWidth());
        mViewHolder.textViewLocation.setText(listItem.getCoordGPS());
        mViewHolder.textViewDate.setText(listItem.getDate());
        mViewHolder.imageView.setImageResource(listItem.getImage());

        // nous retournos la vue de l'item demandé
        return convertView;
    }

    // MyViewHolder va nous permettre de ne pas devoir rechercher
    // les vues à chaque appel de getView, nous gagnons ainsi en performance
    private class MyViewHolder {
        TextView textViewName, textViewSize, textViewLocation, textViewDate;
        ImageView imageView;
    }



}