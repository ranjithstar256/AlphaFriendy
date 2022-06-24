package kpr.am.friendy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity12 extends AppCompatActivity {

    Button b2,b3,b4,b5,b6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);

        b2 = findViewById(R.id.iq);
        b3 = findViewById(R.id.dq);
        b4 = findViewById(R.id.cs);
        b5 = findViewById(R.id.crq);
        b6 = findViewById(R.id.lq);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent3 = new Intent(MainActivity12.this, MainActivity13.class);
                startActivity(intent3);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent4 = new Intent(MainActivity12.this, MainActivity13.class);
                startActivity(intent4);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent5 = new Intent(MainActivity12.this, MainActivity13.class);
                startActivity(intent5);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent6 = new Intent(MainActivity12.this, MainActivity13.class);
                startActivity(intent6);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent7 = new Intent(MainActivity12.this, MainActivity13.class);
                startActivity(intent7);
            }
        });
    }
}