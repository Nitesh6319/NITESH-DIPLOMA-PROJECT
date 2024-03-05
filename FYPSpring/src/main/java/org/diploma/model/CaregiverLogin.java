package org.diploma.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="caregiver_login")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaregiverLogin {

    @Id
    private int id;
    private String caregiverId;
    private String patientId;
    private String email;
    private String password;


}
