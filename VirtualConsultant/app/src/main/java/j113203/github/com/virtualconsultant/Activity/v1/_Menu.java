package j113203.github.com.virtualconsultant.Activity.v1;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.ListView;

import j113203.github.com.virtualconsultant.Adapter.Adapter_Organs;
import j113203.github.com.virtualconsultant.Model.Model_Organs;
import j113203.github.com.virtualconsultant.R;

public class _Menu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        organsLeft = findViewById(R.id.organsLeft);
        organsRight = findViewById(R.id.organsRight);

        Adapter_Organs adapter_organs_left = new Adapter_Organs(_Menu.this, new Model_Organs[]{
                new Model_Organs(R.drawable.organs_1) {{
                    setId(0x0001);
                }},
                new Model_Organs(R.drawable.organs_2) {{
                    setId(0x0002);
                }},
                new Model_Organs(R.drawable.organs_3) {{
                    setId(0x0003);
                }},
                new Model_Organs(R.drawable.organs_4) {{
                    setId(0x0004);
                }},
                new Model_Organs(R.drawable.organs_5) {{
                    setId(0x0005);
                }},
                new Model_Organs(R.drawable.organs_6) {{
                    setId(0x0006);
                }},
                new Model_Organs(R.drawable.organs_7) {{
                    setId(0x0007);
                }}
        });

        organsLeft.setDividerHeight(0);
        organsLeft.setVerticalFadingEdgeEnabled(false);
        organsLeft.setAdapter(adapter_organs_left);

        Adapter_Organs adapter_organs_right = new Adapter_Organs(_Menu.this, new Model_Organs[]{
                new Model_Organs(R.drawable.organs_8) {{
                    setId(0x0008);
                }},
                new Model_Organs(R.drawable.organs_9) {{
                    setId(0x0009);
                }},
                new Model_Organs(R.drawable.organs_10) {{
                    setId(0x0010);
                }},
                new Model_Organs(R.drawable.organs_11) {{
                    setId(0x0011);
                }},
                new Model_Organs(R.drawable.organs_12) {{
                    setId(0x0012);
                }},
                new Model_Organs(R.drawable.organs_13) {{
                    setId(0x0013);
                }},
                new Model_Organs(R.drawable.organs_14) {{
                    setId(0x0014);
                }}
        });

        organsRight.setDividerHeight(0);
        organsRight.setVerticalFadingEdgeEnabled(false);
        organsRight.setAdapter(adapter_organs_right);


    }

    private ListView organsLeft;

    private ListView organsRight;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("item changed", "item id=" + requestCode);
    }
}
