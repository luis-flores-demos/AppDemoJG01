package demos.lafm.demojg1.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import demos.lafm.demojg1.R;
import demos.lafm.demojg1.activity.MainActivity;
import demos.lafm.demojg1.custom.LFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SesionFragment extends LFragment {

    private MainActivity context;
    private View view;
    private EditText edit_user;
    private EditText edit_pass;
    private Button btn_inicio;

    public SesionFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = (MainActivity) getActivity();
        view = inflater.inflate(R.layout.layout_sesion, container, false);
        edit_user = (EditText) view.findViewById(R.id.edit_user);
        edit_pass = (EditText) view.findViewById(R.id.edit_pass);
        btn_inicio = (Button) view.findViewById(R.id.btn_inicio);

        return onCreateView(view);
    }

    @Override
    public void onUpdateView() {

        btn_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InicioFragment fragment = new InicioFragment();
                fragment.position = 1;
                context.initInicio(false);
                context.addFragment(fragment);
            }
        });

    }

}
