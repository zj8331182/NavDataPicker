package com.navinfo.datepicker.view;

import com.navinfo.datepicker.data.BaseSelectDate;

public interface DatePickerSelectMode<T extends BaseSelectDate> {
    void onItemClick(T item);
}
