package com.jikexuyuan.imageviewer;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

public class ViewImageActivity extends Activity {

    private ImageView imageView;
    public static final String DEFAULT_IMG_PATH = "/storage/sdcard/Pictures/";
    public static final String DEFAULT_IMG_FILENAME = "test.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);

        imageView = (ImageView)findViewById(R.id.iv_ImageView);
        imageView.setImageURI(getIntent().getData());
    }
}
