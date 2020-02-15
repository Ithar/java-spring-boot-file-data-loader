package com.malik.ithar.mapper;

import com.malik.ithar.dto.PersonDTO;
import com.malik.ithar.model.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CSVToPersonMapper {

    CSVToPersonMapper INSTANCE = Mappers.getMapper(CSVToPersonMapper.class);

    PersonEntity map(PersonDTO dto);
}
