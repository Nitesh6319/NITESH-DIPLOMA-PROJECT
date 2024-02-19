package org.diploma.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.diploma.model.Registration;
import org.diploma.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RegistrationService {

    private final RegistrationRepository registrationRepository;

    public void createRegistration(Registration registration) {

        Optional<Integer> highestId = registrationRepository.findFirstByOrderByIdDesc();
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
            registration.setId(i1);
        }
        else{
            i1=i1+1;
            log.info("Id incremented to  {}",i1);
            registration.setId(i1);
        }

        /*private int id;
        private String firstName;
        private String lastName;
        private int Patientid;
        private String phone;
        private String email;
        private String password;
        private String confirmPassword;*/


        Registration reg = Registration.builder()
                .id(registration.getId())
                .firstName(registration.getFirstName())
                .lastName(registration.getLastName())
                .patientId(registration.getPatientid())
                .phone(registration.getPhone())
                .email(registration.getEmail())
                .password(registration.getPassword())
                .confirmPassword(registration.getConfirmPassword())
                .build();

        log.info(registration.getPatientid());

        //registrationRepository.save(reg);

        log.info("Registration {} {} is saved with ID: {}", reg.getFirstName(), reg.getLastName(), reg.getId());
    }

    public List<Registration> getAllRegistrations() {
        List<Registration> registrations = registrationRepository.findAll();
        log.info("Registration Count: {}", registrations.size());
        return registrations;
    }
}
