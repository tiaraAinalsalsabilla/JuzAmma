package com.tiara.android.juzamma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tiara.android.juzamma.R;

public class Tips_Tips_Menghafal extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        Intent a = new Intent(getApplicationContext(),Menu.class);
        startActivity(a);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips__tips__menghafal);
    }
}
