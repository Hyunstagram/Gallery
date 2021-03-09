package com.kang.gallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    ListViewAdapter adapter;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tab = (TabHost) findViewById(R.id.tabhost);
        tab.setup();
        TabHost.TabSpec tab1 = tab.newTabSpec("1").setContent(R.id.tab_album).setIndicator("앨범");
        TabHost.TabSpec tab2 = tab.newTabSpec("2").setContent(R.id.tab_picture).setIndicator("사진");
        tab.addTab(tab1);
        tab.addTab(tab2);

        adapter = new ListViewAdapter();
        ListView listview = (ListView) findViewById(R.id.listview_album);
        listview.setAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.camera),
                "카메라", "10");

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onClick(View v) {
        ImageView imageView = (ImageView)findViewById(v.getId());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
                float scale = (float) (1024/(float)bitmap.getWidth());
                int image_w = (int) (bitmap.getWidth() * scale);
                int image_h = (int) (bitmap.getHeight() * scale);
                Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
                resize.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                intent.putExtra("image", byteArray);

                startActivity(intent);
            }
        });
    }
}