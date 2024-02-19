package org.diploma.repository;


import org.diploma.model.AddMedicine;
import org.diploma.model.CaregiverLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CareGiverLoginRepository extends JpaRepository<CaregiverLogin,Integer> {

    @Query("SELECT MAX(m.id) FROM CaregiverLogin m")
    Optional<Integer> findFirstByOrderByIdDesc();

}
