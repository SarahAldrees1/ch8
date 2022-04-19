package com.example.ch8;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Integer[] Animals={R.drawable.cat4,R.drawable.cute6,R.drawable.jir1,R.drawable.wolf3,R.drawable.lioness5,R.drawable.wolf9};
    ImageView pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView grid=(GridView)findViewById(R.id.gridview);
        final ImageView pic =(ImageView)findViewById(R.id.imgLarge);
        grid.setAdapter(new ImageAdapter(this));


        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,View view, int postion, long id) {
                Toast.makeText(getBaseContext(), "Selected Species"+ (postion + 1), Toast.LENGTH_SHORT).show();
                pic.setImageResource(Animals[postion]);
            }
        });

    }



    public class ImageAdapter extends BaseAdapter {
        private Context context;
        public ImageAdapter(Context c) {
            context=c;
        }

        @Override
        public int getCount() {
            return Animals.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int postion, View convertview, ViewGroup parent) {
            pic=new ImageView(context);
            pic.setImageResource(Animals[postion]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new ViewGroup.LayoutParams(330,330));
            return pic;
        }
    }
}