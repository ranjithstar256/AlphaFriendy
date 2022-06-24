package kpr.am.friendy;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseActivity extends AppCompatActivity {
    Button b1,b2;
    SharedPreferences sharedPreferences;

    SharedPreferences.Editor editor;
    String frdnumr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        b1 = findViewById(R.id.button5);
        b2 = findViewById(R.id.button6);
        sharedPreferences = getSharedPreferences("sfname", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // do validation
               custdia();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Intent intent = new Intent(ChooseActivity.this,MainActivity12.class);
              //  startActivity(intent);
            }
        });
    }

    public String custdia() {
// Create custom dialog object
        final Dialog dialog = new Dialog(ChooseActivity.this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.setTitle("Friend Mobile Number");

        EditText text = dialog.findViewById(R.id.editTextNumber);

        dialog.show();
        Button crereqbtn = dialog.findViewById(R.id.createreqbtn);
        crereqbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frdnumr= text.getText().toString();
                editor.putString("frdmobnum",frdnumr).commit();

                Toast.makeText(ChooseActivity.this, "Friend number received "+frdnumr, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ChooseActivity.this, MainActivity8.class);
                startActivity(intent);
            }
        });

        return frdnumr;
    }
}