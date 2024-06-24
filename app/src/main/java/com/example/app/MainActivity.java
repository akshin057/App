package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText nameET;
    EditText surnameET;
    EditText addressET;
    EditText phoneET;
    Button saveBTN;

    ListView users;
    List<User> list = new ArrayList<>();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        saveBTN.setOnClickListener(v -> {
            User user = new User(nameET.getText().toString(), surnameET.getText().toString(),
                    addressET.getText().toString(), phoneET.getText().toString());
            list.add(user);
            adapter.notifyDataSetChanged();

            nameET.getText().clear();
            surnameET.getText().clear();
            addressET.getText().clear();
            phoneET.getText().clear();
        });

        users.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            User user = (User) adapter.getItem(position);
            intent.putExtra("user", user);
            startActivity(intent);
            finish();
        });

    }


    private void initUI() {
        nameET = findViewById(R.id.nameET);
        surnameET = findViewById(R.id.surnameET);
        addressET = findViewById(R.id.addressET);
        phoneET = findViewById(R.id.phoneET);
        saveBTN = findViewById(R.id.saveBTN);
        users = findViewById(R.id.usersLV);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        users.setAdapter(adapter);
    }
}