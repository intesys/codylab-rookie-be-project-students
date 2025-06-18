package it.intesys.codylab.rookie.project.mapper;

import it.intesys.codylab.rookie.project.domain.BloodType;
import it.intesys.codylab.rookie.project.domain.Patient;
import it.intesys.codylab.rookie.project.dto.BloodTypeDto;
import it.intesys.codylab.rookie.project.domain.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    BloodType toDomain (BloodTypeDto dto) {
        return BloodType.valueOf(dto.name());
    }

    BloodTypeDto toDto (BloodType domain) {
        return BloodTypeDto.valueOf(domain.name());
    }

}
