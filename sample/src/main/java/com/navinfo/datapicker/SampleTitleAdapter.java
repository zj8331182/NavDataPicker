package com.navinfo.datapicker;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.navinfo.datepicker.view.BaseTitleDatePickerAdapter;

/**
 * @author Zhang Mingzhe
 * @date 2018/4/4
 * mail:1084904209@qq.com
 * Describe
 */
public class SampleTitleAdapter extends BaseTitleDatePickerAdapter<SampleTitleAdapter.TitleViewHolder> {

    @Override
    protected void onBindViewHolderCustom(TitleViewHolder holder, int weekDay) {
        holder.tvTitle.setText(String.valueOf(weekDay));
    }

    @NonNull
    @Override
    public TitleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TitleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_title_item, parent, false));
    }

    class TitleViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;

        TitleViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
