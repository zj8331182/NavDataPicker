package com.navinfo.datepicker.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.navinfo.datepicker.data.BaseSelectDate;

public abstract class BaseSelectDataPickerAdapter extends BaseNavDataPickerAdapter<BaseSelectDate> {



    private OnNavDateSelect<? extends BaseSelectDate> mOnDateSelectedListener;

    private View.OnClickListener mItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    class NavDatePickerSelectViewHolder extends RecyclerView.ViewHolder {

        public NavDatePickerSelectViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(mItemClickListener);
        }
    }
}
