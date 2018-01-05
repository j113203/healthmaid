package j113203.github.com.virtualconsultant.Adapter;

import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import j113203.github.com.virtualconsultant.Activity._Menu;
import j113203.github.com.virtualconsultant.Model.Model_Organs;
import j113203.github.com.virtualconsultant.Model.Model_Symptoms;
import j113203.github.com.virtualconsultant.R;

/**
 * Created by j113203 on 29/12/2017.
 */

public class Adapter_Symptoms extends BaseAdapter {

    private Model_Symptoms[] model_symptoms;
    private _Menu context;

    public Adapter_Symptoms(_Menu context, Model_Symptoms[] model_symptoms) {
        this.model_symptoms = model_symptoms;
        this.context = context;
    }

    @Override
    public int getCount() {
        if (model_symptoms != null) {
            return model_symptoms.length;
        }
        return 0;
    }

    @Override
    public Model_Symptoms getItem(int position) {
        return model_symptoms[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_symptoms, parent, false);
        }
        final Model_Symptoms model = getItem(position);

        final RelativeLayout layout = convertView.findViewById(R.id.layout);
        layout.setTag(false);

        final TextView name = convertView.findViewById(R.id.name);

        name.setText(model.getName());

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean clicked = (boolean) layout.getTag();
                if (!clicked) {
                    layout.setBackgroundColor(ContextCompat.getColor(context, android.R.color.white));
                }else{
                    layout.setBackground(null);
                }
                layout.setTag(!clicked);
            }
        });

        return convertView;
    }

}
