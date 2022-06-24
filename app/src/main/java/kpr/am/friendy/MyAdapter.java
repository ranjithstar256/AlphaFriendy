package kpr.am.friendy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Oclemy on 11/5/2016 for ProgrammingWizards Channel and http://www.camposha.info.
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    /*
    INSTANCE FIELDS
     */
    private Context c;
    private ArrayList<QuestionBank> spacecrafts;

    /*
    CONSTRUCTOR
     */
    public MyAdapter(Context c, ArrayList<QuestionBank> spacecrafts) {
        this.c = c;
        this.spacecrafts = spacecrafts;
    }

    /*
    INITIALIZE VIEWHOLDER
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        return new MyViewHolder(v);
    }

    /*
    BIND DATA
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        QuestionBank s=spacecrafts.get(position);

        holder.txtName.setText(s.ques);
       // holder.txtPropellant.setText(s.createdby);
       // holder.txtPropellant.setText(s.createdon);
        holder.txtPropellant.setText(s.cate);
        holder.chkTechExists.setChecked(false);
    }

    /*
    TOTAL NUM OF SPACECRAFTS
     */
    @Override
    public int getItemCount() {
        return spacecrafts.size();
    }
}
