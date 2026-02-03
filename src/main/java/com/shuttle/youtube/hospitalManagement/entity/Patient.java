package com.shuttle.youtube.hospitalManagement.entity;

import com.shuttle.youtube.hospitalManagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(
        name = "patient",
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private String email;


    @Column(nullable = false)
    private String gender;

    @Enumerated(EnumType.STRING)

    private BloodGroupType bloodGroup;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "patient_insurance_id")
    private Insurance insurance;       //owning side is the one with foreign key
    @OneToMany(mappedBy = "patient")
    @ToString.Exclude //
    private List<Appointment> appointment;
}
