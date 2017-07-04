package com.example.heisenberg.pocket_rgpv;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class About extends AppCompatActivity{

    FloatingActionMenu floatingActionMenu;
    FloatingActionButton floatingActionButton1, floatingActionButton2, floatingActionButton3, floatingActionButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setTitle("About Us");

        floatingActionMenu = (FloatingActionMenu) findViewById(R.id.floating_action_menu_about);
        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.facebookBtn);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.rateBtn);
        floatingActionButton3 = (FloatingActionButton) findViewById(R.id.feedbackBtn);
        floatingActionButton4 = (FloatingActionButton) findViewById(R.id.aboutBtn);

        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.facebook.com");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);

                intent.setData(Uri.parse("market://details?id=com.example.heisenberg.pocket_rgpv"));

                try{
                    startActivity(intent);
                } catch (Exception ex) {
                    intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.example.heisenberg.pocket_rgpv"));
                }
            }
        });

        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);

                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"pocket-rgpv@outlook.com"});

                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Put Subject here !");

                emailIntent.putExtra(Intent.EXTRA_TEXT, "Put your message !");

                emailIntent.setType("plain/text");
                startActivity(emailIntent);
            }
        });

        floatingActionButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.about_us);
            }
        });
    }
}
