package org.diploma.repository;

import org.diploma.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {

    @Query("SELECT MAX(m.id) FROM Schedule m")
    Optional<Integer> findFirstByOrderByIdDesc();

    void deleteById(int id);
}
