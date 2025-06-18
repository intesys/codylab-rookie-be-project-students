package it.intesys.codylab.rookie.project.mapper;

import it.intesys.codylab.rookie.project.domain.Doctor;
import it.intesys.codylab.rookie.project.dto.DoctorDto;

public class DoctorMapper {
    public Doctor toDomain(DoctorDto doctorDto){
        if(doctorDto == null)
            return null;

        Doctor doctor = new Doctor();
        doctor.setId(doctorDto.getId());
        doctor.setName(doctorDto.getName());
        doctor.setSurname(doctorDto.getSurname());
        doctor.setPhoneNumber(doctorDto.getPhoneNumber());
        doctor.setAddress(doctorDto.getAddress());
        doctor.setEmail(doctorDto.getEmail());
        doctor.setAddress(doctorDto.getAddress());
        doctor.setProfession(doctorDto.getProfession());

        return doctor;
    }

    public DoctorDto toDto(Doctor doctor){
        if(doctor == null)
            return null;

        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setId(doctor.getId());
        doctorDto.setName(doctor.getName());
        doctorDto.setSurname(doctor.getSurname());
        doctorDto.setPhoneNumber(doctor.getPhoneNumber());
        doctorDto.setAddress(doctor.getAddress());
        doctorDto.setEmail(doctor.getEmail());
        doctorDto.setAddress(doctor.getAddress());
        doctorDto.setProfession(doctor.getProfession());

        return doctorDto;
    }
}
