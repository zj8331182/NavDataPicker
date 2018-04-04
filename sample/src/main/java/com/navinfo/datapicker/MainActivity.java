package com.navinfo.datapicker;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.navinfo.datepicker.data.BaseSelectDate;
import com.navinfo.datepicker.data.NavDateUtil;
import com.navinfo.datepicker.view.NavDataPicker;
import com.navinfo.datepicker.view.OnNavDateSelectListener;

import java.util.Calendar;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static com.navinfo.datepicker.view.BaseSelectDataPickerAdapter.NAV_DATE_PICKER_SELECT_MODE_TWO;

/**
 * @author Zhang Mingzhe
 */
public class MainActivity extends AppCompatActivity {
    private NavDataPicker dataPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataPicker = findViewById(R.id.date_picker);
        initTitleAdapter();
        initAdapter();
    }

    private void initTitleAdapter() {
        SampleTitleAdapter adapter = new SampleTitleAdapter();
        dataPicker.setTitleAdapter(adapter);
    }

    @SuppressLint("CheckResult")
    private void initAdapter() {
        final Calendar cs = Calendar.getInstance();
        cs.set(2018, 0, 0);
        final Calendar ce = Calendar.getInstance();
        ce.set(2020, 0, 0);
        final NavDateUtil<SampleDate> dataUtil = new NavDateUtil<>();
        Observable.just(dataUtil)
                .map(new Function<NavDateUtil<SampleDate>, List<SampleDate>>() {
                    @Override
                    public List<SampleDate> apply(NavDateUtil<SampleDate> sampleDateNavDateUtil) throws Exception {
                        return sampleDateNavDateUtil.getNavDateRange(cs, ce, SampleDate.class, false);
                    }
                })
                .map(new Function<List<SampleDate>, List<SampleDate>>() {
                    @Override
                    public List<SampleDate> apply(List<SampleDate> sampleDates) {
                        Calendar calendar = Calendar.getInstance();
                        for (SampleDate sampleDate : sampleDates) {
                            if (sampleDate.getDate() != null && sampleDate.getDate().compareTo(calendar) < 0) {
                                sampleDate.setEnable(false);
                            } else {
                                sampleDate.setEnable(true);
                            }
                        }
                        return sampleDates;
                    }
                })
                .observeOn(Schedulers.computation())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<SampleDate>>() {
                    @Override
                    public void accept(List<SampleDate> sampleDates) {
                        SampleDatePickerAdapter mPickerAdapter = new SampleDatePickerAdapter();
                        mPickerAdapter.setDateList(sampleDates);
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
                });
    }
}
