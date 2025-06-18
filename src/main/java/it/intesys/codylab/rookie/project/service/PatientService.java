package it.intesys.codylab.rookie.project.service;

import it.intesys.codylab.rookie.project.domain.Patient;
import it.intesys.codylab.rookie.project.dto.PatientDTO;
import it.intesys.codylab.rookie.project.exception.NotFound;
import it.intesys.codylab.rookie.project.mapper.PatientMapper;
import it.intesys.codylab.rookie.project.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    PatientMapper patientMapper;
    Logger logger = LoggerFactory.getLogger(PatientService.class);

    public PatientDTO createPatient(PatientDTO patientDTO) {
        Patient patient = patientMapper.toDomain(patientDTO);
        Instant now = Instant.now();
        patient.setLastAdmission(now);
        patientRepository.save(patient);

        return patientMapper.toDTO(patient);
    }

    public PatientDTO updatePatient(PatientDTO patientDTO) {
        Patient patient = patientMapper.toDomain(patientDTO);
        Instant now = Instant.now();
        patient.setLastAdmission(now);
        patientRepository.save(patient);
        return patientMapper.toDTO(patient);

    }

    /*public PatientDTO getPatient(Long id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent()) {
            Patient patient = patientOptional.get();
            return patientMapper.toDTO(patient);
        }else {
            throw new NotFound(id, Patient.class);
        }
    }

    public void deletePatient(Long id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent()) {
            patientRepository.deletePatientById(id);
        }else {
            throw new NotFound(id, Patient.class);
        }

    }*/
}
