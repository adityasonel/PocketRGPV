package com.example.heisenberg.pocket_rgpv;

import android.Manifest;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.File;
import java.sql.Time;

public class TimeTable extends AppCompatActivity {

    private String postUrl = "https://www.rgpv.ac.in/Uni/frm_ViewTT.aspx";

    private ProgressBar progressBar;
    private WebView webView;

    String mainFolder = "Pocket RGPV";
    String timeTableFolder = "Time Table";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Time Table");
        setContentView(R.layout.activity_time_table);

        webView = (WebView) findViewById(R.id.timeTableWebView);
        progressBar = (ProgressBar) findViewById(R.id.timeTableProgressBar);

        if (!TextUtils.isEmpty(getIntent().getStringExtra("postUrl"))) {
            postUrl = getIntent().getStringExtra("postUrl");
        }

        initWebView();
        renderPost();

    }

    private void initWebView() {

        webView.setWebChromeClient(new MyWebChromeClient(this));

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {


                if (url.endsWith(".pdf")) {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                    request.setTitle("");

                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                    String nameOfFile = "Timetable.pdf";

                    //String nameOfFile = URLUtil.guessFileName(url, null, MimeTypeMap.getFileExtensionFromUrl(url));

                    File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + timeTableFolder);
                    if (!f.exists()) {
                        f.mkdirs();
                    }

                    request.setDestinationInExternalPublicDir(mainFolder + "/" + timeTableFolder, nameOfFile);

                    DownloadManager downloadManager = (DownloadManager) getApplicationContext().getSystemService(Context.DOWNLOAD_SERVICE);

                    downloadManager.enqueue(request);
                }
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
            }
        });

        webView.setPadding(0,0,0,0);
        webView.setInitialScale(getScale());

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        webView.getSettings().setLoadWithOverviewMode(true);

        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
    }

    private void renderPost() {
        webView.loadUrl(postUrl);
    }

    private class MyWebChromeClient extends WebChromeClient {
        Context context;

        public MyWebChromeClient(Context context) {
            super();
            this.context = context;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.timetable, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.refresh) {
            Toast toast = Toast.makeText(getApplicationContext(),"Refreshing...",Toast.LENGTH_SHORT);
            toast.show();

            setContentView(R.layout.activity_time_table);

            webView = (WebView) findViewById(R.id.timeTableWebView);
            progressBar = (ProgressBar) findViewById(R.id.timeTableProgressBar);

            if (!TextUtils.isEmpty(getIntent().getStringExtra("postUrl"))) {
                postUrl = getIntent().getStringExtra("postUrl");
            }

            initWebView();
            renderPost();
        } else if (id == R.id.stop) {
            Toast toast = Toast.makeText(getApplicationContext(), "Stopped.", Toast.LENGTH_SHORT);
            toast.show();

            webView.stopLoading();
        } /*else if (id == R.id.home) {
            Intent intent = new Intent(TimeTable.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }*/
        return super.onOptionsItemSelected(item);
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