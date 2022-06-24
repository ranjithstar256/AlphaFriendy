package kpr.am.friendy;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class AnswerMyViewHolder extends RecyclerView.ViewHolder {


    TextView txtQues;
    EditText edans;
    Button savbtn;

    public AnswerMyViewHolder(View view) {
        super(view);

        txtQues = (TextView) view.findViewById(R.id.textView15);
        edans = (EditText) view.findViewById(R.id.editTextTextPersonName12);

        savbtn = (Button) view.findViewById(R.id.button10);
    }
}