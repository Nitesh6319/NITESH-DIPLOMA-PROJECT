package org.diploma.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.diploma.model.CaregiverLogin;
import org.diploma.model.CaregiverRegistration;
import org.diploma.repository.CaregiverRegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CaregiverRegistrationService {

    private final CaregiverRegistrationRepository caregiverRegistrationRepository;

    public void createCaregiverRegistration(CaregiverRegistration caregiverRegistration) {

        Optional<Integer> highestId = caregiverRegistrationRepository.findFirstByOrderByIdDesc();
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
            caregiverRegistration.setId(i1);
        }
        else{
            i1=i1+1;
            log.info("Id incremented to  {}",i1);
            caregiverRegistration.setId(i1);
        }



        CaregiverRegistration registration = CaregiverRegistration.builder()
                .id(caregiverRegistration.getId())
                .firstName(caregiverRegistration.getFirstName())
                .lastName(caregiverRegistration.getLastName())
                .patientId(caregiverRegistration.getPatientId())
                .caregiverId(caregiverRegistration.getCaregiverId())
                .phone(caregiverRegistration.getPhone())
                .email(caregiverRegistration.getEmail())
                .password(caregiverRegistration.getPassword())
                .confirmPassword(caregiverRegistration.getConfirmPassword())
                .build();

        caregiverRegistrationRepository.save(registration);

        log.info("Caregiver Registration {} is saved with ID: {}", registration.getEmail(), registration.getId());
    }

    public List<CaregiverRegistration> getAllCaregiverRegistrations() {
        List<CaregiverRegistration> registrations = caregiverRegistrationRepository.findAll();
        log.info("Caregiver Registration Count: {}", registrations.size());
        return registrations;
    }


}

