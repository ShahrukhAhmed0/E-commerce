package com.example.bakrapk.Detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bakrapk.Dashbboard.Dashboard;
import com.example.bakrapk.R;

public class Detail extends AppCompatActivity {
    ImageView imageView, bk;
    TextView textView,dis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = findViewById(R.id.Productimg);
        textView = findViewById(R.id.ProductName);
        bk = findViewById(R.id.bk);
        dis = findViewById(R.id.disc);
        String imageUrl = getIntent().getStringExtra("imageUrl");
        String pt = getIntent().getStringExtra("Goat");
        String dt = getIntent().getStringExtra("discriptionn");
        Glide.with(this).load(imageUrl).into(imageView);
        textView.setText(pt);
        dis.setText(dt);
        bk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Detail.this, Dashboard.class));
            }
        });

    }
}