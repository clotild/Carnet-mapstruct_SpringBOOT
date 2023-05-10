package com.example.tpcarnet.entity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class UserDTO {
    private long id;
    private String email;
    private List<ContactDTO> contacts;

}
