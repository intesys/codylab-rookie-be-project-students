package it.intesys.codylab.rookie.project.mapper;

import it.intesys.codylab.rookie.project.domain.Doctor;
import it.intesys.codylab.rookie.project.dto.DoctorDto;
import org.springframework.stereotype.Component;
@Component
public class DoctorMapper {

        public Doctor toEntity(DoctorDto entity){
            if(entity == null)
                return null;

            Doctor doctor = new Doctor();
            doctor.setId(entity.getId());
            doctor.setName(entity.getName());
            doctor.setSurname(entity.getSurname());
            doctor.setPhoneNumber(entity.getPhoneNumber());
            doctor.setAddress(entity.getAddress());
            doctor.setEmail(entity.getEmail());
            doctor.setAvatar(entity.getAvatar());
            doctor.setProfession(entity.getProfession());

            return doctor;
        }


    public DoctorDto toDto(Doctor entity){
        if(entity == null)
            return null;

        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setId(entity.getId());
        doctorDto.setName(entity.getName());
        doctorDto.setSurname(entity.getSurname());
        doctorDto.setEmail(entity.getEmail());

        return doctorDto;


    }
}
