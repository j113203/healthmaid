package j113203.github.com.virtualconsultant.Autocomplete;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.otaliastudios.autocomplete.RecyclerViewPresenter;

import java.util.ArrayList;
import java.util.List;

import j113203.github.com.virtualconsultant.Model.Model_Symptoms;
import j113203.github.com.virtualconsultant.R;

/**
 * Created by j113203 on 28/12/2017.
 */

public class Presenter_Input extends RecyclerViewPresenter<Model_Symptoms> {

    public Presenter_Input(Context context) {
        super(context);
    }

    @Override
    protected PopupDimensions getPopupDimensions() {
        PopupDimensions dims = new PopupDimensions();
        dims.width = 600;
        dims.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        return dims;
    }

    protected Adapter adapter;

    @Override
    protected RecyclerView.Adapter instantiateAdapter() {
        adapter = new Adapter();
        return adapter;
    }

    @Override
    protected void onQuery(@Nullable CharSequence query) {
        List<Model_Symptoms> db = Model_Symptoms.db;
        if (TextUtils.isEmpty(query)) {
            adapter.setData(db);
        } else {
            query = query.toString().toLowerCase();
            List<Model_Symptoms> list = new ArrayList<>();
            for (Model_Symptoms u : db) {
                if (u.getChiName().toLowerCase().contains(query) ||
                        u.getEngName().toLowerCase().contains(query)) {
                    list.add(u);
                }
            }
            adapter.setData(list);
        }
        adapter.notifyDataSetChanged();
    }

    class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

        private List<Model_Symptoms> data;

        public class Holder extends RecyclerView.ViewHolder {
            private View root;
            private TextView fullname;
            private TextView username;
            public Holder(View itemView) {
                super(itemView);
                root = itemView;
                fullname = itemView.findViewById(R.id.fullname);
                username = itemView.findViewById(R.id.username);

            }
        }

        public void setData(List<Model_Symptoms> data) {
            this.data = data;
        }

        @Override
        public int getItemCount() {
            return (isEmpty()) ? 1 : data.size();
        }

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new Holder(LayoutInflater.from(getContext()).inflate(R.layout.input_result, parent, false));
        }

        private boolean isEmpty() {
            return data == null || data.isEmpty();
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
            if (isEmpty()) {
                holder.fullname.setText("No such found!");
                holder.username.setText("Sorry!");
                holder.root.setOnClickListener(null);
                return;
            }
            final Model_Symptoms user = data.get(position);
            holder.fullname.setText(user.getChiName());
            holder.username.setText(user.getEngName());
            holder.root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dispatchClick(user);
                }
            });
        }
    }
}
