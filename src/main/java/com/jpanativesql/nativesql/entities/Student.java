package com.jpanativesql.nativesql.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="fname")
    private String firstName;
    @Column(name="lname")
    private String lastName;
    private int score;
    @Override
    public String toString(){
        return "Student [id="+id+",firstName="+firstName+",lastName="+lastName+", score="+score+"]";
    }
}


