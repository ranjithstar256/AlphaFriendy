package kpr.am.friendy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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

public class MainActivity4 extends AppCompatActivity {

    Button b3;
    CheckBox ck;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private EditText editTextName, editTextMail, editTextPass, editTextCompPass;
    private String Name, Loc, Phone,Pass,Cpass;
    TextView editTextPhone;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        db = FirebaseFirestore.getInstance();
        sharedPreferences = getSharedPreferences("sfname", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        // initializing our edittext and buttons
        editTextName = findViewById(R.id.editTextTextPersonName2);
        editTextMail = findViewById(R.id.editTextTextEmailAddress);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextPass = findViewById(R.id.editTextTextPassword2);
        editTextCompPass = findViewById(R.id.editTextTextPassword3);
        ck = findViewById(R.id.checkBox);

        editTextPhone.setText(getIntent().getStringExtra("num"));

       /* b3 = findViewById(R.id.button3);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
         }
        });*/
    }

    public void reg(View view) {
        // getting data from edittext fields.
        Name = editTextName.getText().toString();
        Loc = editTextMail.getText().toString();
        Phone = editTextPhone.getText().toString();
        Pass = editTextPass.getText().toString();
        Cpass = editTextCompPass.getText().toString();

        // validating the text fields if empty or not.
        if (TextUtils.isEmpty(Name)) {
            editTextName.setError("Please enter Name");
        } else if (TextUtils.isEmpty(Loc)) {
            editTextMail.setError("Please enter Location");
        } else if (TextUtils.isEmpty(Phone)) {
            editTextPhone.setError("Please enter valid number");
        } else if (!Pass.equals(Cpass)) {
            editTextCompPass.setError("Password doesn't match");
        } else if (!ck.isChecked()) {
            Toast.makeText(this, "Please agree to terms!", Toast.LENGTH_SHORT).show();
        } else {
            // calling method to add data to Firebase Firestore.
            addDataToFirestore(Name, Loc, Phone,Cpass);
        }
    }
    private void addDataToFirestore(String Name, String Loc, String Phone, String pass) {

        CollectionReference dbCourses = db.collection("kpr.am.friendy.Detail");
    Detail detail = new Detail(Name, Loc, Phone,pass);
      dbCourses.add(detail).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d("123abc", "DocumentSnapshot added with ID: " + documentReference.getId());
             Toast.makeText(MainActivity4.this, "Details Added", Toast.LENGTH_SHORT).show();
               // Intent intent= new Intent(MainActivity4.this,MainActivity6.class);
                Intent intent= new Intent(MainActivity4.this,ChooseActivity.class);
                editor.putString("mobnum",Phone).commit();
                intent.putExtra("num",Phone);
                startActivity(intent);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w("123abc", "Error adding document", e);
                // this method is called when the data addition process is failed.
                // displaying a toast message when data addition is failed.
                Toast.makeText(MainActivity4.this, "Not added \n" + e, Toast.LENGTH_SHORT).show();
            }
        });
    }

}