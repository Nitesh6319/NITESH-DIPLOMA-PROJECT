package org.diploma.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.diploma.model.AddMedicine;
import org.diploma.model.CaregiverLogin;
import org.diploma.model.Registration;
import org.diploma.repository.CareGiverLoginRepository;
import org.diploma.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CareGiverLoginService {

    private final CareGiverLoginRepository careGiverLoginRepository;

    public void createcaregiverlogindetail(CaregiverLogin CaregiverLogin) {

        Optional<Integer> highestId = careGiverLoginRepository.findFirstByOrderByIdDesc();
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
            CaregiverLogin.setId(i1);
        }
        else{
            i1=i1+1;
            log.info("Id incremented to  {}",i1);
            CaregiverLogin.setId(i1);
        }

        CaregiverLogin add1 = CaregiverLogin.builder().
                id(CaregiverLogin.getId()).
                caregiverId(CaregiverLogin.getCaregiverId()).
                patientId(CaregiverLogin.getPatientId()).
                email(CaregiverLogin.getEmail()).
                password(CaregiverLogin.getPassword())
                        .build();


        careGiverLoginRepository.save(add1);


        log.info("Caregiver {}  is saved with ID: {}", CaregiverLogin.getCaregiverId(),CaregiverLogin.getId()); //slf4j will inject it into {}



    }

    public List<CaregiverLogin> getAllCaregiver() {
        // TODO Auto-generated method stub
        List<CaregiverLogin> list = careGiverLoginRepository.findAll();
        log.info("CareGiver Count: {}",list.size());
        return list.stream().map(this::mapToCaregiverlogin).collect(Collectors.toList());
    }

    private CaregiverLogin mapToCaregiverlogin(CaregiverLogin member) {
        return CaregiverLogin.builder().
                id(member.getId()).
        caregiverId(member.getCaregiverId()).
                patientId(member.getPatientId()).
                email(member.getEmail()).
                password(member.getPassword())
                .build();
    }


}
