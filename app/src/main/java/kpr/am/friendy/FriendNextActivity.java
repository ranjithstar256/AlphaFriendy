package kpr.am.friendy;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;


public class FriendNextActivity extends AppCompatActivity {

   // private TextView textView;
    private RecyclerView rv;
    FriendAnswerViewAdapter answerViewAdapter;

    ArrayList<QuestionBank> quesarrlist;

    private FirebaseFirestore db;
    String ques; String createdby; String createdon; String cate;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private String Ques, Loc, Phone, Pass, Cpass,frdnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.answer_view);
        rv = findViewById(R.id.recy);
        db = FirebaseFirestore.getInstance();

        sharedPreferences = getSharedPreferences("sfname", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        Phone = sharedPreferences.getString("mobnum", "8148580586");
        frdnum = sharedPreferences.getString("frdmobnum", "9884268168");

        rv.setLayoutManager(new LinearLayoutManager(FriendNextActivity.this));

        quesarrlist = new ArrayList<>();

        for (int i = 0; i < FriendCustomAdapter.name.size(); i++){
           // if(CustomAdapter.name.get(i).getSelected()) {
                QuestionBank qq = new QuestionBank(FriendCustomAdapter.name.get(i).getQues(),Phone,"","","","","");
                quesarrlist.add(qq);
          //  }
        }
        answerViewAdapter= new FriendAnswerViewAdapter(this,quesarrlist);
        rv.setAdapter(answerViewAdapter);
    }

    public void subreq(View view) {

    }
}