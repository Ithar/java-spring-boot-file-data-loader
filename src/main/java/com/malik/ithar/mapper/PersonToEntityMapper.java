package com.malik.ithar.mapper;

import com.malik.ithar.dto.PersonDTO;
import com.malik.ithar.model.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonToEntityMapper {

    PersonToEntityMapper INSTANCE = Mappers.getMapper(PersonToEntityMapper.class);

    @Mappings({
            @Mapping(target = "departmentEntity.code", source = "deptCode"),
            @Mapping(target = "departmentEntity.name", source = "deptName"),
            @Mapping(target = "departmentEntity.region", source = "deptRegion")
    })
    PersonEntity map(PersonDTO dto);
}
