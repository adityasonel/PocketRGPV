package com.example.heisenberg.pocket_rgpv;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;

/**
 * Created by HeisenBerg on 4/29/2017.
 */

public class StudentWelfareDepartment extends AppCompatActivity {

    String mainFolder = "Pocket RGPV";
    String otherFolder = "Other";

    String prohibitionRagging = "https://firebasestorage.googleapis.com/v0/b/pocket-rgpv-6da19.appspot.com/o/Others%2FPrevention%20and%20prohibition%20of%20Ragging.pdf?alt=media&token=6b849ccb-2c8d-4fe4-a2cc-0b7315fb8e5f";
    String affidavit = "https://firebasestorage.googleapis.com/v0/b/pocket-rgpv-6da19.appspot.com/o/Others%2FAffidavit%20of%20AICTE%20regarding%20Anti%20Ragging.pdf?alt=media&token=8860e4fa-13ba-4d38-8a3e-d259d9cfbb33";
    String aicteNotification = "https://firebasestorage.googleapis.com/v0/b/pocket-rgpv-6da19.appspot.com/o/Others%2FAICTE%20Notification%20Regarding%20Antiragging.pdf?alt=media&token=d2c0ac35-00ba-433e-bdf1-4939a5ac7f8d";
    String circular01 = "https://firebasestorage.googleapis.com/v0/b/pocket-rgpv-6da19.appspot.com/o/Others%2FCircular%2001%20regarding%20Anti%20Ragging.pdf?alt=media&token=46c1ae62-2084-4885-a557-45eeecc8402e";
    String circular02 = "https://firebasestorage.googleapis.com/v0/b/pocket-rgpv-6da19.appspot.com/o/Others%2FCircular%2002%20regarding%20Anti%20Ragging.pdf?alt=media&token=e1ec0cdd-3034-4270-b5dc-dcbccd3d1c23";
    String circular03 = "https://firebasestorage.googleapis.com/v0/b/pocket-rgpv-6da19.appspot.com/o/Others%2FCircular%2003%20regarding%20Anti%20Ragging.pdf?alt=media&token=3ae34ff2-ccd7-4b1b-ba64-ab3d8a22b29b";
    String financialAssistance = "https://firebasestorage.googleapis.com/v0/b/pocket-rgpv-6da19.appspot.com/o/Others%2FFinancial%20assistance%20for%20accidental%20death%20or%20permanent%20disability.pdf?alt=media&token=92e7a2ce-5e7c-4d9a-b6b6-8477a7ef324b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_welfare_department);
        setTitle("Student Welfare Department");

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view, int position, long id) {

                if(position == 0){
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(prohibitionRagging));
                    request.setTitle("");

                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                    String nameOfFile = URLUtil.guessFileName(prohibitionRagging, null, MimeTypeMap.getFileExtensionFromUrl(prohibitionRagging));

                    File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + otherFolder);
                    if (!f.exists()) {
                        f.mkdirs();
                    }

                    request.setDestinationInExternalPublicDir(mainFolder + "/" + otherFolder, nameOfFile);

                    DownloadManager downloadManager = (DownloadManager) getApplicationContext().getSystemService(Context.DOWNLOAD_SERVICE);

                    downloadManager.enqueue(request);
                }
                else if(position == 1){
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(affidavit));
                    request.setTitle("");

                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                    String nameOfFile = URLUtil.guessFileName(affidavit, null, MimeTypeMap.getFileExtensionFromUrl(affidavit));

                    File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + otherFolder);
                    if (!f.exists()) {
                        f.mkdirs();
                    }

                    request.setDestinationInExternalPublicDir(mainFolder + "/" + otherFolder, nameOfFile);

                    DownloadManager downloadManager = (DownloadManager) getApplicationContext().getSystemService(Context.DOWNLOAD_SERVICE);

                    downloadManager.enqueue(request);
                }
                else if (position == 2){
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(aicteNotification));
                    request.setTitle("");

                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                    String nameOfFile = URLUtil.guessFileName(aicteNotification, null, MimeTypeMap.getFileExtensionFromUrl(aicteNotification));

                    File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + otherFolder);
                    if (!f.exists()) {
                        f.mkdirs();
                    }

                    request.setDestinationInExternalPublicDir(mainFolder + "/" + otherFolder, nameOfFile);

                    DownloadManager downloadManager = (DownloadManager) getApplicationContext().getSystemService(Context.DOWNLOAD_SERVICE);

                    downloadManager.enqueue(request);
                }
                else if(position == 3){
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(circular01));
                    request.setTitle("");

                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                    String nameOfFile = URLUtil.guessFileName(circular01, null, MimeTypeMap.getFileExtensionFromUrl(circular01));

                    File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + otherFolder);
                    if (!f.exists()) {
                        f.mkdirs();
                    }

                    request.setDestinationInExternalPublicDir(mainFolder + "/" + otherFolder, nameOfFile);

                    DownloadManager downloadManager = (DownloadManager) getApplicationContext().getSystemService(Context.DOWNLOAD_SERVICE);

                    downloadManager.enqueue(request);
                }
                else if(position == 4){
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(circular02));
                    request.setTitle("");

                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                    String nameOfFile = URLUtil.guessFileName(circular02, null, MimeTypeMap.getFileExtensionFromUrl(circular02));

                    File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + otherFolder);
                    if (!f.exists()) {
                        f.mkdirs();
                    }

                    request.setDestinationInExternalPublicDir(mainFolder + "/" + otherFolder, nameOfFile);

                    DownloadManager downloadManager = (DownloadManager) getApplicationContext().getSystemService(Context.DOWNLOAD_SERVICE);

                    downloadManager.enqueue(request);
                }
                else if(position == 5){
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(circular03));
                    request.setTitle("");

                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                    String nameOfFile = URLUtil.guessFileName(circular03, null, MimeTypeMap.getFileExtensionFromUrl(circular03));

                    File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + otherFolder);
                    if (!f.exists()) {
                        f.mkdirs();
                    }

                    request.setDestinationInExternalPublicDir(mainFolder + "/" + otherFolder, nameOfFile);

                    DownloadManager downloadManager = (DownloadManager) getApplicationContext().getSystemService(Context.DOWNLOAD_SERVICE);

                    downloadManager.enqueue(request);
                } else if (position == 6){
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(financialAssistance));
                    request.setTitle("");

                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                    String nameOfFile = URLUtil.guessFileName(financialAssistance, null, MimeTypeMap.getFileExtensionFromUrl(financialAssistance));

                    File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + otherFolder);
                    if (!f.exists()) {
                        f.mkdirs();
                    }

                    request.setDestinationInExternalPublicDir(mainFolder + "/" + otherFolder, nameOfFile);

                    DownloadManager downloadManager = (DownloadManager) getApplicationContext().getSystemService(Context.DOWNLOAD_SERVICE);

                    downloadManager.enqueue(request);
                }
            }
        };

        ListView listView = (ListView) findViewById(R.id.swdListView);
        listView.setOnItemClickListener(itemClickListener);
    }
}
