package com.example.heisenberg.pocket_rgpv.FragementSyllabus;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.heisenberg.pocket_rgpv.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SyllabusDiploma extends Fragment {


    public SyllabusDiploma() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         return inflater.inflate(R.layout.fragment_diploma, container, false);
    }
}