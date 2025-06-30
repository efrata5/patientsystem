package com.dem5.services;

import com.dem5.entity.Patients;
import com.dem5.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PatientServices {
    private final PatientRepository patientRepository;

    public PatientServices(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patients> findAll() {
        return patientRepository.findAll();
    }

    public Patients saved(Patients patients) {
        return patientRepository.save(patients);
    }
}
