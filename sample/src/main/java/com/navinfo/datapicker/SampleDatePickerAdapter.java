package com.navinfo.datapicker;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.navinfo.datepicker.view.BaseSelectDataPickerAdapter;
import com.navinfo.datepicker.view.BaseSelectDatePickerViewHolder;

import java.util.Calendar;

import static com.navinfo.datepicker.data.BaseSelectDate.NAV_DATE_PICKER_SELECT_STATE_NOT_SELECT;
import static com.navinfo.datepicker.data.BaseSelectDate.NAV_DATE_PICKER_SELECT_STATE_SELECTED;
import static com.navinfo.datepicker.data.BaseSelectDate.NAV_DATE_PICKER_SELECT_STATE_SELECTED_END;
import static com.navinfo.datepicker.data.BaseSelectDate.NAV_DATE_PICKER_SELECT_STATE_SELECTED_START;
import static com.navinfo.datepicker.data.NavDatePickerConstant.NavDatePickerViewType.VIEW_TYPE_DATE;
import static com.navinfo.datepicker.data.NavDatePickerConstant.NavDatePickerViewType.VIEW_TYPE_MONTH_TITLE;

/**
 * @author Zhang Mingzhe
 * @date 2018/4/3
 * mail:1084904209@qq.com
 * Describe
 */
public class SampleDatePickerAdapter extends BaseSelectDataPickerAdapter<SampleDatePickerAdapter.BaseSampleViewHolder> {

    @Override
    public void onBindViewHolder(@NonNull BaseSampleViewHolder holder, int position) {
        SampleDate date = (SampleDate) mDateList.get(position);
        switch (date.getType()) {
            case VIEW_TYPE_DATE:
                SampleViewHolder viewHolder = (SampleViewHolder) holder;
                switch (date.getSelectState()) {
                    case NAV_DATE_PICKER_SELECT_STATE_SELECTED:
                        viewHolder.imageView.setBackgroundColor(Color.RED);
                        break;
                    case NAV_DATE_PICKER_SELECT_STATE_SELECTED_START:
                        viewHolder.imageView.setBackgroundColor(Color.GRAY);
                        break;
                    case NAV_DATE_PICKER_SELECT_STATE_SELECTED_END:
                        viewHolder.imageView.setBackgroundColor(Color.YELLOW);
                        break;
                    case NAV_DATE_PICKER_SELECT_STATE_NOT_SELECT:
                    default:
                        viewHolder.imageView.setBackgroundColor(Color.WHITE);
                        break;
                }
                viewHolder.itemView.setEnabled(date.isEnable());
                viewHolder.textView.setTextColor(date.isEnable() ? Color.BLACK : Color.GRAY);
                viewHolder.textView.setText(String.valueOf(date.getDate().get(Calendar.DATE)));
                break;
            case VIEW_TYPE_MONTH_TITLE:
                SampleMonthViewHolder monthViewHolder = (SampleMonthViewHolder) holder;
                Calendar calendar = date.getDate();
                monthViewHolder.tvTitle.setText(calendar.get(Calendar.YEAR) + "年 " + (calendar.get(Calendar.MONTH) + 1) + "月");
                break;
            default:
                break;
        }
    }

    @Override
    protected BaseSampleViewHolder onCreateViewHolderCustomInSelectMode(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_MONTH_TITLE:
                return new SampleMonthViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_month_title_item, parent, false));
            case VIEW_TYPE_DATE:
            default:
                return new SampleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_date_picker_item, parent, false));
        }
    }

    class BaseSampleViewHolder extends BaseSelectDatePickerViewHolder {
        BaseSampleViewHolder(View itemView) {
            super(itemView);
        }
    }

    class SampleViewHolder extends BaseSampleViewHolder {
        ImageView imageView;
        TextView textView;

        SampleViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_date);
            imageView = itemView.findViewById(R.id.iv_background);
        }
    }

    class SampleMonthViewHolder extends BaseSampleViewHolder {

        TextView tvTitle;

        SampleMonthViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_month_title);
        }
    }

}
