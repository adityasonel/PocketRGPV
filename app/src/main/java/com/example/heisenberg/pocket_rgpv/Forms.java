package com.example.heisenberg.pocket_rgpv;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.File;
import java.text.Normalizer;

/**
 * Created by HeisenBerg on 4/29/2017.
 */

public class Forms extends AppCompatActivity {

    String mainFolder = "Pocket RGPV";
    String otherFolder = "Other";

    String transcriptFormat = "https://firebasestorage.googleapis.com/v0/b/pocket-rgpv-6da19.appspot.com/o/Others%2FTranscript%20Format.doc?alt=media&token=25428929-185f-4cf2-9284-300939627567";
    String degreeForm = "https://firebasestorage.googleapis.com/v0/b/pocket-rgpv-6da19.appspot.com/o/Others%2FDegree%20Form.pdf?alt=media&token=031985b6-5041-4554-bc7d-ba34e04355c9";
    String duplicateMarksheetForm = "https://firebasestorage.googleapis.com/v0/b/pocket-rgpv-6da19.appspot.com/o/Others%2FDuplicate_Corrected%20Marksheet%20Form.pdf?alt=media&token=4bfc8007-faa6-408d-9de4-910fd884e48b";
    String migrationProvisionalCertificate = "https://firebasestorage.googleapis.com/v0/b/pocket-rgpv-6da19.appspot.com/o/Others%2FMigration_Provisional%20Certificate.pdf?alt=media&token=b7695036-8ef2-4a39-b3e8-bec0c9312443";
    String duplicateDegreeForm = "https://firebasestorage.googleapis.com/v0/b/pocket-rgpv-6da19.appspot.com/o/Others%2FDuplicate%20Degree%20Form.pdf?alt=media&token=19880ccc-7cf8-41dc-bfde-546f70e324cd";
    String enrollmentForm = "https://firebasestorage.googleapis.com/v0/b/pocket-rgpv-6da19.appspot.com/o/Others%2FEnrollment%20Form.pdf?alt=media&token=df2d2ac1-8861-4955-96ad-2e2322e05c46";
    String examinationApplicationForm = "https://firebasestorage.googleapis.com/v0/b/pocket-rgpv-6da19.appspot.com/o/Others%2FExamination%20Application%20Form.pdf?alt=media&token=f88b0b91-1814-462b-b12e-d428fba5a657";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms);
        setTitle("Forms");

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0){

                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(transcriptFormat));
                    request.setTitle("");

                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                    String nameOfFile = URLUtil.guessFileName(transcriptFormat, null, MimeTypeMap.getFileExtensionFromUrl(transcriptFormat));

                    File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + otherFolder);
                    if (!f.exists()) {
                        f.mkdirs();
                    }

                    request.setDestinationInExternalPublicDir(mainFolder + "/" + otherFolder, nameOfFile);

                    DownloadManager downloadManager = (DownloadManager) getApplicationContext().getSystemService(Context.DOWNLOAD_SERVICE);

                    downloadManager.enqueue(request);
                } else if (position == 1){
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(degreeForm));
                    request.setTitle("");

                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                    String nameOfFile = URLUtil.guessFileName(degreeForm, null, MimeTypeMap.getFileExtensionFromUrl(degreeForm));

                    File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + otherFolder);
                    if (!f.exists()) {
                        f.mkdirs();
                    }

                    request.setDestinationInExternalPublicDir(mainFolder + "/" + otherFolder, nameOfFile);

                    DownloadManager downloadManager = (DownloadManager) getApplicationContext().getSystemService(Context.DOWNLOAD_SERVICE);

                    downloadManager.enqueue(request);
                } else if (position == 2){
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(duplicateMarksheetForm));
                    request.setTitle("");

                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                    String nameOfFile = URLUtil.guessFileName(duplicateMarksheetForm, null, MimeTypeMap.getFileExtensionFromUrl(duplicateMarksheetForm));

                    File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + otherFolder);
                    if (!f.exists()) {
                        f.mkdirs();
                    }

                    request.setDestinationInExternalPublicDir(mainFolder + "/" + otherFolder, nameOfFile);

                    DownloadManager downloadManager = (DownloadManager) getApplicationContext().getSystemService(Context.DOWNLOAD_SERVICE);

                    downloadManager.enqueue(request);
                } else if (position == 3){
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(migrationProvisionalCertificate));
                    request.setTitle("");

                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                    String nameOfFile = URLUtil.guessFileName(migrationProvisionalCertificate, null, MimeTypeMap.getFileExtensionFromUrl(migrationProvisionalCertificate));

                    File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + otherFolder);
                    if (!f.exists()) {
                        f.mkdirs();
                    }

                    request.setDestinationInExternalPublicDir(mainFolder + "/" + otherFolder, nameOfFile);

                    DownloadManager downloadManager = (DownloadManager) getApplicationContext().getSystemService(Context.DOWNLOAD_SERVICE);

                    downloadManager.enqueue(request);
                } else if (position == 4){
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(duplicateDegreeForm));
                    request.setTitle("");

                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                    String nameOfFile = URLUtil.guessFileName(duplicateDegreeForm, null, MimeTypeMap.getFileExtensionFromUrl(duplicateDegreeForm));

                    File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + otherFolder);
                    if (!f.exists()) {
                        f.mkdirs();
                    }

                    request.setDestinationInExternalPublicDir(mainFolder + "/" + otherFolder, nameOfFile);

                    DownloadManager downloadManager = (DownloadManager) getApplicationContext().getSystemService(Context.DOWNLOAD_SERVICE);

                    downloadManager.enqueue(request);
                } else if (position == 5){
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(enrollmentForm));
                    request.setTitle("");

                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                    String nameOfFile = URLUtil.guessFileName(enrollmentForm, null, MimeTypeMap.getFileExtensionFromUrl(enrollmentForm));

                    File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + otherFolder);
                    if (!f.exists()) {
                        f.mkdirs();
                    }

                    request.setDestinationInExternalPublicDir(mainFolder + "/" + otherFolder, nameOfFile);

                    DownloadManager downloadManager = (DownloadManager) getApplicationContext().getSystemService(Context.DOWNLOAD_SERVICE);

                    downloadManager.enqueue(request);
                } else if (position == 6){
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(examinationApplicationForm));
                    request.setTitle("");

                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                    String nameOfFile = URLUtil.guessFileName(examinationApplicationForm, null, MimeTypeMap.getFileExtensionFromUrl(examinationApplicationForm));

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

        ListView listView = (ListView) findViewById(R.id.listViewForms);
        listView.setOnItemClickListener(itemClickListener);
    }
}
