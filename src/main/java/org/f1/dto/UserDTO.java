package org.f1.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String username;
    //private String password;
    private int score;
}
