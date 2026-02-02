package com.shuttle.youtube.hospitalManagement.service;

import com.shuttle.youtube.hospitalManagement.entity.Insurance;
import com.shuttle.youtube.hospitalManagement.entity.Patient;
import com.shuttle.youtube.hospitalManagement.repository.InsuranceRepository;
import com.shuttle.youtube.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;
    public Patient assignInsuranceToPatient(Insurance insurance,Long patientId) {
            Patient patient = patientRepository.findById(patientId).orElseThrow(()->new EntityNotFoundException("Patient not found"));
            patient.setInsurance(insurance);
            insurance.setPatient(patient); //bidirectional consistency maintain rhe
        return patient;
    }
}
