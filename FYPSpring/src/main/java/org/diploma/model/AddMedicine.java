package org.diploma.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="add_medicine")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMedicine {

    @Id
    private int id;
    private String medicineName;
    private Date startDate;
    private Date endDate;
    private String frequency;
    private java.sql.Time startTime; // Note: Using java.sql.Time for TIME data type
    private String notes;


}

