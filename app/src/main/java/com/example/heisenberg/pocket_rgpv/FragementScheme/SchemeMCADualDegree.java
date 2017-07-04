package com.example.heisenberg.pocket_rgpv.FragementScheme;


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
public class SchemeMCADualDegree extends Fragment {

    private int lastExpandedPosition = -1;

    public SchemeMCADualDegree() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_scheme_mcadual_degree, container, false);
        View view = inflater.inflate(R.layout.fragment_scheme, null);
        final ExpandableListView expandableListView = (ExpandableListView) view.findViewById(R.id.expandableListViewScheme);
        expandableListView.setAdapter(new SchemeMCADualDegree.SchemeExpandableListAdapter());

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if(lastExpandedPosition != -1 && groupPosition != lastExpandedPosition){
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
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

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