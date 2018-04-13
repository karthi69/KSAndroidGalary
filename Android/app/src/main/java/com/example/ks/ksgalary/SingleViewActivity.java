package com.example.ks.ksgalary;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.view.GestureDetector.OnGestureListener;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.widget.LinearLayout;
import android.view.View.OnTouchListener;

import static com.example.ks.ksgalary.R.id.SingleView;

public class SingleViewActivity extends Activity

{
    GestureDetector gestureDetector;
    private GestureDetectorCompat mDetector;
    private static final String DEBUG_TAG = "Gestures";
    int currentIndex = 0;

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_view);

        LinearLayout rlTop = (LinearLayout) findViewById(R.id.myView);

        rlTop.setOnTouchListener(new RelativeLayoutTouchListener(this));

        // Get intent data
        Intent i = getIntent();

        // Selected image id
        int position = i.getExtras().getInt("id");
        setImageAtIndex(position);
        currentIndex = position;

    }

    public void  setImageAtIndex(int position)
    {
        ImageAdapter imageAdapter = new ImageAdapter(this);

        ImageView imageView = (ImageView) findViewById(SingleView);
        imageView.setImageResource(imageAdapter.mThumbIds[position]);
    }

    public  void  loadPrevImage()
    {

        if (currentIndex>0) {
            currentIndex--;
            setImageAtIndex(currentIndex);
        }
        else
            setImageAtIndex(0);

//        Toast.makeText(this, "LeftToRightSwipe", Toast.LENGTH_SHORT).show();
    }
    public  void  loadNextImage()
    {

        ImageAdapter imageAdapter = new ImageAdapter(this);
        if (currentIndex<imageAdapter.mThumbIds.length-1) {
            currentIndex++;
            setImageAtIndex(currentIndex);
        }
        else
        {
            setImageAtIndex(imageAdapter.mThumbIds.length-1);
        }
//        Toast.makeText(this, "RightToLeftSwipe", Toast.LENGTH_SHORT).show();
    }
}

