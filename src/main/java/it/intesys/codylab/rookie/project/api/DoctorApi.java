package it.intesys.codylab.rookie.project.api;

import it.intesys.codylab.rookie.project.dto.DoctorDto;
import it.intesys.codylab.rookie.project.service.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class DoctorApi {
    @Autowired
    DoctorService doctorService;

    Logger logger = LoggerFactory.getLogger(DoctorApi.class);
    @PostMapping("/api/doctor")
    DoctorDto createAccount(@RequestBody DoctorDto accountDto){
}




}
