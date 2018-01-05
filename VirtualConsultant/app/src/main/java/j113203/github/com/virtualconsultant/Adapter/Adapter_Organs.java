package j113203.github.com.virtualconsultant.Adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import j113203.github.com.virtualconsultant.Activity._Menu;
import j113203.github.com.virtualconsultant.Model.Model_Organs;
import j113203.github.com.virtualconsultant.R;

/**
 * Created by j113203 on 27/12/2017.
 */

public class Adapter_Organs extends BaseAdapter {

    private Model_Organs[] model_organs;
    private _Menu context;

    public Adapter_Organs(_Menu context, Model_Organs[] model_organs) {
        this.context = context;
        this.model_organs = model_organs;
    }

    @Override
    public int getCount() {
        if (model_organs != null) {
            return model_organs.length;
        }
        return 0;
    }

    @Override
    public Model_Organs getItem(int i) {
        return model_organs[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.adapter_organs, viewGroup, false);
        }

        final Model_Organs model = getItem(i);

        final ImageView organ = view.findViewById(R.id.organ);
        organ.setImageResource(model.getImage());
        organ.setTag(false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Boolean clicked = (boolean) organ.getTag();
                if (!clicked) {
                    organ.setColorFilter(Color.parseColor("#F44336"));
                }else{
                    organ.clearColorFilter();
                }
                organ.setTag(!clicked);
            }
        });

        return view;
    }

}
