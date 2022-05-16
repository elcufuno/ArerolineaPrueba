package com.example.restservice.dto;

import lombok.Data;

@Data
public class UserDTO {
    int id;
    private String user;
    private String password;
    private String identification;
}
