package com.example.tpcarnet.api;

import com.example.tpcarnet.entity.dto.UserDTO;
import com.example.tpcarnet.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper (componentModel = "spring", uses = {ContactMapper.class})
public interface UserMapper {
      @Mapping(source = "user.contactList", target = "contacts")
       UserDTO userToUserDTO(User user);
}
