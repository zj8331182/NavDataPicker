package com.navinfo.datapicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.navinfo.datepicker.data.NavDateUtil;
import com.navinfo.datepicker.data.WeekendNavDate;
import com.navinfo.datepicker.view.NavDataPicker;
import com.navinfo.datepicker.view.WeekendDatePickerAdapter;

import java.util.Calendar;
import java.util.List;

/**
 * @author Zhang Mingzhe
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavDataPicker dataPicker = findViewById(R.id.date_picker);
        Calendar cs = Calendar.getInstance();
        cs.set(2018, 0, 0);
        Calendar ce = Calendar.getInstance();
        ce.set(2020, 0, 0);
        NavDateUtil<WeekendNavDate> dataUtil = new NavDateUtil<>();
        List<WeekendNavDate> date_pickers = null;
        try {
            date_pickers = dataUtil.getNavDateRange(cs, ce, WeekendNavDate.class, false);
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        WeekendDatePickerAdapter mPickerAdapter = new WeekendDatePickerAdapter();
        mPickerAdapter.setDateList(date_pickers);
        dataPicker.setDataPickerAdapter(mPickerAdapter);
    }
}
