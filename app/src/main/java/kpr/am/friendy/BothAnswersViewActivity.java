package kpr.am.friendy;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;

public class BothAnswersViewActivity extends AppCompatActivity {
    RecyclerView rv;
    FirebaseFirestore db;
    SharedPreferences sharedPreferences;
    String Phone,frdnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_both_answers_view);
        rv = findViewById(R.id.recy);
        rv.setLayoutManager(new LinearLayoutManager(BothAnswersViewActivity.this));
        db = FirebaseFirestore.getInstance();
        sharedPreferences = getSharedPreferences("sfname", MODE_PRIVATE);
        Phone = sharedPreferences.getString("mobnum", "8148580586");
        frdnum = sharedPreferences.getString("frdmobnum", "9884268168");
        QuestionBank qs = new QuestionBank("who","81","32555","fun","me","98","nav");


    /*    CollectionReference cities = db.collection("cities");

        Map<String, Object> data1 = new HashMap<>();
        data1.put("name", "San Francisco");
        data1.put("state", "CA");
        data1.put("country", "USA");
        data1.put("capital", false);
        data1.put("population", 860000);
        data1.put("regions", Arrays.asList("west_coast", "norcal"));
        cities.document("SF").set(data1);
     */   db.collection("cities").document("SF")
                .update("name", "Ranjith");
     /*   db.collection("aiamdad").document()
                //.document("iamson")
                .collection("grand").add(qs).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {

                    }
                });

        db.collection("aiamdad").document("good")
                .update("cc", "13");*/
    }

    public void subreq(View view) {

    }
}