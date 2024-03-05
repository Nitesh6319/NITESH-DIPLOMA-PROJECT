package org.diploma.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="reminder")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reminder {

    @Id
    private int id;
    private String title;
    private String description;


}

