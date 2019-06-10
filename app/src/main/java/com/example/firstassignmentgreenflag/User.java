package com.example.firstassignmentgreenflag;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    String name;
    String country;

    public User() {
    }

    String zipcode;
    String gender;
    String birthday;
    String password;


    public User(String name, String country, String zipcode, String gender, String birthday, String password) {
        this.name = name;
        this.country = country;
        this.zipcode = zipcode;
        this.gender = gender;
        this.birthday = birthday;
        this.password = password;
    }


    protected User(Parcel in) {
        name = in.readString ();
        country = in.readString ();
        zipcode = in.readString ();
        gender = in.readString ();
        birthday = in.readString ();
        password = in.readString ();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString (name);
        dest.writeString (country);
        dest.writeString (zipcode);
        dest.writeString (gender);
        dest.writeString (birthday);
        dest.writeString (password);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User> () {
        @Override
        public User createFromParcel(Parcel in) {
            return new User (in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
