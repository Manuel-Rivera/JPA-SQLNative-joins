package com.jpanativesql.nativesql.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jpanativesql.nativesql.entities.DTOS.UserRolDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
@Service
public class UserRolService {
    @PersistenceContext
	private EntityManager entityManager;
    public List<UserRolDTO> getUserRol(){
        String sql="select u.username,us.role from users u JOIN user_roles us where u.username='user1';";
        Query query=entityManager.createNativeQuery(sql);
        List<?> resultlist = query.getResultList();
        List<UserRolDTO> userlist=new ArrayList<>();
        for(Object result:resultlist){
            if(result instanceof Object[]){
                Object[] row=(Object[]) result;
                UserRolDTO userRolDTO = new UserRolDTO();
                userRolDTO.setUsername((String) row[0]);
                userRolDTO.setRole((String) row[1]);
                userlist.add(userRolDTO);
                
            }
        }
        return userlist;
    }
}
