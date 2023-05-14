package com.hom3.Flyway.UserInformation.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ContactDTO {
    private Long id;
    private String name;
    private String phone;
    private String email;
}
