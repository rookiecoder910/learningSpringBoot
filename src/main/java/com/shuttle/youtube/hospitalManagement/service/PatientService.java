package com.shuttle.youtube.hospitalManagement.service;

import com.shuttle.youtube.hospitalManagement.entity.Patient;
import com.shuttle.youtube.hospitalManagement.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
 private final PatientRepository patientRepository;
 public Patient getPatientById(Long id) {
     Patient p1=patientRepository.findById(id)
             .orElseThrow(() -> new RuntimeException("Patient not found!"));
     Patient p2=patientRepository.findById(id)
             .orElseThrow(() -> new RuntimeException("Patient not found!"));
 return p1;

 }
}
