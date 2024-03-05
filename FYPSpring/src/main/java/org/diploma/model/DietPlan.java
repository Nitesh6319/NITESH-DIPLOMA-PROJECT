package org.diploma.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="diet_plan")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DietPlan {

    @Id
    private int id;
    private String dietDescription;
    private String dietName;
    private String healthyFats;
    private String nutrientRichFoods;
    private String omega3FattyAcids;
    private String vitaminMineralRichFoods;
    private int waterIntake;


}


