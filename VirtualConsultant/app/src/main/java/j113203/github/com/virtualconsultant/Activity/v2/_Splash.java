package j113203.github.com.virtualconsultant.Activity.v2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import j113203.github.com.virtualconsultant.R;

/**
 * Created by j113203 on 28/12/2017.
 */

public class _Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        Executors.newSingleThreadScheduledExecutor().schedule(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(_Splash.this, _Menu.class));
                finish();
            }
        }, 1, TimeUnit.SECONDS);

    }

    @Override
    public void onBackPressed() {

    }

}
