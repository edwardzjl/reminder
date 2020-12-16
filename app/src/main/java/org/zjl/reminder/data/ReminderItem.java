package org.zjl.reminder.data;

import java.time.Instant;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReminderItem {

    private UUID id;

    private String title;

    private String detail;

    private Instant triggerTime;


    public static ReminderItem of(String title, String detail, Instant triggerTime) {
        ReminderItem item = new ReminderItem();
        item.id = UUID.randomUUID();
        item.title = title;
        item.detail = detail;
        item.triggerTime = triggerTime;
        return item;
    }

}
