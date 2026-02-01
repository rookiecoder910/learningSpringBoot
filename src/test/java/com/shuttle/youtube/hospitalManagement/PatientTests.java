package com.shuttle.youtube.hospitalManagement;

import com.shuttle.youtube.hospitalManagement.entity.Patient;
import com.shuttle.youtube.hospitalManagement.repository.PatientRepository;
import com.shuttle.youtube.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTests {
    @Autowired
    private  PatientRepository patientRepository;
    @Autowired
    private PatientService patientService;
    @Test
    public void testPatientRepository() {
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);
        Patient p1 = new Patient();//p1 object is created
        patientRepository.save(p1);//repository.save() makes it persistent by registering it with the EntityManager
        // , causing Hibernate to insert it into the database
        // at transaction commit.repository.save() makes it persistent by
        // registering it with the EntityManager
        // , causing Hibernate to insert it into
        // the database at transaction commit.
    }
        @Test
                public void testTransactionMethods() {
                 Patient patient= patientService.getPatientById(1L);
                 System.out.println(patient);

    }
}
