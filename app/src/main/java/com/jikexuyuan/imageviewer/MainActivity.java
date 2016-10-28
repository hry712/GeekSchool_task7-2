package com.jikexuyuan.imageviewer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button btnOpenImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOpenImg = (Button)findViewById(R.id.btn_openImg);
        btnOpenImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setData(Uri.parse("content://media/internal/images/media"));
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                startActivity(new Intent(ViewImageActivity.ACTION));
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
//                intent.setType("images/*");
                startActivity(intent);
            }
        });
    }
}
