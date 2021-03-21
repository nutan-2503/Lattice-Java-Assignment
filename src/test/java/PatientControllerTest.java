import com.LatticeAssignment.Controller.PatientController;
import com.LatticeAssignment.Model.PatientDetails;
import com.LatticeAssignment.Service.PatientService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PatientControllerTest {
    private PatientController patientController;
    private PatientService patientService;

    @BeforeEach
    public void setup() {
        patientService=mock(PatientService.class);
        patientController=new PatientController(patientService);
    }

    @AfterEach
    void tearDown() {
        patientService=null;
        patientController=null;
    }

    @Test
    public void createPatientforSuccess() {
        PatientDetails patientDetails=createPatientRecord();
        System.out.println(patientDetails);
        Object res=patientController.createPatient(patientDetails).getBody();
        System.out.println(res);
        assertFalse(res!=null);
    }

    @Test
    public void setAppointment() throws ParseException {
        PatientDetails patientDetails=createPatientRecord();
        patientDetails.setAppointmentDate("22-03-2021");
        patientDetails.setDateObj(patientDetails.getAppointmentDate());
        when(patientController.setDate(0,"22-03-2021")).thenReturn(patientDetails);
        assertTrue(patientDetails!=null);
    }

    public PatientDetails createPatientRecord() {
        PatientDetails patientDetails=new PatientDetails();
        patientDetails.setName("Nutan Hotwani");
        patientDetails.setAddress("Asansolllll");
        patientDetails.setEmail("nutanhotwani02@gmail.com");
        patientDetails.setPhone("+91 8001467249");
        patientDetails.setPassword("nutan123N");
        return patientDetails;
    }
}
