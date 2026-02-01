package com.shuttle.youtube.hospitalManagement.repository;

import com.shuttle.youtube.hospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    Patient findByName(String kleinMoretti);
}
