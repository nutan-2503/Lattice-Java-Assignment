package com.LatticeAssignment.Controller;

import com.LatticeAssignment.Model.PatientDetails;
import com.LatticeAssignment.Service.PatientService;
import com.LatticeAssignment.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;
    private ValidationUtil validator;

    public PatientController(PatientService patientService) {
        this.patientService=patientService;
    }

    // POST Mapping-> create new patient record
    @RequestMapping(value = "/api/create", method = {RequestMethod.POST})
    public ResponseEntity<?> createPatient(@Valid @RequestBody PatientDetails patientDetails) {
        // password validation
        if(!validator.passwordVal(patientDetails.getPassword()))
            return ResponseEntity.badRequest().body("Enter Valid password");

        PatientDetails patient=patientService.createPatient(patientDetails);
        return ResponseEntity.ok().body(patient);
    }

    // GET Mapping-> get patient record by id
    @RequestMapping(value = "/api/fetchDetails/{id}", method = {RequestMethod.GET})
    public ResponseEntity<?> getDetails(@PathVariable int id) {
        PatientDetails patient=patientService.displayPatientbyId(id);
        return ResponseEntity.ok(). body(patient);
    }

    // GET Mapping-> get all patients in ascending order by appointment date
    @RequestMapping(value = "/api/fetchDetails", method = {RequestMethod.GET})
    public ResponseEntity<?> getEntireDetails() {
        List<PatientDetails> record=patientService.displayPatient();
        return ResponseEntity.ok().body(record);
    }

    // PUT Mapping-> modify patient record, given original id
    @RequestMapping(value = "/api/modifybyID/{id}", method = {RequestMethod.PUT})
    public ResponseEntity<?> modifybyID(@PathVariable int id, @Valid @RequestBody PatientDetails patientDetails) {
        try {
            // password validation
            if(!validator.passwordVal(patientDetails.getPassword()))
                return ResponseEntity.badRequest().body("Enter Valid password");

            PatientDetails patient = patientService.updatePatientbyId(id, patientDetails);
            return ResponseEntity.ok().body(patient);
        }
        catch (ParseException pe) {
            return ResponseEntity.badRequest().body("Given id does not exist");
        }
    }

    // PUT Mapping-> modify patient record, given original name
    @RequestMapping(value = "/api/modifybyName/{name}", method = {RequestMethod.PUT})
    public ResponseEntity<?> modifybyName(@PathVariable String name, @Valid @RequestBody PatientDetails patientDetails) {
        try {
            // password validation
            if(!validator.passwordVal(patientDetails.getPassword()))
                return ResponseEntity.badRequest().body("Enter Valid password");

            PatientDetails patient=patientService.updatePatientbyName(name, patientDetails);
            return ResponseEntity.ok().body(patient);
        }
        catch (ParseException pe) {
            return ResponseEntity.badRequest().body("Given name does not exist");
        }
    }

    // DELETE Mapping-> delete patient record, given id
    @RequestMapping(value = "/api/deletebyID/{id}", method = {RequestMethod.DELETE})
    public ResponseEntity<?> deletebyID(@PathVariable int id) {
        PatientDetails patientDetails=patientService.deletePatientbyId(id);
        return ResponseEntity.ok().body(patientDetails);
    }

    // DELETE Mapping-> delete patient record, given patient name
    @RequestMapping(value = "/api/deletebyName/{name}", method = {RequestMethod.DELETE})
    public ResponseEntity<?> deletebyName(@PathVariable String name) {
        PatientDetails patientDetails=patientService.deletePatientbyName(name);
        return ResponseEntity.ok().body(patientDetails);
    }

    // PUT Mapping-> set appointment date, given patient id
    @RequestMapping(value = "/api/setDate/{id}", method = {RequestMethod.PUT})
    public ResponseEntity<?> setDate(@PathVariable int id, @RequestParam String date) {
        try {
            PatientDetails patientDetails = patientService.setAppointementDatebyId(id, date);
            return ResponseEntity.ok().body(patientDetails);
        }
        catch (ParseException pe) {
            return ResponseEntity.badRequest().body("Enter a valid ID");
        }
    }
}
