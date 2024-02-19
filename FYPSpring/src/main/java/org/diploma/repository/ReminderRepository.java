package org.diploma.repository;

import org.diploma.model.Registration;
import org.diploma.model.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ReminderRepository extends JpaRepository<Reminder,Integer> {

    @Query("SELECT MAX(m.id) FROM Reminder m")
    Optional<Integer> findFirstByOrderByIdDesc();
}
