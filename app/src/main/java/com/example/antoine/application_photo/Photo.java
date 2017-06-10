package com.example.antoine.application_photo;

import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Antoine on 27/05/2017.
 */

public class Photo {
    private String name;
    private int image;
    private String width;
    private String height;
    private String coordGPS;
    private String date;

    public Photo(String name, int image, String width, String height, String coordGPS)
    {
        this.name=name;
        this.image = image;
        this.width=width;
        this.height=height;
        this.coordGPS=coordGPS;//à changer pour la fonction GPS
        this.date=Date_now();

    }

    //obtenir les caractéristiques des images
    public String getName(){return this.name;}
    public String getHeight(){return this.height;}
    public String getWidth(){return this.width;}
    public String getCoordGPS(){return this.coordGPS;}
    public String getDate(){return this.date;}
    public int getImage() {return image;}

    //mise à jour des images
    public void setName(String name){this.name=name;}

    //renvoie la date actuel
    public String Date_now(){

        Date now = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy' 'HH'h'mm");
        String date = f.format(now);
        return date;

    }


}
