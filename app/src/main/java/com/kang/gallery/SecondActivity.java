package com.kang.gallery;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_second);
    }

    public void onClick(View v) {
        if(v.getId() == R.id.button_back)
            finish();

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