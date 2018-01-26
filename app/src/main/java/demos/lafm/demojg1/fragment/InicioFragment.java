package demos.lafm.demojg1.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import demos.lafm.demojg1.R;
import demos.lafm.demojg1.activity.MainActivity;
import demos.lafm.demojg1.custom.LFragment;
import demos.lafm.demojg1.custom.LFragmentAdapter;
import me.relex.circleindicator.CircleIndicator;

/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends LFragment {

    private MainActivity context;
    private View view;
    private ViewPager pager;
    private CircleIndicator indicator;
    private LFragmentAdapter adapter;
    private ArrayList<LFragment> fragments = new ArrayList<>();

    private int[] contenido = {
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3
    };

    public InicioFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = (MainActivity) getActivity();
        view = inflater.inflate(R.layout.layout_inicio, container, false);
        indicator = (CircleIndicator) view.findViewById(R.id.indicator);
        pager = (ViewPager) view.findViewById(R.id.view_pager_images);

        return onCreateView(view);
    }

    @Override
    public void onUpdateView() {

        for(int id : contenido){
            ImageFragment img = new ImageFragment();
            img.imageId = id;
            fragments.add(img);
        }

        adapter = new LFragmentAdapter(getFragmentManager(), fragments);
        pager.setAdapter(adapter);
        indicator.setViewPager(pager);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

}
