package org.zjl.reminder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import org.zjl.reminder.data.ReminderItem;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewReminderFragment extends Fragment {
    private Calendar calendar;
    FragmentManager fm;
    public NewReminderFragment() {
        // Required empty public constructor
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        calendar = Calendar.getInstance();

        fm = getSupportFragmentManager();
        DatePickerFragment dateDialog = new DatePickerFragment();
        dateDialog.show(fm, "fragment_date");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_reminder, container, false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText title = view.findViewById(R.id.createTitle);
        EditText description = view.findViewById(R.id.createDescription);

        Button creationConfirmButton = view.findViewById(R.id.createConfirm);
        if (creationConfirmButton != null) {

            ReminderItem.of(title.getText().toString(), description.getText().toString(), );
        }
    }
}