package demos.lafm.demojg1.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import demos.lafm.demojg1.R;
import demos.lafm.demojg1.activity.MainActivity;
import demos.lafm.demojg1.custom.LFragment;
import demos.lafm.demojg1.custom.Utils;
import demos.lafm.demojg1.model.Solicitud;

/**
 * A simple {@link Fragment} subclass.
 */
public class RequerimientoFragment extends LFragment {

    private MainActivity context;
    private View view;
    private ImageView img_camara;
    private Button btn_solicitudes;

    public RequerimientoFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = (MainActivity) getActivity();
        view = inflater.inflate(R.layout.layout_requerimiento, container, false);

        img_camara = (ImageView) view.findViewById(R.id.img_camara);
        btn_solicitudes = (Button) view.findViewById(R.id.btn_solicitudes);


        return onCreateView(view);
    }

    @Override
    public void onUpdateView() {

        img_camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.showAlert(context, "¡Camara no disponible por permisos!");
            }
        });

        btn_solicitudes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SolicitudesFragment fragment = new SolicitudesFragment();
                fragment.position = 2;
                context.addFragment(fragment);
            }
        });

    }

}
