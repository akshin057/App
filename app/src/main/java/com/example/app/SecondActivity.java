package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.Objects;

public class SecondActivity extends AppCompatActivity {

    TextView nameTV;
    TextView surnameTV;
    TextView addressTV;
    TextView phoneTV;
    Button returnBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initUI();

        returnBTN.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });



    }

    private void initUI() {
        nameTV = findViewById(R.id.nameTV);
        surnameTV = findViewById(R.id.surnameTV);
        addressTV = findViewById(R.id.addressTV);
        phoneTV = findViewById(R.id.phoneTV);
        returnBTN = findViewById(R.id.returnBTN);

        User user = (User) Objects.requireNonNull(getIntent().getExtras()).getParcelable("user");
        if (user != null){
            nameTV.setText(user.getName());
            surnameTV.setText(user.getSurname());
            addressTV.setText(user.getAddress());
            phoneTV.setText(user.getPhone());

        }
    }
}