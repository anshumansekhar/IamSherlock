package com.technovation.iamsherlock;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.HashMap;

public class ClueScanActivity extends AppCompatActivity {
    IntentIntegrator qrScan;
    RecyclerView recyclerView;
   // Adapter adapter;

    int position;


    MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_clue_scan);



        mediaPlayer = MediaPlayer.create(ClueScanActivity.this, R.raw.aglimpseofheart);
        mediaPlayer.start();

        recyclerView=(RecyclerView)findViewById(R.id.recycler);

//        adapter=new Adapter(ClueScanActivity.this,ClueScanActivity.this);
//        recyclerView.setLayoutManager(new LinearLayoutManager(ClueScanActivity.this));
//        recyclerView.setAdapter(adapter);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result=IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result!=null){
            if(result.getContents()==null){
                //Nothing found
            }else{
                Log.e("qrcode",result.getContents());
//                if(result.getContents().contains(correctClues.get(position))){
//                    //adapter.list.put(position,result.getContents());
//                    AlertDialog.Builder builder=new AlertDialog.Builder(ClueScanActivity.this);
//                    View v= LayoutInflater.from(ClueScanActivity.this).inflate(R.layout.alert_dialog,null);
//                    TextView dialogText=v.findViewById(R.id.dialogText);
//                    dialogText.setText(correctDialogs.get(position));
//                    builder.setView(v);
//                    AlertDialog dialog=builder.create();
//                    dialog.show();
//                }
//                else{
//                    AlertDialog.Builder builder=new AlertDialog.Builder(ClueScanActivity.this);
//                    View v= LayoutInflater.from(ClueScanActivity.this).inflate(R.layout.alert_dialog,null);
//                    TextView dialogText=v.findViewById(R.id.dialogText);
//                    dialogText.setText("Haha Nice try");
//                    builder.setView(v);
//                    AlertDialog dialog=builder.create();
//                    dialog.show();
//
//                }
                //adapter.notifyDataSetChanged();
            }

        }else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }
    public void position(int n) {
        position=n;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }
}
