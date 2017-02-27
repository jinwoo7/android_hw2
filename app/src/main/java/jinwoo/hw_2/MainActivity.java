package jinwoo.hw_2;

import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import jinwoo.hw_2.fragments.HomeScreenFragment;
import jinwoo.hw_2.fragments.MyStepsFragment;
import jinwoo.hw_2.fragments.TaskFragment;
import jinwoo.hw_2.fragments.TeamFragment;
import jinwoo.hw_2.interfaces.HomeScreenInteraction;

public class MainActivity extends AppCompatActivity implements HomeScreenInteraction {

    public final static String FRAG_home_TAG = "home_fragment";
    public static final String TAG_MY_STEPS_FRAGMENT = "my_info_fragment";
    public static final String TAG_TEAM_FRAGMENT = "team_fragment";

    private int portraitFrag = 0;
    private HomeScreenFragment f1;
    private MyStepsFragment f2;
    private TeamFragment f3;
//
//    private TalkToHome t1;
//    private TalkToSecond t2;
//    private TalkToThird t3;

//    private TaskFragment r1, r2, r3;
    int duration = Toast.LENGTH_SHORT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        if (savedInstanceState == null) {
            f1 = new HomeScreenFragment();
            f1.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.frame, f1, FRAG_home_TAG).commit();
        }
//        // Initializing AddNote fragment
//        if (getFragmentManager().findFragmentByTag(FRAG_home_TAG) == null) {
//
//            f1 = new HomeScreenFragment();
//            getFragmentManager().beginTransaction()
//                    .add(R.id.frame, f1, FRAG_home_TAG).commit();
//
//        }

        if (savedInstanceState != null) {

            f1 = (HomeScreenFragment) getSupportFragmentManager().findFragmentByTag(
                    FRAG_home_TAG);
            f2 = (MyStepsFragment) getSupportFragmentManager().findFragmentByTag(
                    TAG_MY_STEPS_FRAGMENT);
            f3 = (TeamFragment) getSupportFragmentManager().findFragmentByTag(
                    TAG_TEAM_FRAGMENT);
        }

    }

//    private void connectWithRetianedFragments(){
//        FragmentManager fm = getFragmentManager();
//        r1 = (TaskFragment) fm.findFragmentByTag(TAG_TEAM_FRAGMENT);
//
//
//        // If the Fragment is non-null, then it is currently being
//        // retained across a configuration change.
//        if (r1 == null) {
//            r1 = new TaskFragment();
//            fm.beginTransaction().add(r1, TAG_TEAM_FRAGMENT).commit();
//        }
//
//    }
    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public void changeFragment(String fragment_name) {
        switch (fragment_name){
            case FRAG_home_TAG:
                if (getSupportFragmentManager().findFragmentByTag(FRAG_home_TAG) == null)
                    f1 = new HomeScreenFragment();

                getSupportFragmentManager().beginTransaction().replace(R.id.frame, f1).addToBackStack(FRAG_home_TAG).commit();
                break;
            case TAG_MY_STEPS_FRAGMENT:
                if (getSupportFragmentManager().findFragmentByTag(TAG_MY_STEPS_FRAGMENT) == null)
                    f2 = new MyStepsFragment();

                getSupportFragmentManager().beginTransaction().replace(R.id.frame, f2).addToBackStack(TAG_MY_STEPS_FRAGMENT).commit();
                break;
            case TAG_TEAM_FRAGMENT:
                if (getSupportFragmentManager().findFragmentByTag(TAG_TEAM_FRAGMENT) == null)
                    f3 = new TeamFragment();

                getSupportFragmentManager().beginTransaction().replace(R.id.frame, f3).addToBackStack(TAG_TEAM_FRAGMENT).commit();
                break;
        }
    }
}



