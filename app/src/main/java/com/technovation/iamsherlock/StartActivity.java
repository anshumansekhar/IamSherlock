package com.technovation.iamsherlock;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

public class StartActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    TextView startButton,rulesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_start);
        setBackground();


        startButton=(TextView)findViewById(R.id.startbutton);
        rulesButton=(TextView)findViewById(R.id.rulesButton);

        mediaPlayer = MediaPlayer.create(StartActivity.this, R.raw.theonlyoneintheworld);
        mediaPlayer.start();


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(StartActivity.this);
                View v= LayoutInflater.from(StartActivity.this).inflate(R.layout.password,null);
                final EditText password=v.findViewById(R.id.password);
                builder.setView(v);
                builder.setPositiveButton("LogIn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String pass=password.getText().toString().trim();
                        if(pass.contains("147258")){
                            startActivity(new Intent(StartActivity.this,MainActivity.class));
                        }else{
                            Toast.makeText(StartActivity.this,"Try Again",Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
        rulesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this,Rules.class));
            }
        });
    }


    public void setBackground(){
        RequestOptions options=new RequestOptions();
        options.centerCrop();
        options.override(getWindow().getDecorView().getWidth(),getWindow().getDecorView().getHeight());
        Glide.with(this)
                .load(R.mipmap.sherlock_background)
                .apply(options)
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        getWindow().getDecorView().setBackground(resource);
                    }
                });

    }
}
