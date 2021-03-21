package com.LatticeAssignment.Service;

import com.LatticeAssignment.Model.PatientDetails;

import java.text.ParseException;
import java.util.List;

public interface PatientService {
    PatientDetails createPatient(PatientDetails patientDetails);
    PatientDetails displayPatientbyId(int id);
    List<PatientDetails> displayPatient();
    PatientDetails updatePatientbyName(String name, PatientDetails patientDetails) throws ParseException;
    PatientDetails updatePatientbyId(int id, PatientDetails patientDetails) throws ParseException;
    PatientDetails deletePatientbyName(String name);
    PatientDetails deletePatientbyId(int id);
    PatientDetails setAppointementDatebyId(int id, String appointmentDate) throws ParseException;
}
