package com.shuttle.youtube.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;
    @OneToOne
    private Doctor headDoctor;
    @ManyToMany
    @JoinTable(
            name = "my_dpt_doctors"
            , joinColumns =
                    @JoinColumn(name = "dpt_id"),
             inverseJoinColumns = @JoinColumn(name = "doctor_id")


    )
    private Set<Doctor> doctors=new HashSet<>();
}
