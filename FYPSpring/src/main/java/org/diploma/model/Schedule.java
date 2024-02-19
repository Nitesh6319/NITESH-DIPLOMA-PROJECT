package org.diploma.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name="schedule")
@Builder
@Data
public class Schedule {

    @Id
    private int id;
    private String activity;
    private Date date;
    private Time startTime;

    // Default constructor
    public Schedule() {
    }

    // Constructor with all fields
    public Schedule(int id, String activity, Date date, Time startTime) {
        this.id = id;
        this.activity = activity;
        this.date = date;
        this.startTime = startTime;
    }

    // Getters and setters for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getters and setters for activity
    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    // Getters and setters for date
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // Getters and setters for startTime
    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }
}

