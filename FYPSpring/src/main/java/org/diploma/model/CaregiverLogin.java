package org.diploma.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="caregiver_login")
@Builder
@Data
public class CaregiverLogin {

    @Id
    private int id;
    private String caregiverId;
    private String patientId;
    private String email;
    private String password;

    // Constructors
    public CaregiverLogin() {
    }

    public CaregiverLogin(int id, String caregiverId, String patientId, String email, String password) {
        this.id = id;
        this.caregiverId = caregiverId;
        this.patientId = patientId;
        this.email = email;
        this.password = password;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaregiverId() {
        return caregiverId;
    }

    public void setCaregiverId(String caregiverId) {
        this.caregiverId = caregiverId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // toString method
    @Override
    public String toString() {
        return "CaregiverLogin{" +
                "id=" + id +
                ", caregiverId='" + caregiverId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
