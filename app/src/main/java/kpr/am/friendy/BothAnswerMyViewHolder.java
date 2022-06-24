package kpr.am.friendy;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class BothAnswerMyViewHolder extends RecyclerView.ViewHolder {


    TextView txtQues,txtMyAns,txtFrdAns;


    public BothAnswerMyViewHolder(View view) {
        super(view);

        txtQues = (TextView) view.findViewById(R.id.textView17);
        txtMyAns = (TextView) view.findViewById(R.id.textView18);
        txtFrdAns = (TextView) view.findViewById(R.id.textView19);

    }
}