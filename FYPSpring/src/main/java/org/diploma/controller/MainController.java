package org.diploma.controller;


import lombok.RequiredArgsConstructor;
import org.diploma.model.*;
import org.diploma.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/healthcare")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MainController {


    private final MedicineService medicineService;
    private final CareGiverLoginService careGiverLoginService;
    private final CaregiverRegistrationService caregiverRegistrationService;
    private final DietPlanService dietPlanService;
    private final PatientRegistrationService patientRegistrationService;
    private final RegistrationService registrationService;
    private final ReminderService reminderService;
    private final ScheduleService scheduleService;

    @PostMapping("/addmedicine")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody AddMedicine addMedicine) {
        medicineService.createOrder(addMedicine);
    }


    @GetMapping("/addmedicine")
    @ResponseStatus(HttpStatus.OK)
    public List<AddMedicine> getAllMedicines()
    {
        return medicineService.getAllMedicines();
    }

    @PostMapping("/deletemedicine")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMedicinebyID(@RequestBody AddMedicine addMedicine){
        medicineService.deleteByID(addMedicine);
    }


    @PostMapping("/addcaregiverlogin")
    @ResponseStatus(HttpStatus.CREATED)
    public void createcaregiverlogin(@RequestBody CaregiverLogin addCaregiverLogin) {
        careGiverLoginService.createcaregiverlogindetail(addCaregiverLogin);
    }


    @GetMapping("/addcaregiverlogin")
    @ResponseStatus(HttpStatus.OK)
    public List<CaregiverLogin> getAllCaregiver()
    {
        return careGiverLoginService.getAllCaregiver();
    }

    @PostMapping("/addcaregiverregister")
    @ResponseStatus(HttpStatus.CREATED)
    public void createcaregiverregister(@RequestBody CaregiverRegistration caregiverRegistration) {
        caregiverRegistrationService.createCaregiverRegistration(caregiverRegistration);
    }


    @GetMapping("/addcaregiverregister")
    @ResponseStatus(HttpStatus.OK)
    public List<CaregiverRegistration> getAllCaregiverregistered()
    {
        return caregiverRegistrationService.getAllCaregiverRegistrations();
    }

    @PostMapping("/adddietplan")
    @ResponseStatus(HttpStatus.CREATED)
    public void createcaregiverregister(@RequestBody DietPlan dietPlan) {
        dietPlanService.createDietPlan(dietPlan);
    }


    @GetMapping("/adddietplan")
    @ResponseStatus(HttpStatus.OK)
    public List<DietPlan> getAllDietPlans() {return dietPlanService.getAllDietPlans();}


    @PostMapping("/deletedietplan")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDietbyID(@RequestBody DietPlan dietPlan) {dietPlanService.deleteByID(dietPlan);}


    @PostMapping("/patientregister")
    @ResponseStatus(HttpStatus.CREATED)
    public void createpatientregister(@RequestBody PatientRegistration patientRegistration) {
        patientRegistrationService.createPatientRegistration(patientRegistration);
    }


    @GetMapping("/patientregister")
    @ResponseStatus(HttpStatus.OK)
    public List<PatientRegistration> getAllRegisteredPatients()
    {
        return patientRegistrationService.getAllPatientRegistrations();
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void createregister(@RequestBody Registration registration) {
        registrationService.createRegistration(registration);
    }

    @GetMapping("/authenticate")
    @ResponseStatus(HttpStatus.FOUND)
    public String authenticationcheck(@RequestBody Registration registration)
    {
        if(registrationService.userAuthentication(registration))
            return "Authorized";
        else
            return "Unauthorized";
    }

    @GetMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public List<Registration> getAllRegistered()
    {
        return registrationService.getAllRegistrations();
    }

    @PostMapping("/reminder")
    @ResponseStatus(HttpStatus.CREATED)
    public void createreminder(@RequestBody Reminder reminder) {
        reminderService.createReminder(reminder);
    }

    @PostMapping("/deletereminder")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReminderbyID(@RequestBody Reminder reminder) {reminderService.deleteByID(reminder);}


    @GetMapping("/reminder")
    @ResponseStatus(HttpStatus.OK)
    public List<Reminder> getAllReminder()
    {
        return reminderService.getAllReminders();
    }

    @PostMapping("/schedule")
    @ResponseStatus(HttpStatus.CREATED)
    public void createschedule(@RequestBody Schedule schedule) {
        scheduleService.createSchedule(schedule);
    }


    @PostMapping("/deleteschedule")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSchedulebyID(@RequestBody Schedule schedule) {
        scheduleService.deleteByID(schedule);
    }


    @GetMapping("/schedule")
    @ResponseStatus(HttpStatus.OK)
    public List<Schedule> getAllSchedule()
    {
        return scheduleService.getAllSchedules();
    }



}
