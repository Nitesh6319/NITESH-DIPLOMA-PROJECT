package org.diploma.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.diploma.model.AddMedicine;
import org.diploma.repository.AddMedicineRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MedicineService {


    private final AddMedicineRepository addMedicineRepository;
    public void createOrder(AddMedicine medicineaddition) {

        // Get the highest existing ID
        Optional<Integer> highestId = addMedicineRepository.findFirstByOrderByIdDesc();
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
            medicineaddition.setId(i1);
        }
        else{
            i1=i1+1;
            log.info("Id incremented to  {}",i1);
            medicineaddition.setId(i1);
        }



        AddMedicine add1 = AddMedicine.builder().
                id(medicineaddition.getId()).
                medicineName(medicineaddition.getMedicineName()).
                startDate(medicineaddition.getStartDate()).
                endDate(medicineaddition.getEndDate()).
                frequency(medicineaddition.getFrequency()).
                startTime(medicineaddition.getStartTime()).
                notes(medicineaddition.getNotes()).build();

        addMedicineRepository.save(add1);

        log.info("Medicine {}  is saved with ID: {}", medicineaddition.getMedicineName(),medicineaddition.getId()); //slf4j will inject it into {}



    }

    public List<AddMedicine> getAllMedicines() {
        // TODO Auto-generated method stub
        List<AddMedicine> orders = addMedicineRepository.findAll();
        log.info("Medicine Count: {}",orders.size());
        return orders;
    }

    public void deleteByID(AddMedicine medicineaddition){

        addMedicineRepository.deleteById(medicineaddition.getId());
        log.info("Deleted Medicine by id: {}",medicineaddition.getId());
    }


}
