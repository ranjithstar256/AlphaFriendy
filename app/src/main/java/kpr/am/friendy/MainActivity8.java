package kpr.am.friendy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity8 extends AppCompatActivity {
    Button b1;
    private EditText edques;
    private FirebaseFirestore db;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private String Ques, Phone;
    TextView quesnumtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        b1 = findViewById(R.id.button7);
        edques = findViewById(R.id.editTextTextPersonName);
        quesnumtv = findViewById(R.id.textView4);
        db = FirebaseFirestore.getInstance();

        sharedPreferences = getSharedPreferences("sfname", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        Phone = sharedPreferences.getString("mobnum", "8148580586");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ques = edques.getText().toString();

                Map<String, Object> userdata = new HashMap<>();
                userdata.put("myanswer", "Ada");
                userdata.put("myquestion", Ques);
                userdata.put("category", "funny");
                userdata.put("frdanswer", "");
                userdata.put("frdnumber", "");
                userdata.put("creadtedby", Phone);
                userdata.put("createdon", "23423422");
                userdata.put("someboolean", "true");

             //   db.document().set(userdata);

                addDataToFirestore(Ques, Phone, "23423422", "funny");
            }
        });
    }

    private void addDataToFirestore(String ques, String phone, String datetime, String category) {
        CollectionReference dbCourses = db.collection("kpr.am.friendy.Questions");
        QuestionBank questionBank = new QuestionBank(ques, phone, datetime, category, "", "", "");
        dbCourses.add(questionBank).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d("123abc", "DocumentSnapshot added with ID: " + documentReference.getId());

                Toast.makeText(MainActivity8.this, "question Added", Toast.LENGTH_SHORT).show();

                for (int i = 1; i <6 ; i++) {
                    quesnumtv.setText("Question " + i + ":");
                    Intent intent = new Intent(MainActivity8.this, MainActivity8.class);
                    startActivity(intent);
                }

                Intent intent = new Intent(MainActivity8.this, MainActivity13.class);
                startActivity(intent);
            }

        }).addOnFailureListener(e -> {
            Log.w("123abc", "Error adding document", e);
          Toast.makeText(MainActivity8.this, "Not added \n" + e, Toast.LENGTH_SHORT).show();
        });
    }
}