package it.intesys.codylab.rookie.project.repository;

import it.intesys.codylab.rookie.project.domain.Patient;
import it.intesys.codylab.rookie.project.dto.BloodGroupDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

@Repository
public class PatientRepository implements RookieRepository<Patient> {
    @Autowired
    JdbcTemplate jdbcTemplate;
    Logger logger = LoggerFactory.getLogger(PatientRepository.class);


    public Patient save(Patient patient) {

        if (patient.getId() == null) {
            Instant lastAdmission = patient.getLastAdmission();
            BloodGroupDto bloodGroupDto = BloodGroupDto.A_MINUS;
            String bloodType = bloodGroupDto.name();
            Long id = jdbcTemplate.queryForObject("select nextval ('patient_id_generator')", Long.class);

            patient.setId(id);
            jdbcTemplate.update("""
                insert into patient(id, opd, idp, name, surname, phone_number, address, email, avatar, blood_group,
                 notes, chronic_patient, last_admission, last_doctor_visited_id)
                values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)""",
                patient.getId(), patient.getOpd(), patient.getIdp(), patient.getName(), patient.getSurname()
                , patient.getPhoneNumber(), patient.getAddress(), patient.getEmail(), patient.getAvatar()
                , bloodType, patient.getNotes(), patient.isChronicPatient(), Timestamp.from(lastAdmission)
                , patient.getLastDoctorVisitedId());
            logger.info("Patient created with id {}", patient.getId());
            return patient;
        }else {
            Instant lastAdmission = patient.getLastAdmission();
            jdbcTemplate.update("""
                    update patient set
                            opd = ?,
                            idp = ?,
                            name = ?,
                            surname = ?,
                            phone_number = ?,
                            address = ?,
                            email = ?,
                            avatar = ?,
                            blood_group = ?,
                            notes = ?,
                            chronic_patient = ?,
                            last_admission = ?,
                            last_doctor_visited_id = ?
                    where
                        id = ?""",
                    patient.getOpd(), patient.getIdp(), patient.getName(), patient.getSurname(), patient.getPhoneNumber()
                    , patient.getAddress(), patient.getEmail(), patient.getAvatar(),patient.getBloodGroup()
                    , patient.getNotes(), patient.isChronicPatient(), Timestamp.from(lastAdmission)
                    , patient.getLastDoctorVisitedId(), patient.getId());
            return patient;
        }

    }

    /*public Optional<Patient> findById(Long id) {
        try {
            Patient patient = findById0(id);
            return Optional.ofNullable(patient);
        }catch(EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    private Patient findById0(Long id) {
        return jdbcTemplate.queryForObject("select * from patient where id = ?", this, id);
    }


    @Override
    public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
        Patient patient = new Patient();
        patient.setId(rs.getLong("id"));
        patient.setName(rs.getString("name"));
        patient.setSurname(rs.getString("surname"));
        patient.setPhoneNumber(rs.getString("phone_number"));
        patient.setAddress(rs.getString("address"));
        patient.setEmail(rs.getString("email"));
        patient.setAvatar(rs.getString("avatar"));
        patient.setProfession(rs.getString("profession"));
        return patient;

    }*/

    public void deletePatientById(Long id) {
        int count = jdbcTemplate.update("delete from patient where id = ?", id);
        idNotFound(count, id);

    }
    private static void idNotFound(int count, Long id) {
        if (count == 0) {
            throw new RuntimeException("Patient with id" + id + " not found or doesn't exist");
        }
    }
}
