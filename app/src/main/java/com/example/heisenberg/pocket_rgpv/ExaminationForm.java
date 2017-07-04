package com.example.heisenberg.pocket_rgpv;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import static com.example.heisenberg.pocket_rgpv.R.string.description;

/**
 * Created by HeisenBerg on 4/15/2017.
 */

public class ExaminationForm extends AppCompatActivity {

    private WebView webView;
    private ProgressBar progressBar;

    private String examinationPageUrl = "https://www.rgpv.ac.in/AboutRGTU/Examination.aspx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_examination_form);

        setTitle("Examination Form");

        webView = (WebView) findViewById(R.id.examinationFormWebView);
        progressBar = (ProgressBar) findViewById(R.id.examinationFormProgressBar);

            initWebView();
    }

    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
            return false;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.examination_form, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.refresh) {
            Toast toast = Toast.makeText(getApplicationContext(), "Refreshing...", Toast.LENGTH_SHORT);
            toast.show();

            setContentView(R.layout.activity_examination_form);

            setTitle("Examination Form");

            webView = (WebView) findViewById(R.id.examinationFormWebView);
            progressBar = (ProgressBar) findViewById(R.id.examinationFormProgressBar);

            initWebView();
        } else if(id == R.id.stop) {
            Toast toast = Toast.makeText(getApplicationContext(), "Stopped.", Toast.LENGTH_SHORT);
            toast.show();

            webView.stopLoading();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initWebView() {

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.equals(examinationPageUrl)) {
                    view.loadUrl(url);
                }
                return true;
            }
        });

        webView.loadUrl(examinationPageUrl);

        webView.setPadding(0,0,0,0);
        webView.setInitialScale(getScale());

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);

        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
    }

    private int getScale(){
        Display display = ((WindowManager) getSystemService(getApplicationContext().WINDOW_SERVICE)).getDefaultDisplay();
        int width = display.getWidth();
        Double val = new Double(width)/new Double(width);

        if (Build.VERSION.SDK_INT <= 23) {
            val = val * 120d;
        } else {
            val = val * 75d;
        }

        return  val.intValue();
    }
}
