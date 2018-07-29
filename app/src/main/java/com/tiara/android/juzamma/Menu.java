package com.tiara.android.juzamma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.tiara.android.juzamma.R;
import com.tiara.android.juzamma.Tips_Tips_Menghafal;

public class Menu extends AppCompatActivity {
    TextView txtjudul;
    TextView txtsemangat;
    ImageView imgquran;
    ImageView imghafidz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
       ImageView imgquran = (ImageView) findViewById(R.id.imgsurah);
        ImageView imgtips = (ImageView) findViewById(R.id.imgtips);

       imgquran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(),MainActivity.class );
                startActivity(a);
                finish();
            }
        });

        imgtips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(),Tips_Tips_Menghafal.class );
                startActivity(a);
                finish();
            }
        });

    }
}
