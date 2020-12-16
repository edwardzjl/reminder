package org.zjl.reminder;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.zjl.reminder.adapters.ReminderItemRecyclerViewAdapter;
import org.zjl.reminder.data.ReminderItem;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class ReminderListFragment extends Fragment {

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ReminderListFragment() {
    }

    @SuppressWarnings("unused")
    public static ReminderListFragment newInstance(int columnCount) {
        return new ReminderListFragment();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            List<ReminderItem> items = new ArrayList<>();
            items.add(ReminderItem.of("title1", "detail1", Instant.now()));
            items.add(ReminderItem.of("title2", "detail2", Instant.now()));
            items.add(ReminderItem.of("title3", "detail3", Instant.now()));
            recyclerView.setAdapter(new ReminderItemRecyclerViewAdapter(items));
        }
        return view;
    }
}