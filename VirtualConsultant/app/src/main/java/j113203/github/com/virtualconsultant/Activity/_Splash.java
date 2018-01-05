package j113203.github.com.virtualconsultant.Activity;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import io.codetail.animation.ViewAnimationUtils;
import j113203.github.com.virtualconsultant.R;

/**
 * Created by j113203 on 28/12/2017.
 */

public class _Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        activity_splash = findViewById(R.id.activity_splash);

        anim(activity_splash, new Runnable() {
            @Override
            public void run() {

                Executors.newSingleThreadScheduledExecutor().schedule(new Runnable() {

                    @Override
                    public void run() {
                        anim_reverse(activity_splash, new Runnable() {
                            @Override
                            public void run() {
                                activity_splash.setVisibility(View.GONE);
                                startActivity(new Intent(_Splash.this, _Menu.class));
                                finish();
                                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                            }
                        });
                    }

                }, 1, TimeUnit.SECONDS);

            }
        });
    }

    @Override
    public void onBackPressed() {

    }

    public static void anim(View view, int centerX, int centerY, float startRadius, float endRadius, final Runnable runnable) {

        Animator animator = ViewAnimationUtils.createCircularReveal(view, centerX, centerY, startRadius, endRadius);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.setDuration(1000);
        animator.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation, boolean isReverse) {

            }

            @Override
            public void onAnimationEnd(Animator animation, boolean isReverse) {

            }

            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                if (runnable != null) {
                    runnable.run();
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animator.start();

    }

    public static void anim(final View view, final Runnable runnable) {

        view.post(new Runnable() {
            @Override
            public void run() {
                final int cx = (view.getLeft() + view.getRight()) / 2;
                final int cy = (view.getTop() + view.getBottom()) / 2;

                // get the final radius for the clipping circle
                final int dx = Math.max(cx, view.getWidth() - cx);
                final int dy = Math.max(cy, view.getHeight() - cy);
                final float finalRadius = (float) Math.hypot(dx, dy);

                // Android native animator
                anim(view, cx, cy, 0, finalRadius, runnable);
            }
        });

    }

    public static void anim_reverse(final View view, final Runnable runnable) {

        view.post(new Runnable() {

            @Override
            public void run() {
                final int cx = (view.getLeft() + view.getRight()) / 2;
                final int cy = (view.getTop() + view.getBottom()) / 2;

                // get the final radius for the clipping circle
                final int dx = Math.max(cx, view.getWidth() - cx);
                final int dy = Math.max(cy, view.getHeight() - cy);
                final float finalRadius = (float) Math.hypot(dx, dy);

                // Android native animator
                anim(view, cx, cy, finalRadius, 0, runnable);

            }
        });

    }

    private RelativeLayout activity_splash;

}
