package demos.lafm.demojg1.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import demos.lafm.demojg1.R;
import demos.lafm.demojg1.activity.MainActivity;
import demos.lafm.demojg1.custom.LFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImageFragment extends LFragment {

    private View view;
    private ImageView image;
    public int imageId;

    public ImageFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.layout_image, container, false);

        image = (ImageView) view.findViewById(R.id.image);

        return onCreateView(view);
    }

    @Override
    public void onUpdateView() {

        image.setImageResource(imageId);

    }

}
