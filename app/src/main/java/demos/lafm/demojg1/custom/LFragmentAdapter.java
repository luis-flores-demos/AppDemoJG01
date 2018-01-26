package demos.lafm.demojg1.custom;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class LFragmentAdapter extends FragmentPagerAdapter {

    private List<LFragment> fragments = new ArrayList<>();

    public LFragmentAdapter(FragmentManager fm, List<LFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public LFragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

}
