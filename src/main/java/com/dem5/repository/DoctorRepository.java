package com.dem5.repository;

import com.dem5.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository




public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    Doctor findBydoctorName(String doctorName);
}
