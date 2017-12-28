package j113203.github.com.virtualconsultant.Activity.v1;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import j113203.github.com.virtualconsultant.R;

public class _Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);


        Executors.newSingleThreadScheduledExecutor().schedule(new Runnable() {
            @Override
            public void run() {
                //startActivity(new Intent(_Splash.this, _Menu.class));
                //finish();
            }
        }, 1, TimeUnit.SECONDS);

    }

    @Override
    public void onBackPressed() {

    }

    private RelativeLayout activity_splash;
    private ImageView header;
    private ImageView footer;
    private ImageView logo;


}
