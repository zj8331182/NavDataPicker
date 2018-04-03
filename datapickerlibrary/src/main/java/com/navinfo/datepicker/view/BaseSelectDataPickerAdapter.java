package com.navinfo.datepicker.view;

import android.view.ViewGroup;

import com.navinfo.datepicker.data.BaseSelectDate;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import static com.navinfo.datepicker.data.BaseSelectDate.NAV_DATE_PICKER_SELECT_STATE_NOT_SELECT;
import static com.navinfo.datepicker.data.BaseSelectDate.NAV_DATE_PICKER_SELECT_STATE_SELECTED;
import static com.navinfo.datepicker.data.BaseSelectDate.NAV_DATE_PICKER_SELECT_STATE_SELECTED_START;

/**
 * @author Zhang Mingzhe
 */
public abstract class BaseSelectDataPickerAdapter<T extends BaseSelectDatePickerViewHolder> extends BaseNavDataPickerAdapter<T> {

    public static final int NAV_DATE_PICKER_SELECT_MODE_ONE = 0;
    public static final int NAV_DATE_PICKER_SELECT_MODE_TWO = 1;
    private BaseDatePickerSelectMode mSelectMode;


    public BaseSelectDataPickerAdapter() {
        mSelectMode = new DatePickerSelectOneMode();
    }

    @Override
    public final T onCreateViewHolder(ViewGroup parent, int viewType) {
        T t = onCreateViewHolderCustomInSelectMode(parent, viewType);
        t.setAdapter(new WeakReference<BaseSelectDataPickerAdapter<? extends BaseSelectDatePickerViewHolder>>(this));
        return t;
    }

    public BaseDatePickerSelectMode getSelectMode() {
        return mSelectMode;
    }

    public void setSelectMode(int mode) {
        switch (mode) {
            case NAV_DATE_PICKER_SELECT_MODE_TWO:
                mSelectMode = new DatePickerSelectTwoMode<BaseSelectDate>();
                break;
            case NAV_DATE_PICKER_SELECT_MODE_ONE:
            default:
                mSelectMode = new DatePickerSelectOneMode();
                break;
        }
    }

    /**
     * 获取ViewHolder
     *
     * @param parent   Parent
     * @param viewType View Type@link{}
     * @return ViewHolder
     */
    protected abstract T onCreateViewHolderCustomInSelectMode(ViewGroup parent, int viewType);

    public void setOnDateSelectListener(OnNavDateSelectListener listener) {
        mSelectMode.setListener(listener);
    }

    abstract class BaseDatePickerSelectMode<R extends BaseSelectDate> {

        List<R> mSelectItems;
        private OnNavDateSelectListener mListener;

        BaseDatePickerSelectMode() {
            mSelectItems = new ArrayList<>();
        }

        /**
         * Item点击的实现
         *
         * @param position position
         */
        abstract void onItemClick(int position);

        OnNavDateSelectListener getListener() {
            return mListener;
        }

        void setListener(OnNavDateSelectListener listener) {
            mListener = listener;
        }
    }

    class DatePickerSelectTwoMode<H extends BaseSelectDate> extends BaseDatePickerSelectMode<H> {

        private int mStartDateIndex = -1;
        private int mEndDateIndex = -1;

        @Override
        void onItemClick(int position) {
            if (mStartDateIndex >= 0) {
                if (mEndDateIndex < 0) {
                    hasStartSelectEnd(position);
                } else {
                    hasStartHasEnd();
                }
            } else {
                selectStart(position);
            }
        }

        private void selectStart(int position) {
            mStartDateIndex = position;
            ((BaseSelectDate) mDateList.get(position)).setSelectState(NAV_DATE_PICKER_SELECT_STATE_SELECTED_START);
            notifyItemChanged(position);
        }

        private void hasStartHasEnd() {
            clearSelectList();
            notifyItemRangeChanged(mStartDateIndex, mEndDateIndex - mStartDateIndex + 1);
            mStartDateIndex = -1;
            mEndDateIndex = -1;
        }

        private void clearSelectList() {
            for (BaseSelectDate date : mSelectItems) {
                date.setSelectState(NAV_DATE_PICKER_SELECT_STATE_NOT_SELECT);
            }
            mSelectItems = new ArrayList<>();
        }

        private void hasStartSelectEnd(int position) {
            if (mStartDateIndex <= position) {
                mEndDateIndex = position;
                ((BaseSelectDate) mDateList.get(position)).setSelectState(BaseSelectDate.NAV_DATE_PICKER_SELECT_STATE_SELECTED_END);
                getSelectList(mStartDateIndex, mEndDateIndex);
                notifyItemRangeChanged(mStartDateIndex, mEndDateIndex - mStartDateIndex + 1);
                OnNavDateSelectListener listener = getListener();
                if (listener != null) {
                    listener.onDataSelected(mSelectItems);
                }
            } else {
                mSelectItems = new ArrayList<>();
                ((BaseSelectDate) mDateList.get(mStartDateIndex)).setSelectState(NAV_DATE_PICKER_SELECT_STATE_NOT_SELECT);
                notifyItemChanged(mStartDateIndex);
                mStartDateIndex = -1;
            }
        }

        private void getSelectList(int start, int end) {
            mSelectItems = (List<H>) mDateList.subList(start, end + 1);
            int count = mSelectItems.size();
            for (int i = 1; i < (count - 1); i++) {
                mSelectItems.get(i).setSelectState(BaseSelectDate.NAV_DATE_PICKER_SELECT_STATE_SELECTED);
            }
        }
    }


    public class DatePickerSelectOneMode extends BaseDatePickerSelectMode {

        @Override
        public void onItemClick(int position) {
            BaseSelectDate item = (BaseSelectDate) mDateList.get(position);
            if (item.getSelectState() == NAV_DATE_PICKER_SELECT_STATE_SELECTED) {
                item.setSelectState(NAV_DATE_PICKER_SELECT_STATE_NOT_SELECT);
                if (mSelectItems.contains(item)) {
                    mSelectItems.remove(item);
                }
            } else {
                item.setSelectState(NAV_DATE_PICKER_SELECT_STATE_SELECTED);
                if (!mSelectItems.contains(item)) {
                    mSelectItems.add(item);
                }
            }
            if (getListener() != null) {
                getListener().onDataSelected(mSelectItems);
            }
            notifyItemChanged(mDateList.indexOf(item));
        }
    }
}
