package com.navinfo.datepicker.view;

import android.support.v7.widget.RecyclerView;

import com.navinfo.datepicker.data.BaseNavDate;

import java.util.List;

/**
 * @author Zhang Mingzhe
 * @date 2018/3/22
 * mail:1084904209@qq.com
 * Describe
 */
public abstract class BaseNavDataPickerAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {

    protected List<? extends BaseNavDate> mDateList;

    @Override
    public int getItemCount() {
        return mDateList == null ? 0 : mDateList.size();
    }

    public void setDateList(List<? extends BaseNavDate> dateList) {
        mDateList = dateList;
    }

    @Override
    public int getItemViewType(int position) {
        return mDateList.get(position).getType();
    }
}
