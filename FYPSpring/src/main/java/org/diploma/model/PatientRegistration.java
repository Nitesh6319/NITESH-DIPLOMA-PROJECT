package org.diploma.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="login_patient")
@Builder
@Data
public class PatientRegistration {

    @Id
    private int id;
    private String patientId;
    private String email;
    private String password;

    // Constructors
    public PatientRegistration() {
    }

    public PatientRegistration(int id, String patientId, String email, String password) {
        this.id = id;
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
        return "PatientRegistration{" +
                "id=" + id +
                ", patientId='" + patientId + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

