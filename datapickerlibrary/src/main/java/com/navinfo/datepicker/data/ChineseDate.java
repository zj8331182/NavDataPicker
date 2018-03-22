package com.navinfo.datepicker.data;

/**
 *
 * @author Zhang Mingzhe
 * @date 2018/3/22
 * mail:1084904209@qq.com
 * Describe
 */
public class ChineseDate {
    private int year;
    private int month;
    private int date;
    private boolean isLeap;

    public int getDate() {
        return date;
    }

    void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    void setYear(int year) {
        this.year = year;
    }

    public boolean isLeap() {
        return isLeap;
    }

    void setLeap(boolean leap) {
        isLeap = leap;
    }
}
