package com.dem5.services;

import com.dem5.entity.Doctor;
import com.dem5.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }
}
