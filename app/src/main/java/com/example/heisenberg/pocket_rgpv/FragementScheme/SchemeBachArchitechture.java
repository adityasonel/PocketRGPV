package com.example.heisenberg.pocket_rgpv.FragementScheme;


import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.heisenberg.pocket_rgpv.R;

import java.io.File;

/**
 * A simple {@link Fragment} subclass.
 */
public class SchemeBachArchitechture extends Fragment {

    private int lastExpandedPosition = -1;

    String mainFolder = "Pocket RGPV";
    String schemeFolder = "Scheme";

    String myHTTPUrl = "https://firebasestorage.googleapis.com/v0/b/pocket-rgpv-6da19.appspot.com/o/Scheme%2FScheme%201-2%20Sem%20A-B%20Set.pdf?alt=media&token=b3d586e6-5ecb-419e-ba25-d698fab605ad";

    public SchemeBachArchitechture() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_scheme_bach_architechture, container, false);
        View view = inflater.inflate(R.layout.fragment_scheme, null);
        final ExpandableListView expandableListView = (ExpandableListView) view.findViewById(R.id.expandableListViewScheme);
        expandableListView.setAdapter(new SchemeBachArchitechture.SchemeExpandableListAdapter());

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1 && groupPosition != lastExpandedPosition){
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }
        });

        return view;
    }

    public class SchemeExpandableListAdapter extends BaseExpandableListAdapter {

        private final LayoutInflater inf;

        public SchemeExpandableListAdapter(){
            inf = LayoutInflater.from(getActivity());
        }

        private String[] semester = {"1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester",
                "7th Semester", "8th Semester"};

        private String[][] branches = {
                {"Computer Science & Engineering", "Mechanical Engineering", "Civil Engineering", "Information & Technology"},
                {"Computer Science & Engineering", "Mechanical Engineering", "Civil Engineering", "Information & Technology"},
                {"Computer Science & Engineering", "Mechanical Engineering", "Civil Engineering", "Information & Technology"},
                {"Computer Science & Engineering", "Mechanical Engineering", "Civil Engineering", "Information & Technology"},
                {"Computer Science & Engineering", "Mechanical Engineering", "Civil Engineering", "Information & Technology"},
                {"Computer Science & Engineering", "Mechanical Engineering", "Civil Engineering", "Information & Technology"},
                {"Computer Science & Engineering", "Mechanical Engineering", "Civil Engineering", "Information & Technology"},
                {"Computer Science & Engineering", "Mechanical Engineering", "Civil Engineering", "Information & Technology"}
        };

        @Override
        public int getGroupCount() {
            return semester.length;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return branches[groupPosition].length;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return semester[groupPosition];
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return branches[groupPosition][childPosition];
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

            ViewHolder viewHolder;

            if (convertView == null) {
                convertView = inf.inflate(R.layout.list_group_syllabus, parent, false);

                viewHolder = new ViewHolder();
                viewHolder.text = (TextView) convertView.findViewById(R.id.listHeaderSyllabus);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.text.setText(getGroup(groupPosition).toString());

            return convertView;
        }

        @Override
        public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = inf.inflate(R.layout.list_item_syllabus, parent, false);
                viewHolder = new ViewHolder();

                viewHolder.text = (TextView) convertView.findViewById(R.id.listItemSyllabus);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.text.setText(getChild(groupPosition, childPosition).toString());

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (groupPosition == 0 && childPosition == 0){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);
                    } else if(groupPosition == 0 && childPosition == 1){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);
                    } else if(groupPosition == 0 && childPosition == 2){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);
                    } else if(groupPosition == 0 && childPosition == 3){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);
                    } else if(groupPosition == 1 && childPosition == 0){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);
                    }else if(groupPosition == 1 && childPosition == 1){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);
                    }else if(groupPosition == 1 && childPosition == 2){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);
                    }else if(groupPosition == 1 && childPosition == 3){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);
                    } else if(groupPosition == 2 && childPosition == 0){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);
                    } else if(groupPosition == 2 && childPosition == 1){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);

                    } else if(groupPosition == 2 && childPosition == 2){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);

                    } else if(groupPosition == 2 && childPosition == 3){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);

                    } else if(groupPosition == 3 && childPosition == 0){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);

                    } else if(groupPosition == 3 && childPosition == 1){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);

                    } else if(groupPosition == 3 && childPosition == 2){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);

                    } else if(groupPosition == 3 && childPosition == 3){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);

                    } else if(groupPosition == 4 && childPosition == 0){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);

                    } else if(groupPosition == 4 && childPosition == 1){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);

                    } else if(groupPosition == 4 && childPosition == 2){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);

                    } else if(groupPosition == 4 && childPosition == 3){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);

                    } else if(groupPosition == 5 && childPosition == 0){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);

                    } else if(groupPosition == 5 && childPosition == 1){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);

                    } else if(groupPosition == 5 && childPosition == 2){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);

                    } else if(groupPosition == 5 && childPosition == 3){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);

                    } else if(groupPosition == 6 && childPosition == 0){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);

                    } else if(groupPosition == 6 && childPosition == 1){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);

                    } else if(groupPosition == 6 && childPosition == 2){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);

                    } else if(groupPosition == 6 && childPosition == 3){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);

                    } else if(groupPosition == 7 && childPosition == 0){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);

                    } else if(groupPosition == 7 && childPosition == 1){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);

                    } else if(groupPosition == 7 && childPosition == 2){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);

                    } else if(groupPosition == 7 && childPosition == 3){

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
                        request.setTitle("");

                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                        String nameOfFile = URLUtil.guessFileName(myHTTPUrl, null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));

                        File f = new File(Environment.getExternalStorageDirectory() + "/" + mainFolder + "/" + schemeFolder);
                        if (!f.exists()) {
                            f.mkdirs();
                        }

                        request.setDestinationInExternalPublicDir(mainFolder + "/" + schemeFolder, nameOfFile);

                        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

                        downloadManager.enqueue(request);

                    }
                }
            });

            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        private class ViewHolder {
            TextView text;
        }

    }
}
