package it.intesys.codylab.rookie.project.api;

import it.intesys.codylab.rookie.project.domain.Doctor;
import it.intesys.codylab.rookie.project.dto.DoctorDTO;
import it.intesys.codylab.rookie.project.service.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoctorApi {
    public static final String PATH_DOCTOR = "/api/doctor";
    public static final String PATH_DOCTOR_ID = "/api/doctor/{id}";
    @Autowired
    DoctorService doctorService;

    Logger logger = LoggerFactory.getLogger(DoctorApi.class);

    @PostMapping(PATH_DOCTOR)
    DoctorDTO createDoctor(@RequestBody DoctorDTO doctorDTO) {
        logger.info("Creating doctor");
        return doctorService.createDoctor(doctorDTO);
    }

    @PutMapping(PATH_DOCTOR_ID)
    DoctorDTO updateDoctor(@PathVariable("id") Long id, @RequestBody DoctorDTO doctorDTO) {

        logger.info("Updating doctor id {}", id);
        doctorDTO.setId(id);
        return doctorService.updateDoctor(doctorDTO);
    }

    @GetMapping(PATH_DOCTOR_ID)
    DoctorDTO getDoctor(@PathVariable("id") Long id) {
        logger.info("Getting doctor id {}", id);

        return doctorService.getDoctor(id);

    }

    @DeleteMapping(PATH_DOCTOR_ID)
    void deleteDoctor(@PathVariable("id") Long id) {
        logger.info("Eliminating doctor id {}", id);

        doctorService.deleteDoctor(id);
    }

}
