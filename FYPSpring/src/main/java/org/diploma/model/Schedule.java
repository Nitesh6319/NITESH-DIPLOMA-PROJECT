package org.diploma.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name="schedule")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {

    @Id
    private int id;
    private String activity;
    private Date date;
    private Time startTime;


}

