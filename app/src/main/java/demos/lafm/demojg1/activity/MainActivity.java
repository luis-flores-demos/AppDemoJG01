package demos.lafm.demojg1.activity;

import android.content.pm.ActivityInfo;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import demos.lafm.demojg1.R;
import demos.lafm.demojg1.custom.LFragment;
import demos.lafm.demojg1.custom.LFragmentAdapter;
import demos.lafm.demojg1.custom.LNonSwipeableViewPager;
import demos.lafm.demojg1.fragment.SesionFragment;

public class MainActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private LNonSwipeableViewPager pager;
    private List<LFragment> fragments = new ArrayList<>();
    private LFragmentAdapter adapter;

    private TextView txt_title;
    private LinearLayout content_menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        txt_title = (TextView) findViewById(R.id.txt_title);
        content_menu = (LinearLayout) findViewById(R.id.content_menu);
        pager = (LNonSwipeableViewPager) findViewById(R.id.view_pager);

        adapter = new LFragmentAdapter(getSupportFragmentManager(), fragments);
        pager.setAdapter(adapter);
        initInicio(true);

    }

    public void initInicio(boolean login){

        if(login){
            LFragment fragment = new SesionFragment();
            fragment.position = 0;
            addFragment(fragment);
        }else{
            txt_title.setVisibility(View.GONE);
            content_menu.setVisibility(View.VISIBLE);
        }


    }

    public void addFragment(LFragment fragment){

        boolean exists = false;

        for(LFragment frag : fragments)
            if(frag.position == fragment.position){
                exists = true;
                frag.onUpdateView();
                break;
            }

        if(!exists){
            fragments.add(fragment);
            adapter.notifyDataSetChanged();
        }

        pager.setCurrentItem(fragment.position, true);

    }




}
