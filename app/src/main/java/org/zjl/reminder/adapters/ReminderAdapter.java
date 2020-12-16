package org.zjl.reminder.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import org.zjl.reminder.R;
import org.zjl.reminder.data.ReminderItem;

public class ReminderAdapter extends ListAdapter<ReminderItem, ReminderAdapter.ReminderItemViewHolder> {

    protected ReminderAdapter() {
        super(DIFF_CALLBACK);
    }


    @Override
    public ReminderItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main, parent, false);
        return new ReminderItemViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ReminderItemViewHolder holder, int position) {
        ReminderItem item = getItem(position);
//        holder.bind(item);
//        holder.textView.setText(mDataset[position]);
    }


    /**
     * Provide a reference to the views for each data item
     * Complex data items may need more than one view per item, and
     * you provide access to all the views for a data item in a view holder
     */
    public static class ReminderItemViewHolder extends RecyclerView.ViewHolder {


        // each data item is just a string in this case
        public TextView textView;

        public ReminderItemViewHolder(TextView v) {
            super(v);
            textView = v;
        }

        public void bind() {

        }
    }


    public static final DiffUtil.ItemCallback<ReminderItem> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<ReminderItem>() {
                @Override
                public boolean areItemsTheSame(
                        @NonNull ReminderItem oldOne, @NonNull ReminderItem newOne) {
                    return oldOne.getId() == newOne.getId();
                }

                @Override
                public boolean areContentsTheSame(
                        @NonNull ReminderItem oldOne, @NonNull ReminderItem newOne) {
                    return oldOne.equals(newOne);
                }
            };

}
