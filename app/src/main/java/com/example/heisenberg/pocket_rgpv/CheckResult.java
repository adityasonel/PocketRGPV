package com.example.heisenberg.pocket_rgpv;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
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

public class CheckResult extends AppCompatActivity {

    private String postUrl = "http://result.rgpv.ac.in/Result/ProgramSelect.aspx";
    private ProgressBar progressBar;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Check Result");

        setContentView(R.layout.activity_check_result);

        webView = (WebView) findViewById(R.id.resultWebView);
        progressBar = (ProgressBar) findViewById(R.id.resultProgressBar);

        if (!TextUtils.isEmpty(getIntent().getStringExtra("postUrl"))) {
            postUrl = getIntent().getStringExtra("postUrl");
        }

        initWebView();
        renderPost();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.refresh) {
            Toast toast = Toast.makeText(CheckResult.this, "Refreshing...", Toast.LENGTH_SHORT);
            toast.show();

            setContentView(R.layout.activity_check_result);

            webView = (WebView) findViewById(R.id.resultWebView);
            progressBar = (ProgressBar) findViewById(R.id.resultProgressBar);

            if (!TextUtils.isEmpty(getIntent().getStringExtra("postUrl"))) {
                postUrl = getIntent().getStringExtra("postUrl");
            }

            initWebView();
            renderPost();
        } else if (id == R.id.stop) {
            Toast toast = Toast.makeText(getApplicationContext(), "Stopped.", Toast.LENGTH_SHORT);
            toast.show();

            webView.stopLoading();
        }else if (id == R.id.home) {
            Intent intent = new Intent(CheckResult.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    private void initWebView() {

        webView.setWebChromeClient(new MyWebChromeClient(this));

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                if (Utils.isSameDomain(postUrl, url)) {
                    Intent intent = new Intent(CheckResult.this, CheckResult.class);
                    intent.putExtra("postUrl", url);
                    startActivity(intent);
                } else {
                    openInAppBrowser(url);
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

        webView.getSettings().setLoadWithOverviewMode(true);

        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
    }

    private void renderPost() {
        webView.loadUrl(postUrl);
    }

    private void openInAppBrowser(String url) {
        Intent intent = new Intent(CheckResult.this, CheckResult.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }

    private class MyWebChromeClient extends WebChromeClient {
        Context context;

        public MyWebChromeClient(Context context) {
            super();
            this.context = context;
        }
    }

    public static class Utils {

        public static boolean isSameDomain(String url, String url1) {
            return getRootDomainUrl(url.toLowerCase()).equals(getRootDomainUrl(url1.toLowerCase()));
        }

        private static String getRootDomainUrl(String url) {
            String[] domainKeys = url.split("/")[2].split("\\.");
            int length = domainKeys.length;
            int dummy = domainKeys[0].equals("www") ? 1 : 0;
            if (length - dummy == 2)
                return domainKeys[length - 2] + "." + domainKeys[length - 1];
            else {
                if (domainKeys[length - 1].length() == 2) {
                    return domainKeys[length - 3] + "." + domainKeys[length - 2] + "." + domainKeys[length - 1];
                } else {
                    return domainKeys[length - 2] + "." + domainKeys[length - 1];
                }
            }
        }
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