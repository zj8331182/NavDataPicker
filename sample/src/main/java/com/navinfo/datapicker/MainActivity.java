package com.navinfo.datapicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.navinfo.datepicker.data.BaseSelectDate;
import com.navinfo.datepicker.data.NavDateUtil;
import com.navinfo.datepicker.view.NavDataPicker;
import com.navinfo.datepicker.view.OnNavDateSelectListener;

import java.util.Calendar;
import java.util.List;

import static com.navinfo.datepicker.view.BaseSelectDataPickerAdapter.NAV_DATE_PICKER_SELECT_MODE_TWO;

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
        NavDateUtil<BaseSelectDate> dataUtil = new NavDateUtil<>();
        List<BaseSelectDate> date_pickers = null;
        try {
            date_pickers = dataUtil.getNavDateRange(cs, ce, BaseSelectDate.class, false);
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        SampleDatePickerAdapter mPickerAdapter = new SampleDatePickerAdapter();
        mPickerAdapter.setDateList(date_pickers);
        mPickerAdapter.setSelectMode(NAV_DATE_PICKER_SELECT_MODE_TWO);
        mPickerAdapter.setOnDateSelectListener(new OnNavDateSelectListener() {
            @Override
            public void onDataSelected(List<? extends BaseSelectDate> dates) {
                Log.i("ZMZ", "onDataSelected: " + dates.size());
            }
        });
        mPickerAdapter.setStartDate(Calendar.getInstance());
        dataPicker.setDataPickerAdapter(mPickerAdapter);
    }
}
