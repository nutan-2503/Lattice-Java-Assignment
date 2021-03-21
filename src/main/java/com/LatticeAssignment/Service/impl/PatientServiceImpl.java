package com.LatticeAssignment.Service.impl;

import com.LatticeAssignment.Model.PatientDetails;
import com.LatticeAssignment.Repository.PatientRepository;
import com.LatticeAssignment.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.text.ParseException;
import java.util.List;

public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    // saves new patient record in database
    public PatientDetails createPatient(PatientDetails patientDetails) {
        patientRepository.save(patientDetails);
        return patientDetails;
    }

    // returns patient record corresponding to given id
    public PatientDetails displayPatientbyId(int id) {
        PatientDetails patientDetails=patientRepository.findById(id).orElse(null);
        return patientDetails;
    }

    // returns all records sorted according to appointment date
    public List<PatientDetails> displayPatient() {
        List<PatientDetails> patients= patientRepository.findAll(Sort.by("dateObj").ascending());
        return patients;
    }

    // Update Patient Record, given patient->name
    public PatientDetails updatePatientbyName(String name, PatientDetails patientDetails) throws ParseException{
        PatientDetails patient=patientRepository.findbyName(name);
        patient.setName(patientDetails.getName());
        patient.setEmail(patientDetails.getEmail());
        patient.setAddress(patientDetails.getAddress());
        patient.setPassword(patientDetails.getPassword());
        patient.setPhone(patientDetails.getPhone());
        patient.setAppointmentDate(patientDetails.getAppointmentDate());
        patient.setDateObj(patientDetails.getAppointmentDate());
        return patientRepository.save(patient);
    }

    // Update Patient record, given patient-> id
    public PatientDetails updatePatientbyId(int id, PatientDetails patientDetails) throws ParseException{
        PatientDetails patient=patientRepository.findById(id).orElse(null);
        patient.setName(patientDetails.getName());
        patient.setEmail(patientDetails.getEmail());
        patient.setAddress(patientDetails.getAddress());
        patient.setPassword(patientDetails.getPassword());
        patient.setPhone(patientDetails.getPhone());
        patient.setAppointmentDate(patientDetails.getAppointmentDate());
        patient.setDateObj(patientDetails.getAppointmentDate());
        return patientRepository.save(patient);
    }

    // deletes patient record for patient with name-> "name"
    public PatientDetails deletePatientbyName(String name) {
        PatientDetails patientDetails=patientRepository.findbyName(name);
        patientRepository.delete(patientDetails);
        return patientDetails;
    }

    // deleted patient for the patient with id-> "id"
    public PatientDetails deletePatientbyId(int id) {
        PatientDetails patientDetails=patientRepository.findById(id).orElse(null);
        patientRepository.delete(patientDetails);
        return patientDetails;
    }

    // sets appointment date for the patient with id-> "id"
    public PatientDetails setAppointementDatebyId(int id, String appointmentDate) throws ParseException {
        PatientDetails patientDetails=patientRepository.findById(id).orElse(null);
        patientDetails.setAppointmentDate(appointmentDate);
        patientDetails.setDateObj(appointmentDate);
        return patientRepository.save(patientDetails);
    }
}
