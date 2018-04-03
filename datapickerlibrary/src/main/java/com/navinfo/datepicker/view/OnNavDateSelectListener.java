package com.navinfo.datepicker.view;

import com.navinfo.datepicker.data.BaseSelectDate;

import java.util.List;

/**
 * @author Zhang Mingzhe
 */
public interface OnNavDateSelectListener {

    /**
     * 当有日期被选中时的回调
     *
     * @param dates 被选中的日期
     */
    void onDataSelected(List<? extends BaseSelectDate> dates);
}
