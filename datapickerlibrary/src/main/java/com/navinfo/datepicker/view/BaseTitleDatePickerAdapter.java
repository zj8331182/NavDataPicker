package com.navinfo.datepicker.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

/**
 * @author Zhang Mingzhe
 * @date 2018/4/4
 * mail:1084904209@qq.com
 * Describe
 */
abstract public class BaseTitleDatePickerAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {

    private final static int[] WEEK_DAYS = new int[]{7, 1, 2, 3, 4, 5, 6};

    @Override
    public final void onBindViewHolder(@NonNull T holder, int position) {
        onBindViewHolderCustom(holder, WEEK_DAYS[position]);
    }

    /**
     * 同onBindViewHolder
     *
     * @param holder  ViewHolder
     * @param weekDay 1:星期一,2:星期二...7:星期日
     */
    protected abstract void onBindViewHolderCustom(T holder, int weekDay);

    @Override
    public int getItemCount() {
        return 7;
    }
}
