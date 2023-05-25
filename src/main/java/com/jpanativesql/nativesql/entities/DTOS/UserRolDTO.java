package com.jpanativesql.nativesql.entities.DTOS;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRolDTO implements Serializable,IUserRolDTO{
    private String username;
    private String role;
    @Override
    public String getusername() {
        return this.username;
    }
    @Override
    public String getrole() {
        return this.role;
    }
}
