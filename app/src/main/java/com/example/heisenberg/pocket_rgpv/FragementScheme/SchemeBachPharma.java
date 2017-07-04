package com.example.heisenberg.pocket_rgpv.FragementScheme;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.heisenberg.pocket_rgpv.About;
import com.example.heisenberg.pocket_rgpv.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SchemeBachPharma extends Fragment {

    private int lastExpandedPosition = -1;

    public SchemeBachPharma() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_scheme_bach_pharma, container, false);
        View view = inflater.inflate(R.layout.fragment_scheme, null);
        final ExpandableListView expandableListView = (ExpandableListView) view.findViewById(R.id.expandableListViewScheme);
        expandableListView.setAdapter(new SchemeBachPharma.SchemeExpandableListAdapter());

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
                {"I Semester"},
                {"II Semester", "B. Pharmacy II Semester PCI Regulations 2014"},
                {"B.Pharm.(Grading Sys.)", "Bachelor of Pharmacy CBCS"},
                {"B.Pharm", "B.Pharm.(Grading Sys.)"},
                {"B.Pharm", "B.Pharmacy(Grading)"},
                {"B.Pharm", "VI B.Pharmacy Scheme(Grading System)"},
                {"B.Pharmacy VII Sem Scheme (Non Grading)", "SCHEME B. PHARMACY.-VII SEMESTER (Grading System)"},
                {"Bachelor of Pharmacy VIII- Semester( New Scheme)", "B. Pharmacy (Grading System)"}
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

                    } else if (groupPosition == 0 && childPosition == 0){

                    } else if (groupPosition == 1 && childPosition == 0){

                    } else if (groupPosition == 1 && childPosition == 1){

                    } else if (groupPosition == 2 && childPosition == 0){

                    } else if (groupPosition == 2 && childPosition == 1){

                    } else if (groupPosition == 3 && childPosition == 0){

                    } else if (groupPosition == 3 && childPosition == 1){

                    } else if (groupPosition == 4 && childPosition == 0){

                    } else if (groupPosition == 4 && childPosition == 1){

                    } else if (groupPosition == 5 && childPosition == 0){

                    }else if (groupPosition == 5 && childPosition == 1){

                    }else if (groupPosition == 6 && childPosition == 0){

                    }else if (groupPosition == 6 && childPosition == 1){

                    } else if (groupPosition == 7 && childPosition == 0){

                    } else if (groupPosition == 7 && childPosition == 1){

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
