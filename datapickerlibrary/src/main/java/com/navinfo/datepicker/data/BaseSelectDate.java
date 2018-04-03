package com.navinfo.datepicker.data;

/**
 * @author Zhang Mingzhe
 */
public class BaseSelectDate extends BaseNavDate {

    public static final int NAV_DATE_PICKER_SELECT_STATE_NOT_SELECT = 0;
    public static final int NAV_DATE_PICKER_SELECT_STATE_SELECTED = 1;
    public static final int NAV_DATE_PICKER_SELECT_STATE_SELECTED_START = 2;
    public static final int NAV_DATE_PICKER_SELECT_STATE_SELECTED_END = 3;
    private int mSelectState;

    public BaseSelectDate() {
        mSelectState = NAV_DATE_PICKER_SELECT_STATE_NOT_SELECT;
    }

    public int getSelectState() {
        return mSelectState;
    }

    public void setSelectState(int selectState) {
        mSelectState = selectState;
    }
}
