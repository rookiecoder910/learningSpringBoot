package com.shuttle.youtube.hospitalManagement.repository;

import com.shuttle.youtube.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.shuttle.youtube.hospitalManagement.entity.Patient;
import com.shuttle.youtube.hospitalManagement.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByName(String name);

    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);

    List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);

    List<Patient> findByNameContainingOrderByIdDesc(String query);

    @Query("SELECT p FROM Patient p where p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("select p from Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

    @Query("select new com.shuttle.youtube.hospitalManagement.dto.BloodGroupCountResponseEntity( p.bloodGroup ,Count(p)) from Patient p group by p.bloodGroup")
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();



    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = :name where p.id = :id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);
}

