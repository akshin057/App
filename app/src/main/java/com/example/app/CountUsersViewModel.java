package com.example.app;

import android.widget.ArrayAdapter;

import androidx.lifecycle.ViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CountUsersViewModel extends ViewModel {
    private List<User> users = new ArrayList<>();
    private ArrayAdapter adapter;

    public void setAdapter(ArrayAdapter adapter) {
        this.adapter = adapter;
    }

    public void add(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public ArrayAdapter getAdapter() {
        return adapter;
    }
}
