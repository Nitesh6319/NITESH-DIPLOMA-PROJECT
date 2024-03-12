package org.diploma.repository;

import org.diploma.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

    @Query("SELECT MAX(m.id) FROM Registration m")
    Optional<Integer> findFirstByOrderByIdDesc();

    @Query("SELECT r FROM Registration r WHERE r.phone = :phone")
    Registration findbyCredentials(@Param("phone") String phone);

}
