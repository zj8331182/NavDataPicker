package com.navinfo.datepicker.view;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.navinfo.datepicker.data.BaseNavDate;

import java.util.Calendar;

import static com.navinfo.datepicker.data.NavDatePickerConstant.NavDatePickerViewType.VIEW_TYPE_CHINESE_DATE;
import static com.navinfo.datepicker.data.NavDatePickerConstant.NavDatePickerViewType.VIEW_TYPE_DATE;
import static com.navinfo.datepicker.data.NavDatePickerConstant.NavDatePickerViewType.VIEW_TYPE_EMPTY;
import static com.navinfo.datepicker.data.NavDatePickerConstant.NavDatePickerViewType.VIEW_TYPE_MONTH_TITLE;

/**
 * @author Zhang Mingzhe
 * @date 2018/3/22
 * mail:1084904209@qq.com
 * Describe
 */
public class DefaultDatePickerAdapter extends BaseNavDataPickerAdapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_MONTH_TITLE:
                TextView textView = new TextView(parent.getContext());
                textView.setGravity(View.TEXT_ALIGNMENT_CENTER);
                textView.setHeight(200);
                textView.setBackgroundColor(Color.LTGRAY);
                return new DefaultNavDatePickerViewHolder(textView);
            case VIEW_TYPE_CHINESE_DATE:
                TextView tvDate = new TextView(parent.getContext());
                tvDate.setGravity(View.TEXT_ALIGNMENT_CENTER);
                tvDate.setHeight(150);
                tvDate.setTextSize(22);

                TextView tvChineseDate = new TextView(parent.getContext());
                tvChineseDate.setGravity(View.TEXT_ALIGNMENT_CENTER);
                tvChineseDate.setHeight(150);

                LinearLayout linearLayout = new LinearLayout(parent.getContext());
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                linearLayout.addView(tvDate);
                linearLayout.addView(tvChineseDate);
                return new DefaultNavDatePickerViewHolder(linearLayout);
            case VIEW_TYPE_DATE:
            case VIEW_TYPE_EMPTY:
            default:
                TextView tvDateOnly = new TextView(parent.getContext());
                tvDateOnly.setGravity(View.TEXT_ALIGNMENT_CENTER);
                tvDateOnly.setHeight(300);
                tvDateOnly.setTextSize(22);
                return new DefaultNavDatePickerViewHolder(tvDateOnly);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BaseNavDate date = (BaseNavDate) mDateList.get(position);
        switch (holder.getItemViewType()) {
            case VIEW_TYPE_CHINESE_DATE:
                ((TextView) ((LinearLayout) holder.itemView).getChildAt(0)).setText(String.valueOf(date.getDate().get(Calendar.DAY_OF_MONTH)));
                ((TextView) ((LinearLayout) holder.itemView).getChildAt(1)).setText(String.valueOf(date.getChineseDate().getDate()));
                break;
            case VIEW_TYPE_DATE:
                ((TextView) holder.itemView).setText(String.valueOf(date.getDate().get(Calendar.DAY_OF_MONTH)));
                break;
            case VIEW_TYPE_MONTH_TITLE:
                Calendar calendar = date.getDate();
                ((TextView) holder.itemView).setText(calendar.get(Calendar.YEAR) + "年 " + (calendar.get(Calendar.MONTH) + 1) + "月");
                break;
            case VIEW_TYPE_EMPTY:
            default:
                break;
        }
    }

    class DefaultNavDatePickerViewHolder extends RecyclerView.ViewHolder {
        DefaultNavDatePickerViewHolder(View itemView) {
            super(itemView);
        }
    }
}
