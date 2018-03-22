package com.navinfo.datepicker.view;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.navinfo.datepicker.data.NavDatePickerConstant;
import com.navinfo.datepicker.data.WeekendNavDate;

import java.util.Calendar;

/**
 * @author Zhang Mingzhe
 * @date 2018/3/22
 * mail:1084904209@qq.com
 * Describe
 */
public class WeekendDatePickerAdapter extends BaseNavDataPickerAdapter<WeekendNavDate> {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolderCustom(ViewGroup parent, int viewType) {
        switch (viewType) {
            case NavDatePickerConstant.VIEW_TYPE_MONTH_TITLE:
                TextView textView = new TextView(parent.getContext());
                textView.setGravity(View.TEXT_ALIGNMENT_CENTER);
                textView.setHeight(200);
                textView.setBackgroundColor(Color.LTGRAY);
                return new DefaultNavDatePickerViewHolder(textView);
            case NavDatePickerConstant.VIEW_TYPE_DATE:
            case NavDatePickerConstant.VIEW_TYPE_EMPTY:
            default:
                TextView tvDateOnly = new TextView(parent.getContext());
                tvDateOnly.setGravity(View.TEXT_ALIGNMENT_CENTER);
                tvDateOnly.setHeight(300);
                tvDateOnly.setTextSize(22);
                return new DefaultNavDatePickerViewHolder(tvDateOnly);
        }
    }

    @Override
    public void onBindViewHolderCustom(RecyclerView.ViewHolder holder, int position) {
        WeekendNavDate date = mDateList.get(position);
        switch (holder.getItemViewType()) {
            case NavDatePickerConstant.VIEW_TYPE_DATE:
                ((TextView) holder.itemView).setText(String.valueOf(date.getDate().get(Calendar.DAY_OF_MONTH)));
                holder.itemView.setBackgroundColor(date.isWeekend() ? Color.GREEN : Color.WHITE);
                break;
            case NavDatePickerConstant.VIEW_TYPE_MONTH_TITLE:
                Calendar calendar = date.getDate();
                ((TextView) holder.itemView).setText(calendar.get(Calendar.YEAR) + "年 " + (calendar.get(Calendar.MONTH) + 1) + "月");
                break;
            case NavDatePickerConstant.VIEW_TYPE_EMPTY:
            default:
                break;
        }
    }
}
