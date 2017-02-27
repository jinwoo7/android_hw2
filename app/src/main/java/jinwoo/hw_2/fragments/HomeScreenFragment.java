package jinwoo.hw_2.fragments;

import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import jinwoo.hw_2.R;
import jinwoo.hw_2.interfaces.HomeScreenInteraction;

import static android.R.attr.start;
import static jinwoo.hw_2.fragments.TaskFragment.TAG_TASK_FRAGMENT;

/**
 * Created by Andrey on 2/16/2017.
 */




public class HomeScreenFragment extends Fragment implements View.OnClickListener  {

    public final static String FRAG_home_TAG = "home_fragment";
   //TextView and progressbar variables

    private TextView mysteps, teamsteps, myrank,teamrank;
    private ProgressBar mygoal, teamgoal;
    private Button b_mysteps, b_teamsteps, b_myrank,b_teamrank;

    private HomeScreenInteraction activity;

    int duration = Toast.LENGTH_SHORT;

    //We will be clicking on the imageviews, thus we need two variables to represent the top left and top right imageviews.



    public static HomeScreenFragment newInstance() {
        HomeScreenFragment fragment = new HomeScreenFragment();
        return fragment;
    }

    public HomeScreenFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof HomeScreenInteraction) {
//            activity = (HomeScreenInteraction) context;
//
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement HomeScreenInteraction");
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);



       //initalise the views and add OnclickListeners as needed

        mysteps     = (TextView) view.findViewById(R.id.mySteps_text);
        myrank      = (TextView) view.findViewById(R.id.myRank_text);
        teamsteps   = (TextView) view.findViewById(R.id.teamSteps_text);
        teamrank    = (TextView) view.findViewById(R.id.teamRank_text);

        mygoal      = (ProgressBar) view.findViewById(R.id.mySteps_bar);
        teamgoal    = (ProgressBar) view.findViewById(R.id.teamSteps_bar);

        b_mysteps   = (Button) view.findViewById(R.id.mySteps);
        b_myrank    = (Button) view.findViewById(R.id.myRank);
        b_teamsteps = (Button) view.findViewById(R.id.teamSteps);
        b_teamrank  = (Button) view.findViewById(R.id.teamRank);

        activity = (HomeScreenInteraction) this.getActivity();

        Random r = new Random();

        // progress bars
        mygoal.setProgress(r.nextInt(100 + 1));
        teamgoal.setProgress(r.nextInt(100 + 1));

        // texts
        mysteps.setText(R.string.text_mySteps);
        teamsteps.setText(R.string.text_teamSteps);
        myrank.setText(R.string.text_myrank);
        teamrank.setText(R.string.text_teamrank);

        b_mysteps.setOnClickListener(this);
        b_myrank.setOnClickListener(this);
        b_teamsteps.setOnClickListener(this);
        b_teamrank.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
        if(v.equals(b_mysteps)){
            // tell the activity to change fragment to MyStepsFragment
            activity.changeFragment(MyStepsFragment.TAG_MY_STEPS_FRAGMENT);
        }
        if(v.equals(b_teamsteps)){
            // tell the activity to change fragment to TeamFragment
            activity.changeFragment(TeamFragment.TAG_TEAM_FRAGMENT);
        }
    }
}
