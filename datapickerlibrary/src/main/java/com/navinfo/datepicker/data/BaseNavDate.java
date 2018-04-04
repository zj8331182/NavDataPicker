package com.navinfo.datepicker.data;

import android.support.annotation.NonNull;

import java.util.Calendar;

/**
 * @author Zhang Mingzhe
 * @date 2018/3/22
 * mail:1084904209@qq.com
 * Describe
 */
public class BaseNavDate implements Comparable<BaseNavDate> {

    private Calendar mDate;
    private int mType;
    private ChineseDate mChineseDate;

    BaseNavDate() {
    }

    public Calendar getDate() {
        return mDate;
    }

    public void setDate(Calendar date) {
        mDate = date;
    }

    public int getType() {
        return mType;
    }

    public void setType(int type) {
        mType = type;
    }

    public ChineseDate getChineseDate() {
        return mChineseDate;
    }

    public void setChineseDate(ChineseDate chineseDate) {
        mChineseDate = chineseDate;
    }

    @Override
    public int compareTo(@NonNull BaseNavDate that) {
        if (that.getDate() == null){
            return 1;
        }
        int year = mDate.get(Calendar.YEAR) - that.getDate().get(Calendar.YEAR);
        if (year != 0) {
            return year;
        }
        int month = mDate.get(Calendar.MONTH) - that.getDate().get(Calendar.MONTH);
        if (month != 0) {
            return month;
        }
        return mDate.get(Calendar.DATE) - that.getDate().get(Calendar.DATE);
    }
}
