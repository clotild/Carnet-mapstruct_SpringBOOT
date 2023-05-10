package com.example.tpcarnet.api;

import com.example.tpcarnet.entity.dto.ContactDTO;
import com.example.tpcarnet.entity.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContactMapper {
   //@Mapping(source = "contact.userDTOList", target = "users")
    ContactDTO contactToContactDTO(Contact contact);
}
