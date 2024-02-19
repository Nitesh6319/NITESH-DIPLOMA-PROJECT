package org.diploma.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="diet_plan")
@Builder
@Data
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

    // Constructors
    public DietPlan() {
    }

    public DietPlan(int id, String dietDescription, String dietName, String healthyFats, String nutrientRichFoods,
                    String omega3FattyAcids, String vitaminMineralRichFoods, int waterIntake) {
        this.id=id;
        this.dietDescription = dietDescription;
        this.dietName = dietName;
        this.healthyFats = healthyFats;
        this.nutrientRichFoods = nutrientRichFoods;
        this.omega3FattyAcids = omega3FattyAcids;
        this.vitaminMineralRichFoods = vitaminMineralRichFoods;
        this.waterIntake = waterIntake;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDietDescription() {
        return dietDescription;
    }

    public void setDietDescription(String dietDescription) {
        this.dietDescription = dietDescription;
    }

    public String getDietName() {
        return dietName;
    }

    public void setDietName(String dietName) {
        this.dietName = dietName;
    }

    public String getHealthyFats() {
        return healthyFats;
    }

    public void setHealthyFats(String healthyFats) {
        this.healthyFats = healthyFats;
    }

    public String getNutrientRichFoods() {
        return nutrientRichFoods;
    }

    public void setNutrientRichFoods(String nutrientRichFoods) {
        this.nutrientRichFoods = nutrientRichFoods;
    }

    public String getOmega3FattyAcids() {
        return omega3FattyAcids;
    }

    public void setOmega3FattyAcids(String omega3FattyAcids) {
        this.omega3FattyAcids = omega3FattyAcids;
    }

    public String getVitaminMineralRichFoods() {
        return vitaminMineralRichFoods;
    }

    public void setVitaminMineralRichFoods(String vitaminMineralRichFoods) {
        this.vitaminMineralRichFoods = vitaminMineralRichFoods;
    }

    public int getWaterIntake() {
        return waterIntake;
    }

    public void setWaterIntake(int waterIntake) {
        this.waterIntake = waterIntake;
    }

    // toString method
    @Override
    public String toString() {
        return "DietPlan{" +
                "id=" + id +
                ", dietDescription='" + dietDescription + '\'' +
                ", dietName='" + dietName + '\'' +
                ", healthyFats='" + healthyFats + '\'' +
                ", nutrientRichFoods='" + nutrientRichFoods + '\'' +
                ", omega3FattyAcids='" + omega3FattyAcids + '\'' +
                ", vitaminMineralRichFoods='" + vitaminMineralRichFoods + '\'' +
                ", waterIntake=" + waterIntake +
                '}';
    }
}


