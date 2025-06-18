package it.intesys.codylab.rookie.project.mapper;

import it.intesys.codylab.rookie.project.domain.Patient;
import it.intesys.codylab.rookie.project.dto.PatientDTO;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {
    public Patient toDomain(PatientDTO patientDTO) {
        if(patientDTO == null) return null;

        Patient patient = new Patient();
        patient.setId(patientDTO.getId());
        patient.setOpd(patientDTO.getOpd());
        patient.setIdp(patientDTO.getIdp());
        patient.setName(patientDTO.getName());
        patient.setSurname(patientDTO.getSurname());
        patient.setPhoneNumber(patientDTO.getPhoneNumber());
        patient.setAddress(patientDTO.getAddress());
        patient.setEmail(patientDTO.getEmail());
        patient.setAvatar(patientDTO.getAvatar());
        patient.setBloodGroup(patientDTO.getBloodGroup());
        patient.setNotes(patientDTO.getNotes());
        patient.setChronicPatient(patientDTO.isChronicPatient());
        patient.setLastAdmission(patientDTO.getLastAdmission());
        patient.setLastDoctorVisitedId(patientDTO.getLastDoctorVisitedId());
        return patient;
    }
    public PatientDTO toDTO(Patient patient) {
        if(patient == null) return null;

        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patient.getId());
        patientDTO.setOpd(patient.getOpd());
        patientDTO.setIdp(patient.getIdp());
        patientDTO.setName(patient.getName());
        patientDTO.setSurname(patient.getSurname());
        patientDTO.setPhoneNumber(patient.getPhoneNumber());
        patientDTO.setAddress(patient.getAddress());
        patientDTO.setEmail(patient.getEmail());
        patientDTO.setAvatar(patient.getAvatar());
        patientDTO.setBloodGroup(patient.getBloodGroup());
        patientDTO.setNotes(patient.getNotes());
        patientDTO.setChronicPatient(patient.isChronicPatient());
        patientDTO.setLastAdmission(patient.getLastAdmission());
        patientDTO.setLastDoctorVisitedId(patient.getLastDoctorVisitedId());

        return patientDTO;
    }


}
