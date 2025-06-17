package it.intesys.codylab.rookie.project.service;

import it.intesys.codylab.rookie.project.domain.Doctor;
import it.intesys.codylab.rookie.project.dto.DoctorDTO;
import it.intesys.codylab.rookie.project.exception.NotFound;
import it.intesys.codylab.rookie.project.mapper.DoctorMapper;
import it.intesys.codylab.rookie.project.repository.DoctorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    DoctorMapper doctorMapper;
    Logger logger = LoggerFactory.getLogger(DoctorService.class);

    public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = doctorMapper.toDomain(doctorDTO);
        doctorRepository.save(doctor);

        return doctorMapper.toDTO(doctor);
    }

    public DoctorDTO updateDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = doctorMapper.toDomain(doctorDTO);
        doctorRepository.save(doctor);
        return doctorMapper.toDTO(doctor);

    }

    public DoctorDTO getDoctor(Long id) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        if (doctorOptional.isPresent()) {
            Doctor doctor = doctorOptional.get();
            return doctorMapper.toDTO(doctor);
        }else {
            throw new NotFound(id, Doctor.class);
        }
    }

    public void deleteDoctor(Long id) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        if (doctorOptional.isPresent()) {
            doctorRepository.deleteDoctorById(id);
        }else {
            throw new NotFound(id, Doctor.class);
        }

    }
}
