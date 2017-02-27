package jinwoo.hw_2.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import jinwoo.hw_2.interfaces.RetainedFragmentInteraction;

/**
 * Created by Andrey on 2/16/2017.
 */

public class TaskFragment extends Fragment implements RetainedFragmentInteraction {

    public static final String TAG_TASK_FRAGMENT = "task_fragment";
    private String mActiveFragmentTag;

    public static TaskFragment newInstance() {
        TaskFragment fragment = new TaskFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);


    }
    public TaskFragment() {
        // Required empty public constructor
    }



    @Override
    public void onResume() {
        super.onResume();
    }


    public String getActiveFragmentTag() {
        return mActiveFragmentTag;
    }

    public void setActiveFragmentTag(String s) {
        mActiveFragmentTag = s;
    }


    static interface TalkToHome {
        void postString(String str);
    }

    static interface TalkToMyStep {
        void postString(String str);
    }

    static interface TalkToTeamstep {
        void postString(String str);
    }

    static interface TalkToActivity {
        void postString(String str, String id);
    }

    static interface TalkToTask {
        void postString(String str);
    }
}
