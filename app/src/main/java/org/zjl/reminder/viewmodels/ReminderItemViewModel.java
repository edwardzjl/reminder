package org.zjl.reminder.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.zjl.reminder.data.ReminderItem;

import java.util.List;

public class ReminderItemViewModel extends ViewModel {

    private MutableLiveData<List<ReminderItem>> items;

    public LiveData<List<ReminderItem>> getItems() {
        if (items == null) {
            items = new MutableLiveData<>();
            loadItems();
        }
        return items;
    }

    private void loadItems() {
        // Do an asynchronous operation to fetch items.
    }

}
