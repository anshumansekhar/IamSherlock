package com.technovation.iamsherlock;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.HashMap;

import javax.microedition.khronos.opengles.GL;


public class MainActivity extends AppCompatActivity {
    ImageView detective;
    ImageView criminal;
    TypeWriter dialogBox;
    ImageButton next;
    ImageButton previous;
    ImageButton scanQR;

    IntentIntegrator qrScan;


    MediaPlayer mediaPlayer;


    HashMap<Integer,String> correctClues=new HashMap<>();
    HashMap<Integer,String> correctDialogs=new HashMap<>();

    int n=0;
    int i=0;
    int k=0;
    String[] currentClue={"q","w","e","r","t","y"};
    ArrayList<historyObject> historyObjects=new ArrayList<>();

    dialogues dialogues=new dialogues();
    RequestOptions options=new RequestOptions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        scanQR=(ImageButton)findViewById(R.id.scanQR);


        qrScan=new IntentIntegrator(MainActivity.this);


        scanQR.setVisibility(View.INVISIBLE);


        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.theonlyoneintheworld);
        mediaPlayer.start();

        setBackground();


        correctClues.put(0,"Clue1");
        correctClues.put(1,"Clue2");
        correctClues.put(2,"Clue3");
        correctClues.put(3,"Clue4");
        correctClues.put(4,"Clue5");
        correctClues.put(5,"Clue6");
        correctClues.put(6,"Clue7");

        correctDialogs.put(0,"Good");
        correctDialogs.put(1,"Awesome");
        correctDialogs.put(2,"Impressive");
        correctDialogs.put(3,"I am Stunned");
        correctDialogs.put(4,"WOW");
        correctDialogs.put(5,"I am afraid");
        correctDialogs.put(6,"Oh No");

        detective=(ImageView)findViewById(R.id.detectiveImage);
        criminal=(ImageView)findViewById(R.id.criminalImage);
        next=(ImageButton)findViewById(R.id.next);
        previous=(ImageButton)findViewById(R.id.previous);
        scanQR=(ImageButton)findViewById(R.id.scanQR);



        options.override(180,200);


        dialogBox= (TypeWriter) findViewById(R.id.dialogBox);
        dialogBox.setText("");
        dialogBox.setCharacterDelay(150);

        final String[] dialogue=dialogues.dailogue.get("first").split("\t");
        Log.e("fc",dialogue.toString());


        Glide.with(MainActivity.this)
                .load(R.mipmap.criminal)
                .apply(options)
                .into(criminal);

        criminal.setAlpha(100);
        Glide.with(MainActivity.this)
                .load(R.mipmap.sherlock_good_mood)
                .apply(options)
                .into(detective);

        dialogBox.animateText(dialogue[n+1]);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next.setEnabled(true);
                n=n-3;
                if(n>0){
                    if (dialogue[n].contains("Sherlock")) {
                        criminal.setAlpha(100);
                        detective.setAlpha(255);
                        dialogBox.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                        switch (Integer.parseInt(dialogue[n + 2])) {
                            case 1:
                                Glide.with(MainActivity.this)
                                        .clear(detective);
                                Glide.with(MainActivity.this)
                                        .load(R.mipmap.sherlock_good_mood)
                                        .into(detective);
                                break;
                            case 2:
                                Glide.with(MainActivity.this)
                                        .clear(detective);
                                Glide.with(MainActivity.this)
                                        .load(R.mipmap.sherlock_shocked)
                                        .into(detective);
                                break;
                            case 3:
                                Glide.with(MainActivity.this)
                                        .clear(detective);
                                Glide.with(MainActivity.this)
                                        .load(R.mipmap.sherlock_angry)
                                        .into(detective);
                                break;
                            case 4:
                                Glide.with(MainActivity.this)
                                        .clear(detective);
                                Glide.with(MainActivity.this)
                                        .load(R.mipmap.sherlock_attitude)
                                        .into(detective);
                                break;
                        }
                    } else if (dialogue[n].contains("Criminal")) {
                        criminal.setAlpha(255);
                        detective.setAlpha(100);
                        dialogBox.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                    } else if (dialogue[n].contains("simple")) {
                        criminal.setAlpha(100);
                        detective.setAlpha(100);
                        dialogBox.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        if(Integer.parseInt(dialogue[n+2])==1){
                            //next.setEnabled(false);
                            //i--;
                            //scanQR.setVisibility(View.VISIBLE);
                        }
                    }
                    dialogBox.animateText(dialogue[n + 1]);

                }else{
                    n=n+3;
                }

            }
        });

        scanQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qrScan.initiateScan();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n=n+3;
                if(n<dialogue.length) {
                    if (dialogue[n].contains("Sherlock")) {
                        criminal.setAlpha(100);
                        detective.setAlpha(255);
                        dialogBox.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                        switch (Integer.parseInt(dialogue[n + 2])) {
                            case 1:
                                Glide.with(MainActivity.this)
                                        .clear(detective);
                                Glide.with(MainActivity.this)
                                        .load(R.mipmap.sherlock_good_mood)
                                        .into(detective);
                                break;
                            case 2:
                                Glide.with(MainActivity.this)
                                        .clear(detective);
                                Glide.with(MainActivity.this)
                                        .load(R.mipmap.sherlock_shocked)
                                        .into(detective);
                                break;
                            case 3:
                                Glide.with(MainActivity.this)
                                        .clear(detective);
                                Glide.with(MainActivity.this)
                                        .load(R.mipmap.sherlock_angry)
                                        .into(detective);
                                break;
                            case 4:
                                Glide.with(MainActivity.this)
                                        .clear(detective);
                                Glide.with(MainActivity.this)
                                        .load(R.mipmap.sherlock_attitude)
                                        .into(detective);
                                break;
                        }
                    } else if (dialogue[n].contains("Criminal")) {
                        criminal.setAlpha(255);
                        detective.setAlpha(100);
                        dialogBox.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                    } else if (dialogue[n].contains("simple")) {
                        criminal.setAlpha(100);
                        detective.setAlpha(100);
                        dialogBox.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        if(Integer.parseInt(dialogue[n+2])==1){
                            if(k<=n) {
                                next.setEnabled(false);
                                k=n;
                                //i++;
                                scanQR.setVisibility(View.VISIBLE);
                            }
                        }
                    }
                    dialogBox.animateText(dialogue[n + 1]);
                }else{
                    n=n-3;
                }

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        final IntentResult result=IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result!=null) {
            if (result.getContents() == null) {
                //Nothing found
            } else {
                Log.e("d",""+i);
                String resultq = result.getContents();
                if(resultq.contains(currentClue[i]) && i!=5){
                    i++;
                    next.setEnabled(true);
                    scanQR.setVisibility(View.INVISIBLE);
                    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                    View v= LayoutInflater.from(MainActivity.this).inflate(R.layout.alert_dialog,null);
                    TextView dialogText=v.findViewById(R.id.dialogText);
                    dialogText.setText("Good work,Now solve the next one ");
                    builder.setView(v);
                    AlertDialog dialog=builder.create();
                    dialog.show();
                }else if (i==5 && resultq.contains(currentClue[i])) {
                    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                    View v= LayoutInflater.from(MainActivity.this).inflate(R.layout.alert_dialog,null);
                    TextView dialogText=v.findViewById(R.id.dialogText);
                    ImageView img=v.findViewById(R.id.dailogImage);
                    Glide.with(v)
                            .load(R.mipmap.criminal_face)
                            .apply(options)
                            .into(img);
                    dialogText.setText("Come on catch me if you can before i escape into the dark");
                    builder.setView(v);
                    AlertDialog dialog=builder.create();
                    dialog.show();
                }
                else {
                    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                    View v= LayoutInflater.from(MainActivity.this).inflate(R.layout.alert_dialog,null);
                    TextView dialogText=v.findViewById(R.id.dialogText);
                    dialogText.setText("Try again");
                    builder.setView(v);
                    AlertDialog dialog=builder.create();
                    dialog.show();
                }
            }
        }
    }
}
