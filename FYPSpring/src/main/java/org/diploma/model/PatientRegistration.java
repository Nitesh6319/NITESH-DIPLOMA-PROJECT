package org.diploma.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="login_patient")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientRegistration {

    @Id
    private int id;
    private String patientId;
    private String email;
    private String password;


}

