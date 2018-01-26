package demos.lafm.demojg1;

import android.content.pm.ActivityInfo;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

import demos.lafm.demojg1.Adapter.FragmentAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private List<Fragment> fragments = new ArrayList<>();
    private FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        pager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        pager.setAdapter(adapter);

    }







}
