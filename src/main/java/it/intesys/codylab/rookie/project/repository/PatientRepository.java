package it.intesys.codylab.rookie.project.repository;

import it.intesys.codylab.rookie.project.domain.Doctor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class DoctorRepository implements RookieRepository<Doctor>, RowMapper<Doctor> {
    @Autowired
    JdbcTemplate jdbcTemplate;
    Logger logger = LoggerFactory.getLogger(DoctorRepository.class);


    public Doctor save(Doctor doctor) {
        if (doctor.getId() == null) {
            Long id = jdbcTemplate.queryForObject("select nextval ('doctor_id_generator')", Long.class);

            doctor.setId(id);
            jdbcTemplate.update("""
                insert into doctor(id, name, surname, phone_number, address, email, avatar, profession)
                values (?,?,?,?,?,?,?,?)""",
                doctor.getId(), doctor.getName(), doctor.getSurname(), doctor.getPhoneNumber(),
                doctor.getAddress(), doctor.getEmail(), doctor.getAvatar(), doctor.getProfession());
            logger.info("Doctor created with id {}", doctor.getId());
            return doctor;
        }else {
            jdbcTemplate.update("""
                    update doctor set
                            name = ?,
                            surname = ?,
                            phone_number = ?,
                            address = ?,
                            email = ?,
                            avatar = ?,
                            profession = ?
                    where 
                        id = ?""",
                    doctor.getName(), doctor.getSurname(), doctor.getPhoneNumber(), doctor.getAddress(), doctor.getEmail(),
                    doctor.getAvatar(), doctor.getProfession(), doctor.getId());
            return doctor;
        }

    }

    public Optional<Doctor> findById(Long id) {
        try {
            Doctor doctor = findById0(id);
            return Optional.ofNullable(doctor);
        }catch(EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    private Doctor findById0(Long id) {
        return jdbcTemplate.queryForObject("select * from doctor where id = ?", this, id);
    }


    @Override
    public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Doctor doctor = new Doctor();
        doctor.setId(rs.getLong("id"));
        doctor.setName(rs.getString("name"));
        doctor.setSurname(rs.getString("surname"));
        doctor.setPhoneNumber(rs.getString("phone_number"));
        doctor.setAddress(rs.getString("address"));
        doctor.setEmail(rs.getString("email"));
        doctor.setAvatar(rs.getString("avatar"));
        doctor.setProfession(rs.getString("profession"));
        return doctor;

    }

    public void deleteDoctorById(Long id) {
        int count = jdbcTemplate.update("delete from doctor where id = ?", id);
        idNotFound(count, id);

    }
    private static void idNotFound(int count, Long id) {
        if (count == 0) {
            throw new RuntimeException("Doctor with id" + id + " not found or doesn't exist");
        }
    }
}
