package demos.lafm.demojg1.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import demos.lafm.demojg1.R;
import demos.lafm.demojg1.activity.MainActivity;
import demos.lafm.demojg1.custom.LFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class IformacionFragment extends LFragment {

    private MainActivity context;
    private View view;

    public IformacionFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = (MainActivity) getActivity();
        view = inflater.inflate(R.layout.layout_informacion, container, false);

        return onCreateView(view);
    }

    @Override
    public void onUpdateView() {

    }

}
