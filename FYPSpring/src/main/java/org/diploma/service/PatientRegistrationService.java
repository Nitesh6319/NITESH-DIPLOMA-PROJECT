package org.diploma.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.diploma.model.PatientRegistration;
import org.diploma.repository.PatientRegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientRegistrationService {

    private final PatientRegistrationRepository patientRegistrationRepository;

    public void createPatientRegistration(PatientRegistration patientRegistration) {

        Optional<Integer> highestId = patientRegistrationRepository.findFirstByOrderByIdDesc();
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
            patientRegistration.setId(i1);
        }
        else{
            i1=i1+1;
            log.info("Id incremented to  {}",i1);
            patientRegistration.setId(i1);
        }

        PatientRegistration registration = PatientRegistration.builder()
                .id(patientRegistration.getId())
                .patientId(patientRegistration.getPatientId())
                .email(patientRegistration.getEmail())
                .password(patientRegistration.getPassword())
                .build();

        patientRegistrationRepository.save(registration);

        log.info("Patient Registration {} is saved with ID: {}", registration.getEmail(), registration.getId());
    }

    public List<PatientRegistration> getAllPatientRegistrations() {
        List<PatientRegistration> registrations = patientRegistrationRepository.findAll();
        log.info("Patient Registration Count: {}", registrations.size());
        return registrations;
    }
}

