package jinwoo.hw_2.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.reflect.Member;
import java.util.ArrayList;

import jinwoo.hw_2.R;
import jinwoo.hw_2.data.TeamMember;

/**
 * Created by Andrey on 2/16/2017.
 */

public class TeamFragment extends Fragment {

    public static final String TAG_TEAM_FRAGMENT = "team_fragment";


    private ArrayList<TeamMember> members;

    private ListView memberList;
    private TeamMemberArrayAdapter teamMemberListAdapter;

    public static TeamFragment newInstance() {
        TeamFragment fragment = new TeamFragment();
        return fragment;
    }

    public TeamFragment() {
        // Required empty public constructor
    }


    private class TeamMemberArrayAdapter extends ArrayAdapter<TeamMember> {
        private final Context context;
        private final ArrayList<TeamMember> members;
        private int id;

        public TeamMemberArrayAdapter(Context context,  int id, ArrayList members) {
            super(context, id, members);
            this.context    = context;
            this.members    = members;
            this.id         = id;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            TeamMember teamMember = getItem(position);

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.team_member_list_view_layout, parent, false);

            // initialize the views and connect them to the data
            TextView memberText = (TextView) convertView.findViewById(R.id.list_member_text);
            ProgressBar pBar    = (ProgressBar) convertView.findViewById(R.id.list_member_pbar);
            TextView leftText   = (TextView) convertView.findViewById(R.id.list_member_leftNum);
            TextView rightText  = (TextView) convertView.findViewById(R.id.list_member_rightNum);

            // Fill each new referenced view with data associated with note it's referencing
            memberText.setText(teamMember.getName() + "\'s steps");
            pBar.setMax(teamMember.getGoal());
            pBar.setProgress(teamMember.getSteps());
            leftText.setText(String.valueOf(teamMember.getSteps()));
            rightText.setText(String.valueOf(teamMember.getGoal()));
            return convertView;
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team, container, false);
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        members = new ArrayList<TeamMember>();

        members.add(new TeamMember("A",10000,20000 ));
        members.add(new TeamMember("B",5000,15000 ));
        members.add(new TeamMember("C",6700,18000 ));
        members.add(new TeamMember("D",1000,3000 ));
        members.add(new TeamMember("E",10000,50000 ));
        members.add(new TeamMember("F",5000,13000 ));


        memberList = (ListView)view.findViewById(R.id.team_members);
        teamMemberListAdapter= new TeamMemberArrayAdapter(getActivity(), R.layout.team_member_list_view_layout, members);
        memberList.setAdapter(teamMemberListAdapter);



    }


}
