package kpr.am.friendy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class WhoAskedMe extends AppCompatActivity {
    private FirebaseFirestore db;
    SharedPreferences sharedPreferences;
    TextView textView;

    SharedPreferences.Editor editor;
    String nums;
    private RecyclerView rv;
    ArrayList<QuestionBank> quesarrlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_who_asked_me);
        db = FirebaseFirestore.getInstance();
        textView=findViewById(R.id.textView16);
        sharedPreferences = getSharedPreferences("sfname", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        nums="";
        rv = findViewById(R.id.recy);
        quesarrlist = new ArrayList<>();
        rv.setLayoutManager(new LinearLayoutManager(WhoAskedMe.this));

        CollectionReference questionRef = db.collection("kpr.am.friendy.Answers.Requests");
      //  questionRef.whereEqualTo("frdnum", sharedPreferences.getString("mobnum","8148580586")).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
        questionRef.whereEqualTo("frdnum", "8098885478").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {


                for (int j = 0; j < queryDocumentSnapshots.getDocuments().size(); j++) {
                    nums= nums+"\n"+ queryDocumentSnapshots.getDocuments().get(j).get("createdby").toString();

                    QuestionBank qs = new QuestionBank(
                            queryDocumentSnapshots.getDocuments().get(j).get("ques").toString(),
                            queryDocumentSnapshots.getDocuments().get(j).get("createdon").toString(),
                            queryDocumentSnapshots.getDocuments().get(j).get("createdby").toString(),
                            queryDocumentSnapshots.getDocuments().get(j).get("cate").toString(),queryDocumentSnapshots.getDocuments().get(j).get("cate").toString(),"","");

                    Log.i("asddTAG", "onSuccess: \n" + queryDocumentSnapshots.getDocuments().get(j).get("ques").toString() + "--\n");

                    quesarrlist.add(qs);
                }
                rv.setAdapter(new FriendCustomAdapter(WhoAskedMe.this, quesarrlist));

                textView.setText(nums);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(WhoAskedMe.this,FriendNextActivity.class));

                    }
                });
                }
        });

    }


}