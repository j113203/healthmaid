package j113203.github.com.virtualconsultant.Activity;

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

        activity_splash = findViewById(R.id.activity_splash);
        header = findViewById(R.id.header);
        footer = findViewById(R.id.footer);
        logo = findViewById(R.id.logo);

        Executors.newSingleThreadScheduledExecutor().schedule(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(_Splash.this, _Menu.class));
                finish();
            }
        }, 3, TimeUnit.SECONDS);

    }

    protected void anim_larger_w() {

        float from = logo.getMeasuredWidth();
        float to = from * 3;

        ValueAnimator anim = ValueAnimator.ofFloat(from, to);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {

                int val = (int) (float) valueAnimator.getAnimatedValue();

                ViewGroup.LayoutParams layoutParams = logo.getLayoutParams();
                layoutParams.width = val;
                logo.setLayoutParams(layoutParams);

            }
        });
        anim.setDuration(1000).start();

    }

    protected void anim_larger_h() {

        float from = logo.getMeasuredHeight();
        float to = from * 3;

        ValueAnimator anim = ValueAnimator.ofFloat(from, to);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {

                int val = (int) (float) valueAnimator.getAnimatedValue();

                ViewGroup.LayoutParams layoutParams = logo.getLayoutParams();
                layoutParams.height = val;
                logo.setLayoutParams(layoutParams);

            }
        });
        anim.setDuration(2000).start();

    }

    protected void anim_fadeIn() {

        ObjectAnimator anim = ObjectAnimator.ofObject(activity_splash, "backgroundColor", new ArgbEvaluator(), Color.parseColor("#ffffff"), Color.parseColor("#4dafad"));

        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                header.setVisibility(View.VISIBLE);
                footer.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        anim.setDuration(2000).start();
    }

    @Override
    public void onBackPressed() {

    }

    private RelativeLayout activity_splash;
    private ImageView header;
    private ImageView footer;
    private ImageView logo;


}
