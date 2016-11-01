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

    public static final String ACTION = "android.intent.action.VIEW";
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);

        Intent intent = getIntent();

        if (intent.getAction().equals(Intent.ACTION_VIEW)) {
            // test the intent from MainActivity
            Toast.makeText(this, "No Images to Show!", Toast.LENGTH_SHORT).show();
        } else {
            imageView = (ImageView)findViewById(R.id.iv_ImageView);
            Uri uri = intent.getData();
            // 为获取图片文件的绝对路径做准备
            // uri.getPath() 只能返回目录名，不含文件自身的名字
            String proj[] = {MediaStore.Images.Media.DATA};
            Cursor img_cursor = managedQuery(uri, proj, null, null, null);
            int img_col_index = img_cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            img_cursor.moveToFirst();
            String img_path = img_cursor.getString(img_col_index);
            // 读取本地图片文件，并在 ImageView 中显示出来
            Bitmap src_img = null;
            File img_file = new File(img_path);
            if (img_file.exists()) {
                src_img = BitmapFactory.decodeFile(img_path);
                imageView.setImageBitmap(src_img);
            } else {
                Toast.makeText(this, " This image file doesn't exist!", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
