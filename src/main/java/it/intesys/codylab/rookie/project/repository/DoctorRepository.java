package it.intesys.codylab.rookie.project.repository;

import it.intesys.codylab.rookie.project.domain.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public class DoctorRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public void save (Doctor doctor){
        if(doctor.getId() == null){
            Long id = jdbcTemplate.queryForObject("select nextval ('account_id_generator') ", Long.class);
            doctor.setId(id);

            jdbcTemplate.update("""
                    insert into doctor (id, name, surname,phoneNumber, address, email, avatar, profession)
                    values (?, ?, ?, ? , ?, ? ,?)""",
                    id,
                    doctor.getName (),
                    doctor.getSurname (),
                    doctor.getPhoneNumber(),
                    doctor.getEmail(),
                    doctor.getAddress(),
                    doctor.getAvatar(),
                    doctor.getProfession(),
                 doctor.setId(id);
        } else {
            jdbcTemplate.update("""
                   update doctor set
                    
                      name = ?,
                      surname = ?,
                      phoneNumber = ?,
                      email = ?,
                      address = ?,
                      avatar = ?,
                      profession = ? 
                    where
                      id = ?""",

                    doctor.getName (),
                    doctor.getSurname (),
                    doctor.getPhoneNumber(),
                    doctor.getEmail(),
                    doctor.getAddress(),
                    doctor.getAvatar(),
                    doctor.getProfession(),
                    doctor.getId());
        }
}
