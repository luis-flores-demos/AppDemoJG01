package demos.lafm.demojg1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    // Duración en milisegundos que se mostrará el splash
    private final int DURACION_SPLASH = 2000; // 3 segundos

    private SplashActivity context = this;
    private ImageView icono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);

        icono = (ImageView) findViewById(R.id.icono);

        icono.startAnimation(AnimationUtils.loadAnimation(context, R.anim.android_rotate_animation));

        new Handler().postDelayed(new Runnable(){
            public void run(){
                startActivity(new Intent(context, MainActivity.class));
                finish();
            };
        }, DURACION_SPLASH);

    }
}