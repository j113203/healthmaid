package j113203.github.com.virtualconsultant.Activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import j113203.github.com.virtualconsultant.Adapter.Adapter_Organs;
import j113203.github.com.virtualconsultant.Adapter.Adapter_Symptoms;
import j113203.github.com.virtualconsultant.Model.Model_Organs;
import j113203.github.com.virtualconsultant.Model.Model_Symptoms;
import j113203.github.com.virtualconsultant.Pojo.Pojo_Symptoms;
import j113203.github.com.virtualconsultant.R;

/**
 * Created by j113203 on 28/12/2017.
 */

public class _Menu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);

        activity_menu = findViewById(R.id.activity_menu);
        organsList = findViewById(R.id.organsList);
        SymptomsList = findViewById(R.id.SymptomsList);
        next = findViewById(R.id.next);

        Adapter_Organs adapter_organs_right = new Adapter_Organs(_Menu.this, new Model_Organs[]{
                new Model_Organs(R.drawable.organs_1) {{
                    setId(1);
                }},
                new Model_Organs(R.drawable.organs_2) {{
                    setId(2);
                }},
                new Model_Organs(R.drawable.organs_3) {{
                    setId(3);
                }},
                new Model_Organs(R.drawable.organs_4) {{
                    setId(4);
                }},
                new Model_Organs(R.drawable.organs_5) {{
                    setId(5);
                }},
                new Model_Organs(R.drawable.organs_6) {{
                    setId(6);
                }},
                new Model_Organs(R.drawable.organs_7) {{
                    setId(7);
                }},
                new Model_Organs(R.drawable.organs_8) {{
                    setId(8);
                }},
                new Model_Organs(R.drawable.organs_9) {{
                    setId(9);
                }},
                new Model_Organs(R.drawable.organs_10) {{
                    setId(10);
                }},
                new Model_Organs(R.drawable.organs_11) {{
                    setId(11);
                }},
                new Model_Organs(R.drawable.organs_12) {{
                    setId(12);
                }},
                new Model_Organs(R.drawable.organs_13) {{
                    setId(13);
                }},
                new Model_Organs(R.drawable.organs_14) {{
                    setId(14);
                }}
        });

        organsList.setDividerHeight(0);
        organsList.setVerticalFadingEdgeEnabled(false);
        organsList.setFooterDividersEnabled(false);
        organsList.setHeaderDividersEnabled(false);
        organsList.setFastScrollEnabled(true);
        organsList.setVerticalScrollBarEnabled(false);
        organsList.setAdapter(adapter_organs_right);

        readSymptomsDB();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                _Splash.anim_reverse(activity_menu, new Runnable() {
                    @Override
                    public void run() {
                        activity_menu.setVisibility(View.GONE);
                        startActivity(new Intent(_Menu.this, _Result.class));
                        finish();
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }
                });

            }
        });

        _Splash.anim(activity_menu, null);

    }

    private HashSet<Model_Symptoms> symptomsDB;

    private void readSymptomsDB() {
        StringBuilder content = new StringBuilder();
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.symptom);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String str;
            while (true) {
                str = reader.readLine();
                if (str != null) {
                    content.append(str);
                } else {
                    break;
                }
            }
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Pojo_Symptoms result = new Gson().fromJson(content.toString(), Pojo_Symptoms.class);
        symptomsDB = new HashSet<>();
        for (String value : result.getResult()) {
            symptomsDB.add(new Model_Symptoms(value));
        }
        buildSymptomsList();

    }

    private void buildSymptomsList() {
        Adapter_Symptoms adapter_symptoms = new Adapter_Symptoms(_Menu.this, symptomsDB.toArray(new Model_Symptoms[symptomsDB.size()]));
        SymptomsList.setDividerHeight(0);
        SymptomsList.setVerticalFadingEdgeEnabled(false);
        SymptomsList.setFooterDividersEnabled(false);
        SymptomsList.setHeaderDividersEnabled(false);
        SymptomsList.setFastScrollEnabled(true);
        SymptomsList.setVerticalScrollBarEnabled(false);
        SymptomsList.setAdapter(adapter_symptoms);
    }

    private ListView organsList;
    private ListView SymptomsList;

    private RelativeLayout activity_menu;
    private FloatingActionButton next;


}
