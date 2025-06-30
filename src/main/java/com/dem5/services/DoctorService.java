package com.dem5.services;

import com.dem5.entity.Doctor;
import com.dem5.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }



    public Doctor saved(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Optional<Doctor> findById(Long id) {
        return doctorRepository.findById(id);
    }


    public Doctor findBydoctorName(String doctorName) {
        return doctorRepository.findBydoctorName(doctorName);
    }
}
