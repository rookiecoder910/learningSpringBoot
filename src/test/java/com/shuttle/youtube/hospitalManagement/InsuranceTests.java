package com.shuttle.youtube.hospitalManagement;

import com.shuttle.youtube.hospitalManagement.entity.Insurance;
import com.shuttle.youtube.hospitalManagement.entity.Patient;
import com.shuttle.youtube.hospitalManagement.repository.InsuranceRepository;
import com.shuttle.youtube.hospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTests {
    @Autowired
    private InsuranceService insuranceService;
    @Test
    public void testInsurance() {
       Insurance insurance = Insurance.builder()
               .policyNumber("HDFC_1234")
               .provider("HDFC")
               .validUntil(LocalDate.of(2030,12,20))
               .build();
       Patient patient=insuranceService.assignInsuranceToPatient(insurance,1L);
       System.out.println(patient);
    }
}
//There are 2 types of domains -DATA DOMAIN(PARENT,CHILD) AND JPA DOMAIN(OWNING,INVERSE)
