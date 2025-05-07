package com.example.gridview;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        GridView gridview = (GridView) findViewById(R.id.mygridview);
        gridview.setAdapter(new ImageAdapter(this));
    }

    public class ImageAdapter extends BaseAdapter{
        //foto referansları
        private Integer[] resimler = {
                R.drawable.px1, R.drawable.px2,
                R.drawable.px3, R.drawable.px4,
                R.drawable.px5, R.drawable.px6
        };
        private Context cagiranSinif;
        public ImageAdapter(Context c){
            cagiranSinif = c;
        }
        public int getCount(){
            return resimler.length;
        }
        public Object getItem(int position){
            return null;
        }
        public long getItemId(int position){
            return 0;
        }
        //her bir resim için imageview oluşturma
        public View getView(int position, View convertView, ViewGroup parent){
            ImageView imageView;
            if(convertView == null){
                imageView = new ImageView(cagiranSinif);
                //resimlerin yükseklik genişlik ayari
                imageView.setLayoutParams(new ViewGroup.LayoutParams(520, 300));
                //gride sığdırma ortalama
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                //padding etraftaki boşluk ayarı
                imageView.setPadding(0,0,0,0);
            }
            else{
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(resimler[position]);
            return imageView;
        }
    }
}