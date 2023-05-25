package com.jpanativesql.nativesql.entities.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRolDTO {
    private String username;
    private String role;
}
