package kpr.am.friendy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity13 extends AppCompatActivity {
    Button b1;
    private RecyclerView rv;
    private FirebaseFirestore db;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private String Phone, PassFire;
    ArrayList<QuestionBank> quesarrlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recylayout);
        //   b1 = findViewById(R.id.n);
        rv = findViewById(R.id.recy);

        ///   this.handleClickEvents();
        Long date = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd / MMMM / yyyy - hh:mm", Locale.getDefault());
        String dateStr = dateFormat.format(date);
        Log.i("asfsgrh", "onCreate: " + dateStr);

        db = FirebaseFirestore.getInstance();
        sharedPreferences = getSharedPreferences("sfname", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        Phone = sharedPreferences.getString("mobnum", "8148580586");
        quesarrlist = new ArrayList<>();
        rv.setLayoutManager(new LinearLayoutManager(MainActivity13.this));
        CollectionReference questionRef = db.collection("kpr.am.friendy.Questions");
        questionRef.whereEqualTo("createdby", Phone).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                Log.i("asddTAG", "onSuccess: \n" + queryDocumentSnapshots.getDocuments().size() + "--\n");

                for (int j = 0; j < queryDocumentSnapshots.getDocuments().size(); j++) {
                    QuestionBank qs = new QuestionBank(
                            queryDocumentSnapshots.getDocuments().get(j).get("ques").toString(),
                            queryDocumentSnapshots.getDocuments().get(j).get("createdon").toString(),
                            queryDocumentSnapshots.getDocuments().get(j).get("createdby").toString(),
                            queryDocumentSnapshots.getDocuments().get(j).get("cate").toString(),queryDocumentSnapshots.getDocuments().get(j).get("cate").toString(),"","");

                    Log.i("asddTAG", "onSuccess: \n" + queryDocumentSnapshots.getDocuments().get(j).get("ques").toString() + "--\n");

                    quesarrlist.add(qs);
                }
                rv.setAdapter(new CustomAdapter(MainActivity13.this, quesarrlist));
            }
        });
       /* b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity13.this,MainActivity14.class);
                startActivity(intent);
            }
        });*/
    }

    public void sb(View view) {

       /* //GET VALUES
        String name = "";                   //txtName.getText().toString();
        String propellant = "";             //rv..getSelectedItem().toString();
        Boolean technologyexists = true;    //chkTechnologyExists.isChecked();

        //BASIC CLIENT SIDE VALIDATION
        if ((name.length() < 1 || propellant.length() < 1)) {
            Toast.makeText(MainActivity13.this, "Please Enter all Fields",
                    Toast.LENGTH_SHORT).show();
        } else {
            //SAVE

            QuestionBank s = new QuestionBank("name", "propellant", "9900", "");
            ArrayList<QuestionBank> qab = new ArrayList<>();
            qab.add(s);
            new CustomAdapter(MainActivity13.this, qab);
        }*/
        startActivity(new Intent(MainActivity13.this,NextActivity.class));
    }
}