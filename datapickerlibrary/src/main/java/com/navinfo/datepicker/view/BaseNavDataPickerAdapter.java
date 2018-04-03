package com.navinfo.datepicker.view;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

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
    public final T onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateViewHolderCustom(parent, viewType);
    }

    /**
     * 自定义Item的onCreateViewHolder
     *
     * @param parent   parent
     * @param viewType viewType
     * @return Custom ViewHolder
     * @see RecyclerView.Adapter
     */
    public abstract T onCreateViewHolderCustom(ViewGroup parent, int viewType);

    /**
     * 自定义Item的onBindViewHolder
     *
     * @param holder   Holder
     * @param position position
     * @see RecyclerView.Adapter
     */
    protected abstract void onBindViewHolderCustom(T holder, int position);

    @Override
    public final void onBindViewHolder(T holder, int position) {
        onBindViewHolderCustom(holder, position);
    }

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
