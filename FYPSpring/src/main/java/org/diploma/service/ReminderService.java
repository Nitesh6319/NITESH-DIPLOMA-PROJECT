package org.diploma.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.diploma.model.DietPlan;
import org.diploma.model.Reminder;
import org.diploma.repository.ReminderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReminderService {

    private final ReminderRepository reminderRepository;

    public void createReminder(Reminder reminder) {

        Optional<Integer> highestId = reminderRepository.findFirstByOrderByIdDesc();
        Integer i1;
        try{
            i1= highestId.get();
        }catch(Exception e){
            log.info("error encountered but setting id=0");
            i1=0;
        }
        if(i1!=0){
            log.info("Max Id from DB {}",i1);
            i1=i1+1;
            log.info("Id incremented to  {}",i1);
            reminder.setId(i1);
        }
        else{
            i1=i1+1;
            log.info("Id incremented to  {}",i1);
            reminder.setId(i1);
        }

        Reminder newReminder = Reminder.builder()
                .id(reminder.getId())
                .title(reminder.getTitle())
                .description(reminder.getDescription())
                .build();

        reminderRepository.save(newReminder);

        log.info("Reminder {} is saved with ID: {}", newReminder.getTitle(), newReminder.getId());
    }

    public List<Reminder> getAllReminders() {
        List<Reminder> reminders = reminderRepository.findAll();
        log.info("Reminder Count: {}", reminders.size());
        return reminders;
    }

    public void deleteByID(Reminder reminder){
        reminderRepository.deleteById(reminder.getId());
        log.info("Deleted Medicine by id: {}",reminder.getId());
    }
}

