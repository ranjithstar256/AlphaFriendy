package kpr.am.friendy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {


    public static ArrayList<QuestionBank> name;
    Context context;

    public CustomAdapter(Context context, ArrayList<QuestionBank> name) {

        this.name = name;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rv_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        // holder.checkBox.setText("Checkbox " + position);
        holder.checkBox.setChecked(name.get(position).getSelected());
        holder.tvQues.setText(name.get(position).getQues());

        // holder.checkBox.setTag(R.integer.btnplusview, convertView);
        holder.checkBox.setTag(position);
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer pos = (Integer) holder.checkBox.getTag();
                Toast.makeText(context, name.get(pos).getQues() + " clicked!", Toast.LENGTH_SHORT).show();

                if (name.get(pos).getSelected()) {
                    name.get(pos).setSelected(false);
                } else {
                    name.get(pos).setSelected(true);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        protected CheckBox checkBox;
        private TextView tvQues;

        public MyViewHolder(View itemView) {
            super(itemView);

            checkBox = itemView.findViewById(R.id.cb);
            tvQues =  itemView.findViewById(R.id.Ques);
        }

    }
}
