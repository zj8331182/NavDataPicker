package com.navinfo.datepicker.view;

import com.navinfo.datepicker.data.BaseNavDate;

import java.util.List;

public interface OnNavDateSelect<T extends BaseNavDate> {

    void onDataSelected(List<T> dates);
}
