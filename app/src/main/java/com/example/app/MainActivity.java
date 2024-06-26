package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    EditText nameET;
    EditText surnameET;
    EditText addressET;
    EditText phoneET;
    Button saveBTN;
    CountUsersViewModel countUsersViewModel;
    ListView users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        saveBTN.setOnClickListener(v -> {
            User user = new User(nameET.getText().toString(), surnameET.getText().toString(),
                    addressET.getText().toString(), phoneET.getText().toString());

            if (nameET.getText().toString().isEmpty() || surnameET.getText().toString().isEmpty()
            || addressET.getText().toString().isEmpty() || phoneET.getText().toString().isEmpty()){
                Snackbar.make(findViewById(R.id.main), "Данные пользователя не заполнены!!!", Snackbar.LENGTH_SHORT).show();
                return;
            }

            countUsersViewModel.add(user);
            countUsersViewModel.getAdapter().notifyDataSetChanged();
            nameET.getText().clear();
            surnameET.getText().clear();
            addressET.getText().clear();
            phoneET.getText().clear();
        });

        users.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            User user = (User) countUsersViewModel.getAdapter().getItem(position);
            intent.putExtra("user", user);
            startActivity(intent);
        });

    }

    private void initUI() {
        nameET = findViewById(R.id.nameET);
        surnameET = findViewById(R.id.surnameET);
        addressET = findViewById(R.id.addressET);
        phoneET = findViewById(R.id.phoneET);
        saveBTN = findViewById(R.id.saveBTN);
        users = findViewById(R.id.usersLV);

        countUsersViewModel = new ViewModelProvider(this).get(CountUsersViewModel.class);
        countUsersViewModel.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, countUsersViewModel.getUsers()));
        users.setAdapter(countUsersViewModel.getAdapter());
    }
}