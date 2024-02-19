package org.diploma.repository;

import org.diploma.model.AddMedicine;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AddMedicineRepository extends JpaRepository<AddMedicine,Integer> {

    @Query("SELECT MAX(m.id) FROM AddMedicine m")
    Optional<Integer> findFirstByOrderByIdDesc();

    void deleteById(int id);
}
