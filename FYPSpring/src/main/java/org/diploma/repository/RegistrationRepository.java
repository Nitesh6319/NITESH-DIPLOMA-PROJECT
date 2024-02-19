package org.diploma.repository;

import org.diploma.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

    @Query("SELECT MAX(m.id) FROM Registration m")
    Optional<Integer> findFirstByOrderByIdDesc();

}
