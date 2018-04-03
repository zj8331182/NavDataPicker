package com.navinfo.datapicker;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.navinfo.datepicker.data.BaseSelectDate;
import com.navinfo.datepicker.view.BaseSelectDataPickerAdapter;
import com.navinfo.datepicker.view.BaseSelectDatePickerViewHolder;

import java.util.Calendar;

import static com.navinfo.datepicker.data.BaseSelectDate.NAV_DATE_PICKER_SELECT_STATE_NOT_SELECT;
import static com.navinfo.datepicker.data.BaseSelectDate.NAV_DATE_PICKER_SELECT_STATE_SELECTED;
import static com.navinfo.datepicker.data.BaseSelectDate.NAV_DATE_PICKER_SELECT_STATE_SELECTED_END;
import static com.navinfo.datepicker.data.BaseSelectDate.NAV_DATE_PICKER_SELECT_STATE_SELECTED_START;
import static com.navinfo.datepicker.data.NavDatePickerConstant.VIEW_TYPE_DATE;

/**
 * @author Zhang Mingzhe
 * @date 2018/4/3
 * mail:1084904209@qq.com
 * Describe
 */
public class SampleDatePickerAdapter extends BaseSelectDataPickerAdapter<SampleDatePickerAdapter.SampleViewHolder> {

    @Override
    public void onBindViewHolderCustom(SampleViewHolder holder, int position) {
        BaseSelectDate date = (BaseSelectDate) mDateList.get(position);
        if (date.getType() == VIEW_TYPE_DATE) {
            switch (date.getSelectState()) {
                case NAV_DATE_PICKER_SELECT_STATE_SELECTED:
                    holder.imageView.setBackgroundColor(Color.RED);
                    break;
                case NAV_DATE_PICKER_SELECT_STATE_SELECTED_START:
                    holder.imageView.setBackgroundColor(Color.GRAY);
                    break;
                case NAV_DATE_PICKER_SELECT_STATE_SELECTED_END:
                    holder.imageView.setBackgroundColor(Color.YELLOW);
                    break;
                case NAV_DATE_PICKER_SELECT_STATE_NOT_SELECT:
                default:
                    holder.imageView.setBackgroundColor(Color.WHITE);
                    break;
            }
            holder.textView.setText(String.valueOf(date.getDate().get(Calendar.DATE)));
        }
    }

    @Override
    protected SampleViewHolder onCreateViewHolderCustomInSelectMode(ViewGroup parent, int viewType) {
        return new SampleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_date_picker_item, parent, false));
    }

    class SampleViewHolder extends BaseSelectDatePickerViewHolder {

        ImageView imageView;
        TextView textView;

        SampleViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_date);
            imageView = itemView.findViewById(R.id.iv_background);
        }
    }

}
