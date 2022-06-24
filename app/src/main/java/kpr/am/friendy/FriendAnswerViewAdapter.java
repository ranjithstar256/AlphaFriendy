package kpr.am.friendy;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

/**
 * Created by  Oclemy on 11/5/2016 for ProgrammingWizards Channel and http://www.camposha.info.
 */
public class FriendAnswerViewAdapter extends RecyclerView.Adapter<AnswerMyViewHolder> {

    private Context c;
    private ArrayList<QuestionBank> questionBanks;
    private FirebaseFirestore db;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private String Ques, Loc, Phone, Pass, Cpass, frdnum;

    public FriendAnswerViewAdapter(Context c, ArrayList<QuestionBank> questionBanks) {
        this.c = c;
        this.questionBanks = questionBanks;
    }

    @Override
    public AnswerMyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        db = FirebaseFirestore.getInstance();
        sharedPreferences = c.getSharedPreferences("sfname", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        Phone = sharedPreferences.getString("mobnum", "8148580586");
        frdnum = sharedPreferences.getString("frdmobnum", "9884268168");

        View v = LayoutInflater.from(c).inflate(R.layout.item_answerview, parent, false);
        return new AnswerMyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AnswerMyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        QuestionBank s = questionBanks.get(position);

        holder.txtQues.setText(s.ques);
        holder.savbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ans = holder.edans.getText().toString();
                Toast.makeText(c, "" + ans + position, Toast.LENGTH_SHORT).show();
                addDataToFirestore(questionBanks.get(position).getQues(), Phone, "23423422", "funny", ans, position, holder.savbtn, frdnum);
            }
        });

    }

    private void addDataToFirestore(String ques, String phone, String s, String funny, String ans, int po, Button savbtn, String frdnum) {

        CollectionReference dbCourses = db.collection("kpr.am.friendy.Answers.Requests."+frdnum);

        QuestionBank questionBank = new QuestionBank(ques, phone, s, funny, ans, frdnum,"");

        //dbCourses.document(""+frdnum).collection("").add(questionBank).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
        dbCourses.add(questionBank).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d("123abc", "DocumentSnapshot added with ID: " + documentReference.getId());
                savbtn.setText("Saved!");
                savbtn.setEnabled(false);
                Toast.makeText(c, "question Added", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w("123abc", "Error adding document", e);
                Toast.makeText(c, "Not added \n" + e, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return questionBanks.size();
    }
}