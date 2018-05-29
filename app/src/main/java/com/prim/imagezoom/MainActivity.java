package com.prim.imagezoom;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.prim.imagezoom_core.PrimImageZoomView;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewpager;

    private int[] imags = new int[]{R.mipmap.test, R.mipmap.test, R.mipmap.test};
    private ImageView[] mImageViews = new ImageView[imags.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager = findViewById(R.id.viewpager);

        viewpager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imags.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mImageViews[position]);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                PrimImageZoomView primImageZoomView = new PrimImageZoomView(getApplicationContext());
                primImageZoomView.setImageResource(imags[position]);
                container.addView(primImageZoomView);
                mImageViews[position] = primImageZoomView;
                return primImageZoomView;
            }
        });
    }
}
