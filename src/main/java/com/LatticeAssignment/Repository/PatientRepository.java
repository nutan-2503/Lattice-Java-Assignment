package com.LatticeAssignment.Repository;

import com.LatticeAssignment.Model.PatientDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientDetails, Integer> {
    PatientDetails findbyName(String name);
}
