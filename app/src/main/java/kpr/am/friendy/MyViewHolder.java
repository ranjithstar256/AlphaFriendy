package kpr.am.friendy;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


/**
 * Created by Oclemy on 11/5/2016 for ProgrammingWizards Channel and http://www.camposha.info.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {


    TextView txtName,txtPropellant;
    CheckBox chkTechExists;
    public MyViewHolder(View view) {
        super(view);

         txtName = (TextView) view.findViewById(R.id.nameTxt);
         txtPropellant = (TextView) view.findViewById(R.id.txtPropellant);

         chkTechExists = (CheckBox) view.findViewById(R.id.chkTechExists);
    }
}
