package com.jikexuyuan.imageviewer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.widget.Toast.makeText;

public class MainActivity extends Activity {

    private Button btnOpenImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化打开图片按钮
        btnOpenImg = (Button)findViewById(R.id.btn_openImg);

        // 为打开图片按钮添加点击响应事件
        // Set the OnClickListener for Open Img Button
        // Since this work is really simple, it doesn't need a switch/case structure
        // to handle the click event.
        btnOpenImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 设置按钮点击后触发的 Activity 响应
                Bitmap default_img = BitmapFactory.decodeResource(getResources(), R.drawable.test);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri img_uri = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(),
                        default_img,
                        null,
                        null));
                intent.setDataAndType(img_uri, "image/*");
                startActivity(intent);
            }
        });
    }
}
