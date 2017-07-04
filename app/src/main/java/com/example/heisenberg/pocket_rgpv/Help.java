package com.example.heisenberg.pocket_rgpv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        setTitle("Help");

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    setContentView(R.layout.layout_faq_0);
                } else if (position == 1) {
                    setContentView(R.layout.layout_faq_1);
                } else if (position == 2) {
                    setContentView(R.layout.layout_faq_2);
                } else if (position == 3) {
                    setContentView(R.layout.layout_faq_3);
                } else if (position == 4) {
                    setContentView(R.layout.layout_faq_4);
                } else if (position == 5) {
                    setContentView(R.layout.layout_faq_5);
                } else if (position == 6) {
                    setContentView(R.layout.layout_faq_6);
                }
            }
        };

        ListView listView = (ListView) findViewById(R.id.helpListView);
        listView.setOnItemClickListener(itemClickListener);
    }
}
