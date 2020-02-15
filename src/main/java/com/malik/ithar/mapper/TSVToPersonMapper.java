package com.malik.ithar.mapper;

import com.malik.ithar.dto.PersonDTO;
import com.malik.ithar.model.PersonEntity;
import org.mapstruct.Mapper;

@Mapper
public interface TSVToPersonMapper {

    PersonEntity map(PersonDTO dto);
}
