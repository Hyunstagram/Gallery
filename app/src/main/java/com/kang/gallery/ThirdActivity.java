package com.kang.gallery;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_third);

        ImageView imageview = (ImageView)findViewById(R.id.imageView_result);

        Bundle extras = getIntent().getExtras();
        byte[] byteArray = getIntent().getByteArrayExtra("image");
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        imageview.setImageBitmap(bitmap);
    }

    public void onClick(View v) {
        if(v.getId() == R.id.button_back)
            finish();
    }
}
