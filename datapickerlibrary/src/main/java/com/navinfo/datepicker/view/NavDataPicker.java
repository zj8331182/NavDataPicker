package com.navinfo.datepicker.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.navinfo.datepicker.data.BaseNavDate;
import com.navinfo.datepicker.data.NavDatePickerConstant;

import java.util.Calendar;

/**
 * @author Zhang Mingzhe
 * @date 2018/3/22
 * mail:1084904209@qq.com
 * Describe
 */
public class NavDataPicker<T extends Class<? extends BaseNavDate>> extends FrameLayout {
    private final static int DATE_PICKER_SPAN_COUNT = 7;
    private BaseNavDataPickerAdapter mDataPickerAdapter;

    public NavDataPicker(Context context) {
        super(context);
    }

    public NavDataPicker(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NavDataPicker(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        RecyclerView recyclerView = new RecyclerView(getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), DATE_PICKER_SPAN_COUNT, GridLayoutManager.VERTICAL, false);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return mDataPickerAdapter.getItemViewType(position) == NavDatePickerConstant.VIEW_TYPE_MONTH_TITLE ? 7 : 1;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(mDataPickerAdapter);
        addView(recyclerView);
    }

    public void setDataPickerAdapter(BaseNavDataPickerAdapter dataPickerAdapter) {
        mDataPickerAdapter = dataPickerAdapter;
    }

    public void setDateRange(Calendar start, Calendar end){

    }
}
