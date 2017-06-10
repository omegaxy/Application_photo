package com.example.antoine.application_photo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    private ListView listview;
    private ImageView imagev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //imagev = (ImageView) findViewById(R.id.imgView);

        listview = (ListView) findViewById(R.id.listView);

        String[] nom = new String[]{"img", "img2", "img3", "img4"};

        String[] num = new String[]{"11", "12", "13", "14"};
        int[] image = {R.drawable.smileybase, R.drawable.smileybase, R.drawable.smileybase, R.drawable.smileybase};

        ArrayList<Photo> myList = new ArrayList<>();

        /*
        ImageIcon bimg = new ImageIcon() {
        }
        int width = bimg.getWidth();
        int height= bimg.getHeight();
*/

        for (int i = 0; i < num.length; i++) {

            myList.add(new Photo(nom[i],image[i], "1", "2", "3"));
        }

        contact_adaptor adapter = new contact_adaptor(this, myList);
        listview.setAdapter(adapter);

    }

}
