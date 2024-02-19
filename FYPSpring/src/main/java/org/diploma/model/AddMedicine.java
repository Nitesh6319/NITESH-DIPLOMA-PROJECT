package org.diploma.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="add_medicine")
@Builder
@Data
public class AddMedicine {

    @Id
    private int id;
    private String medicineName;
    private Date startDate;
    private Date endDate;
    private String frequency;
    private java.sql.Time startTime; // Note: Using java.sql.Time for TIME data type
    private String notes;

    // Constructors
    public AddMedicine() {
    }

    public AddMedicine(int id, String medicineName, Date startDate, Date endDate, String frequency, java.sql.Time startTime, String notes) {
        this.id = id;
        this.medicineName = medicineName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.frequency = frequency;
        this.startTime = startTime;
        this.notes = notes;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public java.sql.Time getStartTime() {
        return startTime;
    }

    public void setStartTime(java.sql.Time startTime) {
        this.startTime = startTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    // toString method
    @Override
    public String toString() {
        return "AddMedicine{" +
                "id=" + id +
                ", medicineName='" + medicineName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", frequency='" + frequency + '\'' +
                ", startTime=" + startTime +
                ", notes='" + notes + '\'' +
                '}';
    }
}

