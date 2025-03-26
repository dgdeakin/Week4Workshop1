package com.example.week4workshop1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button button1, button2;
    EditText userNameEditText;
    CheckBox checkBox;

    SharedPreferences mySharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        userNameEditText = findViewById(R.id.editTextText);
        checkBox = findViewById(R.id.checkBox);

        mySharedPreference = getSharedPreferences("MY_PREF", MODE_PRIVATE);
        String userName = mySharedPreference.getString("username", "");
        userNameEditText.setText(userName);


        button1.setOnClickListener(v -> {

            SharedPreferences.Editor editor = mySharedPreference.edit();

            if(checkBox.isChecked()){
                editor.putString("username", userNameEditText.getText().toString());
                editor.apply();
            }
            else {
                editor.putString("username", "");
                editor.apply();
            }

            Toast.makeText(this,userNameEditText.getText().toString(), Toast.LENGTH_LONG).show();
        });
    }
}