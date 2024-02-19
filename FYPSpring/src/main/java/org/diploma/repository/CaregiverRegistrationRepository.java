package org.diploma.repository;


import org.diploma.model.CaregiverRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CaregiverRegistrationRepository extends JpaRepository<CaregiverRegistration,Integer> {

    @Query("SELECT MAX(m.id) FROM CaregiverRegistration m")
    Optional<Integer> findFirstByOrderByIdDesc();
}
