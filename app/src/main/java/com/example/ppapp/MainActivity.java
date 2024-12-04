package com.example.ppapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private EditText editText;
    private Button addButton;
    private ListView listView;

    private ArrayList<String> taskList;

    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edittext);
        addButton = findViewById(R.id.addButton);
        listView = findViewById(R.id.listView);

        taskList = new ArrayList<>();

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                taskList
        );

        listView.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTask();
            }
        });
    }

    private void addTask() {
        String taskText = editText.getText().toString().trim();

        if (!taskText.isEmpty()) {
            taskList.add(taskText);

            adapter.notifyDataSetChanged();

            editText.setText("");

            Toast.makeText(this, "Uzdevums pievineots", Toast.LENGTH_SHORT).show();
        }
    }
}