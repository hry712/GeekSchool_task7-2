package com.jikexuyuan.imageviewer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
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
        // Initial the Open button widget
        btnOpenImg = (Button)findViewById(R.id.btn_openImg);
        SaveImgToLocalPath(R.drawable.test,
                ViewImageActivity.DEFAULT_IMG_PATH,
                ViewImageActivity.DEFAULT_IMG_FILENAME);
//        System.out.println(Environment.getExternalStorageDirectory().getAbsolutePath());

        // Set the OnClickListener for Open Img Button
        btnOpenImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // The next step is sending the local img file info to the target activity
                // I think the location string can meet the demand.
                String local_img_path = ViewImageActivity.DEFAULT_IMG_PATH +
                        ViewImageActivity.DEFAULT_IMG_FILENAME;
                // 设置按钮点击后触发的 Activity 响应
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri img_uri = Uri.parse("file://"
                        + ViewImageActivity.DEFAULT_IMG_PATH
                        + ViewImageActivity.DEFAULT_IMG_FILENAME);
                intent.setDataAndType(img_uri, "image/*");
                startActivity(intent);
            }
        });
    }

    private void SaveImgToLocalPath(int ImgResID, String LocalPath, String LocalFileName) {
        // 尝试将工程中的图片缓存到本地存储中，再将图片所在地址传递过去
        // 还需要知道自带的图片浏览器接收图片资源的方式
        // Withdraw the img resource in this project, then save it as a Bitmap Obj to local storage.
        Bitmap img_res = BitmapFactory.decodeResource(
                getApplicationContext().getResources(),
                ImgResID);

        // Save the img file to the default local dir
        File img_tmp = new File(LocalPath, LocalFileName);
        try {
            FileOutputStream fo = new FileOutputStream(img_tmp);
            img_res.compress(Bitmap.CompressFormat.JPEG, 90, fo);
            fo.flush();
            fo.close();
            // Send broadcast to System Image Viewer
            Intent iv_intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            Uri uri = Uri.fromFile(img_tmp);
            iv_intent.setData(uri);
            sendBroadcast(iv_intent);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
