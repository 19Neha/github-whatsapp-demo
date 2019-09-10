package com.example.android.whatsappmdc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;


public class ChatInboxActivity extends Activity {

    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatinbox);

        textView = findViewById(R.id.text_toolbar_title);
        imageView = findViewById(R.id.image_chat_dp);

        Intent intent = getIntent();

        String name = intent.getStringExtra("title");
        textView.setText(name);

        imageView.setImageResource(intent.getIntExtra("dp",-1));

        intent.removeExtra("title");
        intent.removeExtra("dp");

    }
}
