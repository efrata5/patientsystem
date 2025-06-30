package com.dem5.repository;

import com.dem5.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository




public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
