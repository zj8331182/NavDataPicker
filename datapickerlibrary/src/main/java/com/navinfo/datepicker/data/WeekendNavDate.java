package com.navinfo.datepicker.data;

import java.util.Calendar;

/**
 * @author Zhang Mingzhe
 * @date 2018/3/22
 * mail:1084904209@qq.com
 * Describe
 */

public class WeekendNavDate extends BaseNavDate {

    private boolean isWeekend;

    public WeekendNavDate() {
    }

    WeekendNavDate(int type) {
        super(type);
    }

    WeekendNavDate(Calendar date, int type) {
        super(date, type);
    }

    public boolean isWeekend() {
        if (mDate == null) {
            return false;
        }
        int week = mDate.get(Calendar.DAY_OF_WEEK);
        return week == Calendar.SATURDAY || week == Calendar.SUNDAY;
    }
}
