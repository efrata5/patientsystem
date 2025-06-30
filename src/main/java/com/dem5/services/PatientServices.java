package com.dem5.services;

import com.dem5.model.Patients;
import com.dem5.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Patients> findById(Long id) {
        return patientRepository.findById(id);
    }

    public Patients findBypatientName(String patientName) {
        return patientRepository.findBypatientName(patientName);
    }

    public Patients updatepatients(Patients patients) {
        return patientRepository.save(patients);
    }



    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }
}
