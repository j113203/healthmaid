package j113203.github.com.virtualconsultant.Activity.v2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import j113203.github.com.virtualconsultant.Adapter.Adapter_Organs;
import j113203.github.com.virtualconsultant.Model.Model_Organs;
import j113203.github.com.virtualconsultant.R;

/**
 * Created by j113203 on 28/12/2017.
 */

public class _Menu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);

        organsList = findViewById(R.id.organsList);

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

    }

    private ListView organsList;

}
