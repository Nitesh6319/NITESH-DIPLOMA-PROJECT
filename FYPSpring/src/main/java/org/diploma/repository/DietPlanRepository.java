package org.diploma.repository;

import org.diploma.model.DietPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DietPlanRepository extends JpaRepository<DietPlan,Integer> {

    @Query("SELECT MAX(m.id) FROM DietPlan m")
    Optional<Integer> findFirstByOrderByIdDesc();
}
