package org.diploma.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.diploma.model.DietPlan;
import org.diploma.repository.DietPlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DietPlanService {

    private final DietPlanRepository dietPlanRepository;

    public void createDietPlan(DietPlan dietPlan) {


        Optional<Integer> highestId = dietPlanRepository.findFirstByOrderByIdDesc();
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
            dietPlan.setId(i1);
        }
        else{
            i1=i1+1;
            log.info("Id incremented to  {}",i1);
            dietPlan.setId(i1);
        }

        DietPlan plan = DietPlan.builder()
                .id(dietPlan.getId())
                .dietDescription(dietPlan.getDietDescription())
                .dietName(dietPlan.getDietName())
                .healthyFats(dietPlan.getHealthyFats())
                .nutrientRichFoods(dietPlan.getNutrientRichFoods())
                .omega3FattyAcids(dietPlan.getOmega3FattyAcids())
                .vitaminMineralRichFoods(dietPlan.getVitaminMineralRichFoods())
                .waterIntake(dietPlan.getWaterIntake())
                .build();

        dietPlanRepository.save(plan);

        log.info("Diet Plan {} is saved with ID: {}", plan.getDietName(), plan.getId());
    }

    public List<DietPlan> getAllDietPlans() {
        List<DietPlan> plans = dietPlanRepository.findAll();
        log.info("Diet Plan Count: {}", plans.size());
        return plans;
    }

    public void deleteByID(DietPlan dietPlan){

        dietPlanRepository.deleteById(dietPlan.getId());
        log.info("Deleted Medicine by id: {}",dietPlan.getId());
    }
}
