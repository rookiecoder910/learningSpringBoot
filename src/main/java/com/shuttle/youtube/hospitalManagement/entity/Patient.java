package com.shuttle.youtube.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@ToString
@Getter
@Setter
@Table(
        name = "patient_tbl",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "unique_patient_email",
                        columnNames = {"email"}
                ),
                @UniqueConstraint(
                        name = "unique_patient_name_birthdate",
                        columnNames = {"name", "birth_date"}
                )
        },
        indexes = {
                @Index(
                        name = "idx_patient_birth_date",
                        columnList = "birth_date"
                )
        }
)
public class Patient {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String name;
    private LocalDate birthDate;
    private String email;
    private String gender;

}
