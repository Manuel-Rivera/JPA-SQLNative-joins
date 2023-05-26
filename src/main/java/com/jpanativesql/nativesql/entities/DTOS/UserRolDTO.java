package com.jpanativesql.nativesql.entities.DTOS;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRolDTO implements Serializable{
    private String username;
    private String role;
}
