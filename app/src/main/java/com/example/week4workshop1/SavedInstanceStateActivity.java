package com.example.week4workshop1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SavedInstanceStateActivity extends AppCompatActivity {

    TextView counterTextView;
    Button increaseButton;

    int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_saved_instance_state);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if(savedInstanceState != null){
            counter = savedInstanceState.getInt("COUNTER_KEY");
        }
        counterTextView = findViewById(R.id.textViewCounter);
        increaseButton = findViewById(R.id.buttonCounter);
        counterTextView.setText("Count: " + counter);
        increaseButton.setOnClickListener(v -> {
            counter++;
            counterTextView.setText("Count: " + counter);
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("COUNTER_KEY", counter);
    }
}