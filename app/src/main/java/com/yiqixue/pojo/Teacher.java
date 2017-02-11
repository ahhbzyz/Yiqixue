package com.yiqixue.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 文件名：Teacher
 * 描  述：Teacher对象
 * 作  者：yaozhong
 * 时  间：
 */

public class Teacher implements Parcelable {


    private String name;
    private int price;
    private double distance;

    public Teacher(String name, int price, double distance) {
        this.name = name;
        this.price = price;
        this.distance = distance;
    }

    protected Teacher(Parcel in) {
        name = in.readString();
        price = in.readInt();
        distance = in.readDouble();
    }

    public static final Creator<Teacher> CREATOR = new Creator<Teacher>() {
        @Override
        public Teacher createFromParcel(Parcel in) {
            return new Teacher(in);
        }

        @Override
        public Teacher[] newArray(int size) {
            return new Teacher[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(price);
        dest.writeDouble(distance);
    }
}

