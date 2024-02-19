package org.diploma.repository;

import org.diploma.model.PatientRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PatientRegistrationRepository extends JpaRepository<PatientRegistration,Integer> {

    @Query("SELECT MAX(m.id) FROM PatientRegistration m")
    Optional<Integer> findFirstByOrderByIdDesc();
}
