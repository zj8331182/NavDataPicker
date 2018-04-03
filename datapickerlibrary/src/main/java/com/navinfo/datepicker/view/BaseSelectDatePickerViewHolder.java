package com.navinfo.datepicker.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.lang.ref.WeakReference;

/**
 * @author Zhang Mingzhe
 * @date 2018/4/3
 * mail:1084904209@qq.com
 * Describe
 */
public class BaseSelectDatePickerViewHolder extends RecyclerView.ViewHolder {

    private WeakReference<BaseSelectDataPickerAdapter<? extends BaseSelectDatePickerViewHolder>> mAdapter;

    protected BaseSelectDatePickerViewHolder(View itemView) {
        super(itemView);
        View.OnClickListener mItemClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAdapter.get().getSelectMode().onItemClick(getAdapterPosition());
            }
        };
        itemView.setOnClickListener(mItemClickListener);
    }


    public void setAdapter(WeakReference<BaseSelectDataPickerAdapter<? extends BaseSelectDatePickerViewHolder>> mAdapter) {
        this.mAdapter = mAdapter;
    }
}
