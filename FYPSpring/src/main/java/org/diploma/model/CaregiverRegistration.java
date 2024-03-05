package org.diploma.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="caregiver_registration")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaregiverRegistration {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String patientId;
    private String caregiverId;
    private String phone;
    private String email;
    private String password;
    private String confirmPassword;


}


