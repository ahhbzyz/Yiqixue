package com.yiqixue.pojo;

import java.util.Comparator;


/**
 * 文件名：AttrComparator
 * 描  述：对象的属性比较
 * 作  者：yaozhong
 * 时  间：
 */

public class AttrComparator implements Comparator {

    String attribute;
    String type;

    public AttrComparator(String attribute, String type) {
        this.type = type;
        this.attribute = attribute;
    }

    //Course Institution Teacher 中的价格，距离比较
    @Override
    public int compare(Object obj0, Object obj1) {

        if (type.equals("Course")) {
            Course course0 = (Course) obj0;
            Course course1 = (Course) obj1;

            if (attribute.equals("price")) {

                if (null != course0 && null != course1) {
                    if (course0.getPrice() > course1.getPrice()) {
                        return 1;
                    } else if (course0.getPrice() == course1.getPrice()) {
                        return 0;
                    }
                }
                return -1;

            } else {

                if (null != course0 && null != course1) {
                    if (course0.getDistance() > course1.getDistance()) {
                        return 1;
                    } else if (course0.getDistance() == course1.getDistance()) {
                        return 0;
                    }
                }
                return -1;

            }
        } else if (type.equals("Teacher")) {
            Teacher teacher0 = (Teacher) obj0;
            Teacher teacher1 = (Teacher) obj1;

            if (attribute.equals("price")) {


                if (null != teacher0 && null != teacher1) {
                    if (teacher0.getPrice() > teacher1.getPrice()) {
                        return 1;
                    } else if (teacher0.getPrice() == teacher1.getPrice()) {
                        return 0;
                    }
                }
                return -1;

            } else {

                if (null != teacher0 && null != teacher1) {
                    if (teacher0.getDistance() > teacher1.getDistance()) {
                        return 1;
                    } else if (teacher0.getDistance() == teacher1.getDistance()) {
                        return 0;
                    }
                }
                return -1;
            }
        } else {
            Institution institution0 = (Institution) obj0;
            Institution institution1 = (Institution) obj1;

            if (attribute.equals("price")) {


                if (null != institution0 && null != institution1) {
                    if (institution0.getPrice() > institution1.getPrice()) {
                        return 1;
                    } else if (institution0.getPrice() == institution1.getPrice()) {
                        return 0;
                    }
                }
                return -1;

            } else {

                if (null != institution0 && null != institution1) {
                    if (institution0.getDistance() > institution1.getDistance()) {
                        return 1;
                    } else if (institution0.getDistance() == institution1.getDistance()) {
                        return 0;
                    }
                }
                return -1;
            }
        }


    }


}
