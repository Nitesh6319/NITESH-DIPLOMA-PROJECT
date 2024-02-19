package org.diploma.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.diploma.model.Schedule;
import org.diploma.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public void createSchedule(Schedule schedule) {

        Optional<Integer> highestId = scheduleRepository.findFirstByOrderByIdDesc();
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
            schedule.setId(i1);
        }
        else{
            i1=i1+1;
            log.info("Id incremented to  {}",i1);
            schedule.setId(i1);
        }



        Schedule newSchedule = Schedule.builder()
                .id(schedule.getId())
                .activity(schedule.getActivity())
                .date(schedule.getDate())
                .startTime(schedule.getStartTime())
                .build();

        scheduleRepository.save(newSchedule);

        log.info("Schedule {} is saved with ID: {}", newSchedule.getActivity(), newSchedule.getId());
    }

    public List<Schedule> getAllSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll();
        log.info("Schedule Count: {}", schedules.size());
        return schedules;
    }
}

