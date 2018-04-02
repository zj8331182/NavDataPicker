package com.navinfo.datepicker.data;

import java.util.Calendar;

/**
 * @author Zhang Mingzhe
 * @date 2018/3/22
 * mail:1084904209@qq.com
 * Describe
 */
public class BaseNavDate {

    Calendar mDate;
    private int mType;
    private ChineseDate mChineseDate;

    BaseNavDate() {
    }

    BaseNavDate(int type) {
        mType = type;
    }

    BaseNavDate(Calendar date, int type) {
        mDate = date;
        this.mType = type;
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
}
