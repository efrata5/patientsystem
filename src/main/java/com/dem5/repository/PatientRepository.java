package com.dem5.repository;

import com.dem5.entity.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PatientRepository extends JpaRepository<Patients,Long> {
    Patients findBypatientName(String patientName);


}
