package kpr.am.friendy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity14 extends AppCompatActivity {
    Button b1;
    private RecyclerView rv;

    ArrayList<FriendAnswerViewAdapter> quesarrlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.answer_view);
        b1 = findViewById(R.id.gq);
        rv = findViewById(R.id.recy);
        rv.setLayoutManager(new LinearLayoutManager(MainActivity14.this));

        quesarrlist = new ArrayList<>();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity14.this, MainActivity11.class);
                startActivity(intent);
            }
        });
    }
}