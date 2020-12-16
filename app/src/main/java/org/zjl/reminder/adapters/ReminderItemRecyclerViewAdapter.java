package org.zjl.reminder.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.zjl.reminder.R;
import org.zjl.reminder.data.ReminderItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link ReminderItem}.
 */
public class ReminderItemRecyclerViewAdapter
        extends RecyclerView.Adapter<ReminderItemRecyclerViewAdapter.ViewHolder> {

    private final List<ReminderItem> mValues;

    public ReminderItemRecyclerViewAdapter(List<ReminderItem> items) {
        mValues = items;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.bind(mValues.get(position));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public ReminderItem mItem;

        public final TextView mTitleView;
        public final TextView mDetailView;
        public final TextView mTimeRemainView;
        public final TextView mTriggerTimeView;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTitleView = view.findViewById(R.id.title);
            mDetailView = view.findViewById(R.id.detail);
            mTimeRemainView = view.findViewById(R.id.timeRemain);
            mTriggerTimeView = view.findViewById(R.id.triggerTime);
        }

        public void bind(ReminderItem item) {
            mTitleView.setText(item.getTitle());
            mDetailView.setText(item.getDetail());
            // TODO: 2020/12/16 zjl check format
            mTriggerTimeView.setText(item.getTriggerTime().toString());
            // TODO: 2020/12/16 zjl set time remaining
            mTimeRemainView.setText("1H");
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mDetailView.getText() + "'";
        }
    }
}