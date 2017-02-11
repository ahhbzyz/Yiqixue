package com.yiqixue.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 文件名：Course
 * 描  述：Course对象
 * 作  者：yaozhong
 * 时  间：
 */

public class Course implements Parcelable {


    private String name;
    private String teacherName;
    private int price;
    private double distance;


    public Course(String name, String teacherName, int price, double distance) {
        this.name = name;
        this.teacherName = teacherName;
        this.price = price;
        this.distance = distance;
    }

    protected Course(Parcel in) {
        name = in.readString();
        teacherName = in.readString();
        price = in.readInt();
        distance = in.readDouble();
    }

    public static final Creator<Course> CREATOR = new Creator<Course>() {
        @Override
        public Course createFromParcel(Parcel in) {
            return new Course(in);
        }

        @Override
        public Course[] newArray(int size) {
            return new Course[size];
        }
    };

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

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
        dest.writeString(teacherName);
        dest.writeInt(price);
        dest.writeDouble(distance);
    }


}