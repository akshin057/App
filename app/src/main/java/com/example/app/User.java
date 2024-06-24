package com.example.app;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class User implements Parcelable {
    private String name;
    private String surname;
    private String address;
    private String phone;

    public User(String name, String surname, String address, String phone) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
    }

    protected User(Parcel in) {
        name = in.readString();
        surname = in.readString();
        address = in.readString();
        phone = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(surname);
        dest.writeString(address);
        dest.writeString(phone);
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
