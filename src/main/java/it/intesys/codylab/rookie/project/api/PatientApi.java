package it.intesys.codylab.rookie.project.api;

import it.intesys.codylab.rookie.project.dto.PatientDTO;
import it.intesys.codylab.rookie.project.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientApi {
    public static final String PATH_PATIENT = "/api/patient";
    public static final String PATH_PATIENT_ID = "/api/patient/{id}";
    @Autowired
    PatientService patientService;

    Logger logger = LoggerFactory.getLogger(PatientApi.class);

    @PostMapping(PATH_PATIENT)
    PatientDTO createPatient(@RequestBody PatientDTO patientDTO) {
        logger.info("Creating patient");
        return patientService.createPatient(patientDTO);
    }

    @PutMapping(PATH_PATIENT_ID)
    PatientDTO updatePatient(@PathVariable("id") Long id, @RequestBody PatientDTO patientDTO) {

        logger.info("Updating patient id {}", id);
        patientDTO.setId(id);
        return patientService.updatePatient(patientDTO);
    }

    /*@GetMapping(PATH_PATIENT_ID)
    PatientDTO getPatient(@PathVariable("id") Long id) {
        logger.info("Getting patient id {}", id);

        return patientService.getPatient(id);

    }

    @DeleteMapping(PATH_PATIENT_ID)
    void deletePatient(@PathVariable("id") Long id) {
        logger.info("Eliminating patient id {}", id);

        patientService.deletePatient(id);
    }*/
    
}
