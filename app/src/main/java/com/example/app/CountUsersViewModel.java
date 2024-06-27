package com.example.app;

import android.widget.ArrayAdapter;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CountUsersViewModel extends ViewModel {
    private final MutableLiveData<ArrayList<User>> users;
    private ArrayAdapter<User> adapter;

    public CountUsersViewModel() {
        users = new MutableLiveData<>(new ArrayList<>());
    }

    public void add(User user) {
        ArrayList<User> currentUsers = users.getValue();
        if (currentUsers != null) {
            currentUsers.add(user);
            users.setValue(currentUsers);
            if (adapter != null) {
                adapter.add(user);
            }
        }
    }

    public MutableLiveData<ArrayList<User>> getUsers() {
        return users;
    }

    public void setAdapter(ArrayAdapter<User> adapter) {
        this.adapter = adapter;
    }

    public ArrayAdapter<User> getAdapter() {
        return adapter;
    }
}
