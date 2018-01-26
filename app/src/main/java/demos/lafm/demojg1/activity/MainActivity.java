package demos.lafm.demojg1.activity;

import android.content.pm.ActivityInfo;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import demos.lafm.demojg1.R;
import demos.lafm.demojg1.custom.LFragment;
import demos.lafm.demojg1.custom.LFragmentAdapter;
import demos.lafm.demojg1.custom.LNonSwipeableViewPager;
import demos.lafm.demojg1.fragment.IformacionFragment;
import demos.lafm.demojg1.fragment.InicioFragment;
import demos.lafm.demojg1.fragment.SesionFragment;
import demos.lafm.demojg1.fragment.SolicitudesFragment;
import demos.lafm.demojg1.fragment.UsuarioFragment;

public class MainActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private LNonSwipeableViewPager pager;
    private List<LFragment> fragments = new ArrayList<>();
    private LFragmentAdapter adapter;

    private TextView txt_title;
    private LinearLayout content_menu;

    private ImageView btn_inicio;
    private ImageView btn_solicitudes;
    private ImageView btn_informacion;
    private ImageView btn_usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        txt_title = (TextView) findViewById(R.id.txt_title);
        content_menu = (LinearLayout) findViewById(R.id.content_menu);
        pager = (LNonSwipeableViewPager) findViewById(R.id.view_pager);

        btn_inicio = (ImageView) findViewById(R.id.btn_inicio);
        btn_solicitudes = (ImageView) findViewById(R.id.btn_solicitudes);
        btn_informacion = (ImageView) findViewById(R.id.btn_informacion);
        btn_usuario = (ImageView) findViewById(R.id.btn_usuario);

        adapter = new LFragmentAdapter(getSupportFragmentManager(), fragments);
        pager.setAdapter(adapter);
        initInicio(true);

        btn_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InicioFragment fragment = new InicioFragment();
                fragment.position = 1;
                addFragment(fragment);
            }
        });

        btn_solicitudes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SolicitudesFragment fragment = new SolicitudesFragment();
                fragment.position = 2;
                addFragment(fragment);
            }
        });

        btn_informacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IformacionFragment fragment = new IformacionFragment();
                fragment.position = 3;
                addFragment(fragment);
            }
        });

        btn_usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsuarioFragment fragment = new UsuarioFragment();
                fragment.position = 4;
                addFragment(fragment);
            }
        });


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
