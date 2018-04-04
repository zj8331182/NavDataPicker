package com.navinfo.datepicker.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import static com.navinfo.datepicker.data.NavDatePickerConstant.NavDatePickerViewType.VIEW_TYPE_MONTH_TITLE;

/**
 * @author Zhang Mingzhe
 * @date 2018/3/22
 * mail:1084904209@qq.com
 * Describe
 */
public class NavDataPicker extends LinearLayout {
    private final static int DATE_PICKER_SPAN_COUNT = 7;
    private BaseNavDataPickerAdapter mContentDatePickerAdapter;
    private BaseTitleDatePickerAdapter mTitleDatePickerAdapter;

    public NavDataPicker(Context context) {
        super(context);
        setOrientation(VERTICAL);
    }

    public NavDataPicker(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOrientation(VERTICAL);
    }

    public NavDataPicker(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(VERTICAL);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        RecyclerView titleRecyclerView = new RecyclerView(getContext());
        titleRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), DATE_PICKER_SPAN_COUNT, GridLayoutManager.VERTICAL, false));
        titleRecyclerView.setAdapter(mTitleDatePickerAdapter);
        addView(titleRecyclerView);
        RecyclerView contentRecyclerView = new RecyclerView(getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), DATE_PICKER_SPAN_COUNT, GridLayoutManager.VERTICAL, false);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return mContentDatePickerAdapter.getItemViewType(position) == VIEW_TYPE_MONTH_TITLE ? 7 : 1;
            }
        });
        contentRecyclerView.setLayoutManager(gridLayoutManager);
        contentRecyclerView.setAdapter(mContentDatePickerAdapter);
        addView(contentRecyclerView);
    }

    public void setDataPickerAdapter(BaseNavDataPickerAdapter dataPickerAdapter) {
        mContentDatePickerAdapter = dataPickerAdapter;
    }

    public void setTitleAdapter(BaseTitleDatePickerAdapter titleAdapter) {
        mTitleDatePickerAdapter = titleAdapter;
    }
}
