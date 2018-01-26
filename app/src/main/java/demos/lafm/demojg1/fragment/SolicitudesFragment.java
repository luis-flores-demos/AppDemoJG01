package demos.lafm.demojg1.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import demos.lafm.demojg1.R;
import demos.lafm.demojg1.activity.MainActivity;
import demos.lafm.demojg1.adapter.SolicitudesAdapter;
import demos.lafm.demojg1.custom.LFragment;
import demos.lafm.demojg1.custom.LFragmentAdapter;
import demos.lafm.demojg1.custom.Utils;
import demos.lafm.demojg1.model.Solicitud;
import me.relex.circleindicator.CircleIndicator;

/**
 * A simple {@link Fragment} subclass.
 */
public class SolicitudesFragment extends LFragment {

    private MainActivity context;
    private View view;
    private ArrayList<Solicitud> solicitudes = new ArrayList<>();
    private RecyclerView list;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;
    private Button btn_nueva_solicitud;


    public SolicitudesFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = (MainActivity) getActivity();
        view = inflater.inflate(R.layout.layout_solicitudes, container, false);
        btn_nueva_solicitud = (Button) view.findViewById(R.id.btn_nueva_solicitud);

        return onCreateView(view);
    }

    @Override
    public void onUpdateView() {

        solicitudes = new ArrayList<>();

        solicitudes.add(new Solicitud(1));
        solicitudes.add(new Solicitud(2));
        solicitudes.add(new Solicitud(3));
        solicitudes.add(new Solicitud(4));
        solicitudes.add(new Solicitud(4));

        list = (RecyclerView) view.findViewById(R.id.list);
        list.setHasFixedSize(true);
        manager = new LinearLayoutManager(context);
        list.setLayoutManager(manager);

        adapter = new SolicitudesAdapter(solicitudes);
        list.setAdapter(adapter);

        btn_nueva_solicitud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequerimientoFragment fragment = new RequerimientoFragment();
                fragment.position = 5;
                context.addFragment(fragment);
            }
        });

    }

}
