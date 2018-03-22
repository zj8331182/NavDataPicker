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
public abstract class BaseNavDataPickerAdapter<T extends BaseNavDate> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected List<T> mDateList;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
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
    public abstract RecyclerView.ViewHolder onCreateViewHolderCustom(ViewGroup parent, int viewType);

    /**
     * 自定义Item的onBindViewHolder
     *
     * @param holder   Holder
     * @param position position
     * @see RecyclerView.Adapter
     */
    public abstract void onBindViewHolderCustom(RecyclerView.ViewHolder holder, int position);

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBindViewHolderCustom(holder, position);
    }

    @Override
    public int getItemCount() {
        return mDateList == null ? 0 : mDateList.size();
    }

    public void setDateList(List<T> dateList) {
        mDateList = dateList;
    }

    @Override
    public int getItemViewType(int position) {
        return mDateList.get(position).getType();
    }
}
