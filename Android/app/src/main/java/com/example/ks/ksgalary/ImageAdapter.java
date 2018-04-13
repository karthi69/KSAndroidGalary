package com.example.ks.ksgalary;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.example.ks.ksgalary.R;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
        mThumbIds = new Integer[]
                {
                R.drawable.nature,R.drawable.a,
                R.drawable.jio, R.drawable.l,
                R.drawable.windows,R.drawable.facebook,
                R.drawable.n, R.drawable.messanger,
                R.drawable.g, R.drawable.samsung,
                R.drawable.nature,R.drawable.download,
                R.drawable.twitter, R.drawable.slack,
                R.drawable.k, R.drawable.nature,
                R.drawable.images, R.drawable.windows,
                R.drawable.samsung,R.drawable.z,
                R.drawable.nature, R.drawable.images
        };
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(330, 330));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageView.setPadding(10, 0, 10, 0);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // Keep all Images in array
    public Integer[] mThumbIds;
}