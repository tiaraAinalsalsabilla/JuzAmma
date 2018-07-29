package com.tiara.android.juzamma;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tiara.android.juzamma.R;

import java.io.IOException;

public class Detail_Activity extends AppCompatActivity {
    TextView txtisi;
    Button btnplay;
    Button btnstop;
    Button btnhome;
    MediaPlayer mpPlayer;

    @Override
    public void onBackPressed() {
        if (mpPlayer!= null && mpPlayer.isPlaying()){
            mpPlayer.stop();
        }
        Intent b = new Intent(getApplicationContext(),MainActivity.class );
        startActivity(b);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_);
        //kenalin id element yang dipakai di activity_detail
        TextView txtisi = (TextView)findViewById(R.id.isi);
        Button btnplay = (Button)findViewById(R.id.buttonplay);
        Button btnstop = (Button)findViewById(R.id.buttonstop);
        Button btnhome = (Button)findViewById(R.id.buttonhome);
        //get data dari list
        Intent a = getIntent();
        String isi = a.getStringExtra("isi");
        final int suara = a.getIntExtra("suara", 0);
        txtisi.setText(getString(Integer.parseInt(isi)));

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(),Menu.class );
                startActivity(a);
                finish();
            }

        });
        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri myUri = Uri.parse("android.resource://"+getPackageName()+"/"+suara);
                mpPlayer = new MediaPlayer();
                mpPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mpPlayer.setDataSource(getApplicationContext(),myUri);
                } catch (IOException e) {
                    e.printStackTrace();
                }catch (SecurityException e){
                    Toast.makeText(Detail_Activity.this, "You Might Not Set The Uri Correctly", Toast.LENGTH_LONG).show();
                }catch (IllegalStateException e){
                    Toast.makeText(Detail_Activity.this, "You Might Not Set The Uri Correctly", Toast.LENGTH_LONG).show();
                }catch (IllegalArgumentException e){
                    Toast.makeText(Detail_Activity.this, "You Might Not Set The Uri Correctly", Toast.LENGTH_LONG).show();
                }
                try {
                    mpPlayer.prepare();
                } catch (IOException e) {
                    Toast.makeText(Detail_Activity.this, "You Might Not Set The Uri Correctly", Toast.LENGTH_LONG).show();
                }catch (IllegalStateException e){
                    Toast.makeText(Detail_Activity.this, "You Might Not Set The Uri Correctly", Toast.LENGTH_LONG).show();
                }
                mpPlayer.start();
            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mpPlayer!= null && mpPlayer.isPlaying()){
                    mpPlayer.stop();
                }
            }
        });

    }
}
