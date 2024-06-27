package com.example.app;

import android.widget.ArrayAdapter;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CountUsersViewModel extends ViewModel {
    private final MutableLiveData<ArrayList<User>> users;
    private final ArrayList<User> usersList;

    public CountUsersViewModel() {
        usersList = new ArrayList<>();
        users = new MutableLiveData<>(usersList);
    }

    public void add(User user) {
        if (user != null) {
            usersList.add(user);
            users.setValue(usersList);
        }
    }

    public MutableLiveData<ArrayList<User>> getUsers() {
        return users;
    }

    public ArrayList<User> getUsersList() {
        return usersList;
    }
}
