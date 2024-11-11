package com.java.crud.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserData implements Serializable {

    private Long id;

    private String name;

    private String mobile;

    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
