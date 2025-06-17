package it.intesys.codylab.rookie.project.mapper;

import it.intesys.codylab.rookie.project.domain.Doctor;
import it.intesys.codylab.rookie.project.dto.DoctorDTO;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {
    public Doctor toDomain(DoctorDTO doctorDTO) {
        if(doctorDTO == null) return null;

        Doctor doctor = new Doctor();
        doctor.setId(doctorDTO.getId());
        doctor.setName(doctorDTO.getName());
        doctor.setSurname(doctorDTO.getSurname());
        doctor.setPhoneNumber(doctorDTO.getPhoneNumber());
        doctor.setAddress(doctorDTO.getAddress());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setAvatar(doctorDTO.getAvatar());
        doctor.setProfession(doctorDTO.getProfession());

        return doctor;
    }
    public DoctorDTO toDTO(Doctor doctor) {
        if(doctor == null) return null;

        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setId(doctor.getId());
        doctorDTO.setName(doctor.getName());
        doctorDTO.setSurname(doctor.getSurname());
        doctorDTO.setPhoneNumber(doctor.getPhoneNumber());
        doctorDTO.setAddress(doctor.getAddress());
        doctorDTO.setEmail(doctor.getEmail());
        doctorDTO.setAvatar(doctor.getAvatar());
        doctorDTO.setProfession(doctor.getProfession());

        return doctorDTO;
    }


}
