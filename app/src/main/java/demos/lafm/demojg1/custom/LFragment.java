package demos.lafm.demojg1.custom;

import android.support.v4.app.Fragment;
import android.view.View;

public abstract class LFragment extends Fragment {

    public Object data;
    public int position;
    public boolean isLast;

    public View onCreateView(View view) {
        onUpdateView();
        return view;
    }

    public void onUpdateView(){

    }

}
